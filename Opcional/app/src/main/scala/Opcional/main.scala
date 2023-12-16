package Opcional

import org.scalameter.{Warmer, withWarmer}
import scala.util.Random

object main {
  val obj = new Opcional()

  def generateRandomNumbers(min: Int, max: Int): (Int, Int) = {
    val random = new Random()
    val random1 = random.nextInt(max - min + 1) + min
    val random2 = random.nextInt(max - min + 1) + min
    (random1, random2)
  }


  def main(args: Array[String]): Unit = {



    val (num1, num2) = generateRandomNumbers(1, 100)


    print("Multiplicacion de productoPunto: \n")

    print(obj.Benchmark.compararProdPunto(1000))
    print(obj.Benchmark.compararProdPunto(10000))


  }
}
