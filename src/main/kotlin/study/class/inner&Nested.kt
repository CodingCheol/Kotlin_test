package study.`class`

class Outer{
    private val bar : Int = 1
    class Nested {
        //중첩 클래스는 외부 클래스를 참조하고 있지 않기에, 변수를 사용하지 않습니다.
        fun foo() = 2
    }
    inner class Innered {
        //내부 클래스는 외부 클래스를 참고하기 있기에 변수를 사용할 수 있습니다.
        fun foo() = bar
    }
}

fun main() {
    //java(nested) : https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html
    //kotlin(nested, inner) : https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html
    val nestedFoo = Outer.Nested().foo()
    val inneredFoo = Outer().Innered().foo()
    println("중첩(nested) 클래스 : $nestedFoo")
    println("내부(inner) 클래스 : $inneredFoo")
}
