/**
  * Taller 4 - Programación Concurrente
  * Autores: Carlos Alberto Camacho Castaño - 2160331
 *           Juan José Hernandez Arenas - 2259500
 *           Santiago Reyes Rodriguez - 2259738
 *           Carlos Alberto Camacho Castaño -2160331
  * Profesor: Carlos A Delgado
  */
package opcional

import common._
import org.scalameter.{Warmer, withWarmer}
import opcional.main.obj
import org.scalameter._
import java.util.concurrent.{ForkJoinPool, RecursiveTask, ForkJoinTask, ForkJoinWorkerThread}
import scala.concurrent.ExecutionContext
import java.util.concurrent.{Callable, Executors}

import scala.collection.parallel.immutable.ParVector
import scala.util.Random

class Opcional {
  def solucionIngenua(a: Int, n: Int): Int = {//definimos la funcion de solucion ingenua
    (1 to n).foldLeft(1)((acc, _) => acc * a)
  }

  def solucionIngenuaPar(a:Int,n:Int): Int = {//definimos la funcion de solucion ingenua de forma paralela
    implicit val pool: ForkJoinPool = new ForkJoinPool()

    class Paralela(start: Int, end: Int) extends RecursiveTask[Int] {
      override def compute(): Int = {
        if (end - start <= 1) {
          a
        } else {
          val mid = start + (end - start) / 2
          val left = new Paralela(start, mid)
          val right = new Paralela(mid, end)

          ForkJoinTask.invokeAll(left, right)
          left.join() * right.join()
        }
      }
    }

    val result = new Paralela(0, n).fork().join()
    result
  }
  def solucionRecursiva(a: Int, n: Int): Int = {//definimos la solucion recursiva
    if (n == 0) 1
    else if (n % 2 == 1) a * solucionRecursiva(a, n - 1)
    else {
      val temp = solucionRecursiva(a, n / 2)
      temp * temp
    }
  }

  def solucionRecursivaPar(a: Int, n: Int): Int = {//definimos la funcion recursiva de forma paralela
    if (n == 0) 1
    else if (n % 2 == 1) a * solucionRecursivaPar(a, n - 1)
    else {
      val (temp1, temp2) = parallel(solucionRecursivaPar(a, n / 2), solucionRecursivaPar(a, n / 2))
      temp1 * temp2
    }
  }



  object Benchmark {

    def compararAlgoritmos2(Funcion1: (Int , Int ) => Int, Funcion2: (Int ,Int ) => Int)(a:Int, n:Int): (Double, Double, Double) = {
      val timeF1 = withWarmer(new Warmer.Default) measure {
        Funcion1(a, n)
      }//la funcion 1 y 2 reciben dos numeros, los cuales son a y n
      val timeF2 = withWarmer(new Warmer.Default) measure {
        Funcion2(a, n)
      }

      val promedio = timeF1.value / timeF2.value
      (timeF1.value, timeF2.value, promedio)

    }// definimos la funcion para comparar algoritmos con el benchmark


  }



}

