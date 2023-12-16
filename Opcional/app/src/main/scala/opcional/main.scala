package opcional

import org.scalameter.{Warmer, withWarmer}
import scala.util.Random

object main {
  val obj = new Opcional()

  def generateRandomNumbers(min: Int, max: Int): (Int, Int) = {//la funcion para generar los numeros random
    val random = new Random()
    val random1 = random.nextInt(max - min + 1) + min
    val random2 = random.nextInt(max - min + 1) + min
    (random1, random2)
  }


  def main(args: Array[String]): Unit = {



    val (a,n) = generateRandomNumbers(1, 200)//generamos dos numeros random para calcular la potenciacion


    println("Valor de a: "+a)

    println("Valor de n: "+n)
    println("Solucion ingenua: "+obj.solucionIngenua(a,n))//imprimimos la solucion ingenua con los numeros aleatorios
    println("Solucion ingenua paralela: "+obj.solucionIngenuaPar(a,n))//imprimimos la solucion ingenua paralela con los numeros aleatorios
    println("Solucion recursiva : "+obj.solucionRecursiva(a,n))//imprimimos la solucion recursiva con los numeros aleatorios
    println("Solucion recursiva paralela : "+obj.solucionRecursivaPar(a,n))//imprimimos la solucion recursiva paralelacon los numeros aleatorios


    println("\nComparacion: ")
    println("(Tiempo de solucion ingenua, tiempo de solucion ingenua paralela, aceleracion)")
    println(obj.Benchmark.compararAlgoritmos2(obj.solucionIngenua , obj.solucionIngenuaPar)(a,n))//llamamos al benchmark para comparar las dos funciones, las cuales son la ingenua y la paralela ingenua
    println("(Tiempo de solucion recursiva, tiempo de solucion recursiva paralela, aceleracion)")
    println(obj.Benchmark.compararAlgoritmos2(obj.solucionRecursiva, obj.solucionRecursivaPar)(a,n))//llamamos al benchmark para comparar las dos funciones, las cuales son la recursiva y la paralela recursiva


  }
}
