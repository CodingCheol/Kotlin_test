
//Late initialize
class Rectangle{
    lateinit var area  : Area
    fun initArea(param : Area){
        this.area = param
    }
}
class Area(val value : Int)

fun lateInitFnc (){
    val rectangle  = Rectangle()
    //아래 코드 주석을 제거하면 UninitializedPropertyAccessException 발생.
    //println(rectangle.area.value)
    rectangle.initArea(Area(10))
    println(rectangle.area.value)
}

//Lazy initialize
class Account(){
    val balance : Int by lazy {
        println("Setting Lazy")
        200
    }
}

fun lazyInitFnc (){
    val account = Account()
    println(account.balance)
    println(account.balance)
}

fun main() {
    lateInitFnc()
    lazyInitFnc()
}
