package ar.uba.fi.tallerii.comprameli.api.root.model

class HelloWorld {
    lateinit var hello: String

    fun isAHelloWorld() {
        !hello.isEmpty() && hello == "world"
    }
}
