/**
  * Taller 4 - Programación Concurrente
  * Autores: Carlos Alberto Camacho Castaño - 2160331
 *           Juan José Hernandez Arenas - 2259500
 *           Santiago Reyes Rodriguez - 2259738
 *           Carlos Alberto Camacho Castaño -2160331
  * Profesor: Carlos A Delgado
  */
package Opcional

import common._
import org.scalameter.{Warmer, withWarmer}
import taller4.main.obj

import scala.collection.parallel.immutable.ParVector
import scala.util.Random

class Opcional {
  def solucionIngenua(a: Int, n: Int): Int = {
    List.fill(n)(a).foldLeft(1)(_ * _)
  }

  // Estrategia de paralelización: Utilizamos el paralelismo a nivel de colección
  def solucionIngenuaPar(a: Int, n: Int): Int = {
    List.fill(n)(a).par.foldLeft(1)(_ * _)
  }

  def solucionRecursiva(a: Int, n: Int): Int = {
    if (n == 0) 1
    else if (n % 2 == 1) a * potenciaRecursiva(a, n - 1)
    else {
      val temp = potenciaRecursiva(a, n / 2)
      temp * temp
    }
  }

  // Estrategia de paralelización: Utilizamos paralelismo en la parte recursiva
  def solucionRecursivaPar(a: Int, n: Int): Int = {
    if (n == 0) 1
    else if (n % 2 == 1) a * potenciaParalela(a, n - 1)
    else {
      val (temp1, temp2) = parallel(potenciaParalela(a, n / 2), potenciaParalela(a, n / 2))
      temp1 * temp2
    }
  }



  object Benchmark {

    def compararAlgoritmos2(Funcion1: (Matriz, Matriz) => Matriz, Funcion2: (Matriz, Matriz) => Matriz)(m1: Matriz, m2: Matriz): (Double, Double, Double) = {
      val timeF1 = withWarmer(new Warmer.Default) measure {
        Funcion1(m1, m2)
      }
      val timeF2 = withWarmer(new Warmer.Default) measure {
        Funcion2(m1, m2)
      }

      val promedio = timeF1.value / timeF2.value
      (timeF1.value, timeF2.value, promedio)

    }

    def compararProdPunto(l: Int): (Double, Double, Double) = {
      val v1 = vectorAlAzar(l, 2)
      val v2 = vectorAlAzar(l, 2)
      val v1Par = vectorAlAzarPar(l, 2)
      val v2Par = vectorAlAzarPar(l, 2)

      val tiempoAlgoritmo1 = withWarmer(new Warmer.Default) measure {
        obj.prodPunto(v1, v2)
      }
      val tiempoAlgoritmo2 = withWarmer(new Warmer.Default) measure {
        obj.prodPuntoParD(v1Par, v2Par)
      }

      val promedio = tiempoAlgoritmo1.value / tiempoAlgoritmo2.value
      (tiempoAlgoritmo1.value, tiempoAlgoritmo2.value, promedio)
    }
  }



}

