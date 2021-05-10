package inaction.geometry.shapes  //package

import java.util.*

class Rectangle(val height : Int, val width : Int) {
    val isSquare : Boolean
        /*
        // 하위와 같은 뜻 (블록이 본문인 함수 -> 식이 본문인 함수)
        get() {     //Property 의 getter 선언
            return height == width
        }
        */
        get() = height == width
}

fun createRandomRectangle() : Rectangle {
    val random = Random()
    return Rectangle(random.nextInt(), random.nextInt())
}

fun main() {
    val rectangle = Rectangle(2,2)
    println("isSquare : ${rectangle.isSquare}")
}