package study.Delegates

import kotlin.properties.Delegates

//study.Delegates.Notnull
//? 굳이 써야 해? 머지..?
fun delegateNotNull(){
    //Null 값을 넣을 수 있음.
    var nullString : String? =  null
    println("null value is : $nullString")
    //Null 값을 넣을 수 없음.
    var notNullString : String by Delegates.notNull()
    // Null 값을 도출 할때 에러가 발생.
    //error 발생.
    println("Non null value is : $notNullString")
    notNullString = "test"
}

fun main() {
    delegateNotNull()
}
