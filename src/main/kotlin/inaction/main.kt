

// fun -> JS 에서 함수를 선언할때 생각하면 쉽게 이해가 갈것이다.
// Java 에서의 함수 선언형태와는 사뭇 다를 수 있다. => 함수형 언어의 특징인 first-study.class Function 로 인하여 혼란이 올 수도(?).
// 범위지정자도 존재한다.-> 다만 kotlin 의 간결성은 끝이 없다.. 불필요한 public 은 생략하는게 관례이다.
private fun main(args: Array<String>) {
    // System.out.println -> println
    // semi-colon(;) delete
    println("Hello World!")
}

// 블록이 본문인 함수.(`하위 식이 본문인 함수`는 리턴 타입이 단일 이다. 하지만 블록이 본문인 함수는 return 타입이 다수 일 가능성이 있다. 그래서 리턴 형태를 삭제 할 수 없다.)
fun max(a : Int, b :Int) : Int {
    return if(a > b) a else b
}

// 식이 본문인 함수.( `타입 추론` 을 통한 리턴 형태를 추론할 수 있다.)
fun max2(a : Int, b : Int) : Int =  if(a > b) a else b
fun max3(a : Int, b : Int) = if(a>b) a else b


private fun VarVerseVal(){

    val question = "삶, 우주, 그리고 모든 것에 대한 궁극적인 질문."
    val answer = 42
    val answer2 : Int = 43
    /*
    * 초기화 식의 타입을 변수 타입으로 지정한다. (반대로 초기화 식이 없다면 반드시 리턴 형태를 지정하여야 한다.)
    * 요런 식으로 지정하여야 한다.
    * val answer : Int
    * answer = 42
    * */

    /* var vs val */
    // var : 변경이 가능한 변수의 타입이다.(variable)
    // val : 한번 초기화 되면 다시는 변경이 불가능한 변수이다.(value)
    // 되도록이면 val 변수 처럼 불변 변수를 선언하고, 꼭 필요로 할 경우에만 var 변수를 사용하자.
    // fyi.) 불변 변수라 할지라도 내부 값은 변경될 수 있음을 유의하자.
    val languages = arrayListOf("java")
    languages.add("Kotlin") // < 요렇게 내부의 문자열 함수에 대한 값은 넣을 수 있다.
}




