package taller4

import org.scalameter.{Warmer, withWarmer}

object main {
  type Matriz = Vector[Vector[Int]]
  val obj = new Taller4()
  /*
  def main(args: Array[String]): Unit = {

    val matriz1: Matriz = Vector(
      Vector(1, 2, 3, 4),
      Vector(5, 6, 7, 8),
      Vector(9, 10, 11, 12),
      Vector(13, 14, 15, 16)
    )
    val matriz2: Matriz = Vector(
      Vector(16, 15, 14, 13),
      Vector(12, 11, 10, 9),
      Vector(8, 7, 6, 5),
      Vector(4, 3, 2, 1)
    )

    println(obj.multStrassenPar(matriz1,matriz2))
  }
*/

  //IMPLEMENTACIONES DE FUNCIONES DE BENCHMARKING

  def main(args: Array[String]): Unit = {
    println(
      withWarmer(new Warmer.Default) measure {
        (1 to 100000000).toArray
      }
    )
    /*
    print("Mutilplicacion de matrices recursivo: \n")
    for {
      i <- 1 to 8
      m1 = obj.matrizAlAzar(math.pow(2, i).toInt, 2)
      m2 = obj.matrizAlAzar(math.pow(2, i).toInt, 2)
    } yield (println("Tamano de la matriz: " + math.pow(2, i).toInt +
      "\nTiempo secuencial, Paralelo, aceleracion: " + obj.Benchmark.compararAlgoritmos2(obj.multMatrizRec, obj.multMatrizRecPar)(m1, m2)))


    print("\n")
    print("Mutilplicacion de matrices: \n")
    for {
      i <- 1 to 8
      m1 = obj.matrizAlAzar(math.pow(2, i).toInt, 2)
      m2 = obj.matrizAlAzar(math.pow(2, i).toInt, 2)
    } yield (println("Tamano de la matriz: " + math.pow(2, i).toInt +
      "\nTiempo secuencial, Paralelo, aceleracion: " + obj.Benchmark.compararAlgoritmos2(obj.multMatriz, obj.multMatrizPar)(m1, m2)))


     */
/*
    print("\n")
    print("Mutilplicacion con el algoritmo de Strassen: \n")
    for {
      i <- 1 to 10
      m1 = obj.matrizAlAzar(math.pow(2, i).toInt, 2)
      m2 = obj.matrizAlAzar(math.pow(2, i).toInt, 2)
    } yield (println("Tamano de la matriz: " + math.pow(2, i).toInt +
      "\nTiempo secuencial, Paralelo, aceleracion: " + obj.Benchmark.compararAlgoritmos2(obj.multStrassen, obj.multStrassenPar)(m1, m2)))
*/
    print("Multiplicacion de productoPunto: \n")

    print(obj.Benchmark.compararProdPunto(1000))
    print(obj.Benchmark.compararProdPunto(10000))


  }
}
