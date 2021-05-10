package study.`class`

inline class InlineClass(val str : String)

inline class Index(val str : String)
inline class IndexId(val str : String)

// User Info 를 compile 하면 index 의 Type 이 String 으로 들어간다.
// ## Inline Class
data class UserInfo(
    val index : Index,
    val indexId  :IndexId
)

fun classMain() {
    val nonInlineString : String = "Non Inline String"
    val inlineString  =  InlineClass("Inline String")

    //아래 처럼 사용이 가능.
    UserInfo(Index("sdes"), IndexId("sdes"))
}


// ## Inline Function
// inline : 파라미터로 고계함수를 사용한 함수 전달이나, 익명 클래스의 생성 비용을 줄일때 사용.(decompile 해보면 안다.)
// noinline : lambdas 식 표현에서 함께 사용을 하지만, 이 함수에서 호출하는 함수가 inline이 아닌 경우에 붙여줌.
// crossinline : 다른 함수의 고계함수 파라미터를 블록(block) 형태로 사용하는 경우에 사용.

// Inline function 은 scope functions 에서 아주 잘 활용되고 있다.
fun functionMain(){
    //실제 코드를 보면 block 호출의 코드가 제거되고, block 부분이 바깥으로 inline 된다.
    "inline Function : Scope".also { print(it) }
}

fun String?.notNull(body : String.()->Unit) {
    this?.body()
}
inline fun String?.notNull2(body : String.()->Unit) {
    this?.body()
}

fun test(){
    //DeCompile 시에 notnull 이라는 함수를 익명클래스를 호출하여 invoke 처리 된다.
    // 즉, 익명클래스를 지속적으로 생성하는 비용이 발생한다.
    // kotlin collection 에서 흔하게 사용되는 forEach, Map 등은 모두 inline을 활용하면 매우 좋을꺼 같다.
    "test".notNull { print("this is $this")}
    /*
    public static final void test() {
       notNull("test", (Function1)null.INSTANCE);
    }

    public static final void notNull(@Nullable String $this$notNull, @NotNull Function1 body) {
       Intrinsics.checkParameterIsNotNull(body, "body");
       if ($this$notNull != null) {
          Unit var10000 = (Unit)body.invoke($this$notNull);     // 익명 클래스 생성.
       }
    }
    */
    "test".notNull2 { print("this is test")}
    /*
    public static final void test() {
        String $this$notNull$iv = "test";
        String var4 = "this is " + $this$notNull$iv;
        System.out.println(var4);
    }
    */
}

fun main() {
    classMain()
    functionMain()
}