package com.lpraat.circuitbreaker.enginetest

import com.lpraat.circuitbreaker.engine.CollisionDetector
import com.lpraat.circuitbreaker.engine.CollisionDetector.{CLine, CPoint}
import org.scalatest.FunSuite


class CollisionDetectorTest extends FunSuite {
  test ("Collision") {

    val l1 = CLine(CPoint(-3, 2), CPoint(-2, 4))
    val l2 = CLine(CPoint(-3, 6), CPoint(1, 4))

    assert(CollisionDetector.intersection(l1.p1, l1.p2, l2.p1, l2.p2).isEmpty)

    val l3 = CLine(CPoint(-3, 2), CPoint(-1, 6))
    val intersectionPoint = CollisionDetector.intersection(l2.p1, l2.p2, l3.p1, l3.p2)

    assert(intersectionPoint.isDefined)
    assert(intersectionPoint.get.x == -1.4)
    assert(intersectionPoint.get.y == 5.2)
  }

}
