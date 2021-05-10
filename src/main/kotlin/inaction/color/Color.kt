package inaction.color

import inaction.color.Color.*        //해당 형식으로 사용하면 매우 접근성이 쉬워 진다. // java 도 마찬가지다.

// Kotlin 은 `enum study.class` 를 사용
// java 는 `enum` 을 사용.
// Kotlin 에서는 enum 을 `Soft keyword` 라 부른다. 단지 study.class 앞에서만 의미를 가지는 단어일뿐이며, 다른곳에서는 예약어로써 사용못하는 단어가 아니다. 단, study.class 는 키워드로 이름으로 사용할 수 없다.
//  또한, 단순히 열거하는 존재가 아닌, Property 나 method 를 정의 할 수 있다.
enum class Color(
    val r : Int,
    val g : Int,
    val b : Int
) {
    RED(255, 0, 0), ORANGE(255, 165, 0),
    YELLOW(255, 255, 0), GREEN(0, 255, 0), BLUE(0, 0, 255),
    INDIGO(75, 0, 130), VIOLET(238, 130, 238);      //Kotlin 에서 유일하게 semi-colon(;)을 사용하는 부분.

    fun rgb() = (r * 256 + g) * 256 + b
}

// Kotlin 에서는 when 으로 switch 와 같게 분기처리를 진행함.
//  break 문을 매 코드에 붙이지 않아도 됨.
fun geoMnemonic(color: Color) =
    when (color){
        RED -> "Richard"
        ORANGE -> "Of"
        YELLOW -> "York"
        GREEN -> "Gave"
        BLUE -> "Battle"
        INDIGO -> "In"
        VIOLET -> "Vain"
    }
// 여러 값을 매치 할 경우에는 콤마(,)로 분기 처리
fun geoWarmth(color: Color) =
    when(color){
        RED, ORANGE, YELLOW -> "warm"
        GREEN -> "neutral"
        BLUE, INDIGO, VIOLET -> "cold"
    }

//아래의 when 의 모든 분기 조건에 있는 객체 사이에 매치할 때 동등성(equality) 을 사용한다.
fun mix(c1: Color, c2: Color) =
    when(setOf(c1, c2)) {
        setOf(RED, YELLOW) -> ORANGE
        setOf(YELLOW, BLUE) -> GREEN
        setOf(BLUE, VIOLET) -> INDIGO
        else -> throw Exception("Dirty color")
    }
// 상위 mix 의 객체 비교를 위한 불필요한 객체를 생성하는 garbage 성 데이터가 많다는걸 알 수 있다.
fun mixOptimized(c1: Color, c2: Color) =
    when {
        (c1 == RED && c2 == YELLOW) ||
                (c1 == YELLOW && c2 == RED) ->
            ORANGE

        (c1 == YELLOW && c2 == BLUE) ||
                (c1 == BLUE && c2 == YELLOW) ->
            GREEN

        (c1 == BLUE && c2 == VIOLET) ||
                (c1 == VIOLET && c2 == BLUE) ->
            INDIGO

        else -> throw Exception("Dirty color")
    }

fun main(args : Array<String>){
    println("Blue RGB : ${BLUE.rgb()}")
    println("Blue GeoMnemonic  : ${geoMnemonic(BLUE)}")
    println("Blue geoWarmth  : ${geoWarmth(BLUE)}")
    println("Mix Color  : ${mix(BLUE,YELLOW)}")
    try {
        //exception
        mix(BLUE,INDIGO)
    }catch (e: Exception){
        println(e.message)
    }
    println("Mix Optimize Color  : ${mixOptimized(YELLOW, RED)}")
}