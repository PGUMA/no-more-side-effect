import lab.pguma.core.Value

fun main(args: Array<String>) {
    val result = Value("this is shelter sample.")
        .interrupt { println("sample process start....") }
        .map { it.length }
        .interrupt { println("word count is $it") }
        .map { if(it > 10) "more 10 words" else "less 10 words" }
        .interrupt { println("sample process end....") }
        .value()

    println("result is $result")
}