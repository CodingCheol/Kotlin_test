package study.constructor

class Constructor{
    private var test4  : Int = 2

    init {
        println("$test4")
    }
    constructor(test : Int, test2 :Int, test3:Int) : this(23,24){
        println("$test $test2 study.constructor $test4")
    }
    constructor(test : Int, test2 :Int) : this(test){
        println("$test $test2 constructor2 $test4")
    }
    constructor(test : Int){
        println("$test  constructor3 $test4")
    }

}

fun main(args : Array<String>){
    Constructor(12312,123,34534)
    Constructor(123,34534)
    Child("kcd",1232,"2021-04-12","남","강남")
    var ss = Test(1)

}

class Test(test: Int)

open class Parent{
    init{
        print("I'm Parent [ ")
    }
    constructor(name :String, age :Int){
        print("$name / $age")
    }
    constructor(name :String, age :Int, birthday : String): this(name,age){
        println("/ $birthday ]")
    }
}

class Child : Parent {
    init{
        print("I'm Child [ ")
    }
    constructor(name :String, age :Int, birthday : String, gender : String): super(name,age,birthday){
        print("$name / $age / $birthday / $gender")
    }
    constructor(name :String, age :Int, birthday : String, gender : String, address: String): this(name,age,birthday,gender){
        println("/ $address ]")
    }
}

