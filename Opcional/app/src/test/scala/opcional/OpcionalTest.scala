/**
 * Plantilla para pruebas
* @author Carlos Delgado
* @version 1.0
* @note 22 de Noviembre de 2023 
 */
package opcional

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner


import scala.collection.parallel.immutable.ParVector

@RunWith(classOf[JUnitRunner])
class OpcionalTest extends AnyFunSuite{

      test("testSolucionIngenua"){
        val obj = new Opcional()
        val a = 10
          val n=3
        assert(1000 == obj.solucionIngenua(a,n))
    }

    test("testSolucionIngenua2") {
        val obj = new Opcional()
        val a = 6
        val n = 7
        assert(279936 == obj.solucionIngenua(a, n))
    }
    test("testSolucionIngenuaPar") {
        val obj = new Opcional()
        val a = 8
        val n = 5
        assert(32768 == obj.solucionIngenuaPar(a,n))
    }
    test("testSolucionRecursiva") {
        val obj = new Opcional()
        val a = 2
        val n = 25
        assert(33554432== obj.solucionRecursiva(a,n))
    }
    test("testSolucionRecursiva2") {
        val obj = new Opcional()
        val a = 13
        val n = 5
        assert(371293 == obj.solucionRecursiva(a, n))
    }
    test("testSolucionRecursivaPar"){
        val obj = new Opcional()
        val a = 105
        val n = 3
        assert(1157625 == obj.solucionRecursivaPar(a,n))
    }





}
