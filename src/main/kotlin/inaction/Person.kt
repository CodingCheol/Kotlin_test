package inaction

//값 객체(Value Object)
// 기본 적략으로 생성됨(toString / hashCode / etc....)
// public 은 기본 접근자로써 생략이 가능하다.
//Kotlin property
// var, val 을 이용하여 자바의 필드와 접근자 메소드를 완전히 대신한다.
// val 로 선언한 프로퍼티는 읽기 전용이며, var 로 선언한 프로퍼티는 변경 가능하다.
// 파라미터를 var로 선언신 getter / setter 생성.
class Person(
    val name : String,          //읽기 전용으로 읽기를 위한 게터 제공.
    var isMarried : Boolean     //읽기/쓰기 전용으로 게터,세터를 제공
)

fun main() {
    val person = Person("11", false)
    //setter
    person.isMarried = true
    //getter
    println("person data1 : ${person.name}")
    println("person data2 : ${person.isMarried}")

}
