package inaction.smartcast

// 현재 예시는 Tree 구조를 기반으로 생각하여 작성한다.

interface Expr
class Num(val value : Int) : Expr                       // 상속이 되어지는 과정을 보자: WoW ...
class Sum(val left : Expr, val right : Expr) : Expr     // Parameter 를 Expr 로 받는 이유는 Num 일수도있고, Sum 일 수도 있어서 이다. // Java도 비슷하게 코딩이 가능하다.

// Kotlin 은 If 를 이용하여 값을 만들어 내기에, '3항 연산자를 이용하지 않는다.'
// 프로그래머가 캐스팅을 지원하지 않고, 컴파일러가 is 로 검사하고 나면 굳이 변수를 원하는 타입으로 캐스팅 하지 않아도 알아서 컴파일시 캐스팅을 수행한다.
// 위와 같이 컴파일러가 컴파일시에 캐스팅을 진행하는 것을 '스마트 캐스팅' 이라고 한다.
fun eval(e: Expr): Int =
    if (e is Num) { // 'is' 는 Java 에서 'instanceof' 와 같은 뜻이다.
        // e 가 자동으로 Num Class 임을 알 수 있다.
        e.value
    } else if (e is Sum) {
        // e 가 자동으로 Sum Class 임을 알 수 있다.
        eval(e.right) + eval(e.left)
    } else {
        throw IllegalArgumentException("Unknown expression")
    }
// 만약 상위의 is 이후 스마트 캐스팅을 진행시에 var 이나 커스텀 접근자를 사용하는 경우에는 항상 같은 값을 내놓는다고 확신할 수 없기 때문에 사용할 수 없다.
// 원하는 타입으로 명시적으로 타입 캐스팅하려면 as 키워드를 사용하여야 한다.

fun evalWhen( e : Expr) : Int =
    when(e){
        is Num -> e.value
        is Sum -> evalWhen(e.right) + evalWhen(e.left)
        else -> throw IllegalArgumentException("Unknown expression")
    }
// 아래를 보면 블록의 마지막 식이 블록의 결과 라는 규칙을 가지며 쓸 수 있다.
// 다만, 함수에 대하여서는 성립하지 않으며, 식이 본문인 함수는 블록을 본문으로 가질 수 없고 블록이 본문인 함수는 내부에 return문이 반드시 있어야 한다.
fun evalWithLogging (e : Expr) : Int =
    when(e){
        is Num ->{
            println("num : ${e.value}")
            e.value
        }
        is Sum ->{
            val left = evalWithLogging(e.left)
            val right = evalWithLogging(e.right)
            println("sum : $left + $right ")
            left + right
        }
        else -> throw IllegalArgumentException("Unknown expression")
    }

fun main() {
    println( "Eval : ${eval(Sum(Sum(Num(1),Num(2)),Num(4)))}")
    println( "EvalWhen : ${evalWhen(Sum(Sum(Num(1),Num(2)),Num(4)))}")
    println( "EvalWithLogging : ${evalWithLogging(Sum(Sum(Num(1),Num(2)),Num(4)))}")
}