package study.Generics


fun <T> addNumbers(num1: T, num2: T): String {
    return (num1.toString() + num2.toString())
}
// T 타입 에 대한 정의는 필요 없음
val ss = addNumbers(10,35).also { println(it) }
val ss2 = addNumbers(10,30).also { println(it) }

// T 타입 에 대한 정의가 필요
// T에 대한 정의를 안하면 아래 처럼 막 사용된다.
open class Rectangle<T>(val witdh: T, val height : T)
class RectangleUp<T, K>(witdh: T, height : T ,val name : K)  : Rectangle<T>(witdh,height){
}

val aa = Rectangle<String>("10","20").also { println("${it.witdh}  ${it.height}") }
val aa2 = Rectangle<Int>(10,202).also { println("${it.witdh}  ${it.height}") }
val aa3 = RectangleUp<Int,String>(10,202,"2").also { println("${it.witdh}  ${it.height} ${it.name}" ) }

//Constraint : 제약 걸기
// 단일 : Java 상속과 같음.
open class RectangleConstraints<T : Number>(val witdh: T, val height : T)
// 다단 : Where 를 이용.(Comparable 이 될려면 두개가 완전히 일치해야 함.)
open class RectangleConstraints2<T>(val witdh: T, val height : T) where T:Number, T: Comparable<T>

//Super type 이 Number 인 객체만 T를 허용
val bb = RectangleConstraints(10,1231).also { println("${it.witdh}  ${it.height}") }
val bb2 = RectangleConstraints(10.22,1231).also { println("${it.witdh}  ${it.height}") }
val bb3 = RectangleConstraints2(10,1231).also { println("${it.witdh}  ${it.height}") }


//in이 안먹힘..
//study.class Rectangle5<in T: Number>(val width: T, val height: T) {
//}
class Rectangle6<out T: Number>(val width: T, val height: T) {
}

fun test(args: Array<String>) {
    //
//    val derivedClass = Rectangle5<Number>(10.5, 20.5)
//    val baseClass : Rectangle5<Double> = derivedClass
    //
    val derivedClass2 = Rectangle6<Double>(10.5, 20.5)
    val baseClass2 : Rectangle6<Number> = derivedClass2
}

fun main(){}
