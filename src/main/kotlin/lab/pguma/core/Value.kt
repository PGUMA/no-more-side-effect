package lab.pguma.core

// TODO エラーハンドリングも上手くできる形に持っていきたい
class Value<V>(private val value:V) {

    fun <N> map(f: (V) -> N): Value<N> {
        return Value(f(value))
    }

    fun interrupt(f: (V) -> Unit): Value<V> {
        f(value)
        return this
    }

    fun value(): V {
        return value
    }
}

/**
 * 既存の関数をShelterでwrapされた型が返るように持ち上げる
 */
fun <I, O> lift(f: (I) -> O): (I) -> Value<O> {
    return { value: I -> Value(f(value)) }
}