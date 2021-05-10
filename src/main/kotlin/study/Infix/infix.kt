package study.Infix

//Primitive
infix fun String.add(other: String) = this + other

fun defaultInfixTest() {
    var prefix = "Hello" add "World "
    var string = "This " add "is " add "KCD"
    var result = prefix add string
    println("default study.Infix : $result ")
}

//Class version
class MyInfix{
    var str =  ""
    infix fun add(other: String) {
        this.str = this.str + other
    }
}
fun classInfixTest(){
    val string = MyInfix()
    string add "Hello"
    string add "World "
    string add "This "
    string add "is "
    string add "KCD"

    println("study.class study.Infix : ${string.str}")
}

fun main() {
    defaultInfixTest()
    classInfixTest()
}



