

fun main(args: Array<String>) {
    val name = if (args.size > 0) args[0] else "Kotlin"
    println("argument 1st :  ${args?:args[0]}") //'문자열 템플릿`을 이용하여서 첫번째 원소를 배.
    //문자열 템플릿 안에 존재하지 않는 변수가 있을 경우 컴파일시 오류 발생.
    println("Hello, $name!") //< JS의 문법 처럼 `문자열 템플릿` 사용이 가능하다.
    println("Hello, \$name!") //< `문자열 템플릿`이 아닌 그냥 문자 자체를 출력하고 싶을때는 이스케이프(\)를 이용하여 출력하면 된다..
    println("${name}님 반가워요") //< '님'자를 붙이게 된다면 에러가 발생한다.

    //한번에 끝내기
    println("Hello, ${if(args.size>0) args[0] else "someone" }!")

}

