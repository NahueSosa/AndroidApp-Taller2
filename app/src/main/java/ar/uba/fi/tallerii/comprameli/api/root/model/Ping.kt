package ar.uba.fi.tallerii.comprameli.api.root.model

class Ping(var ping: Int = 0) {
    fun isPongOk () : Boolean {
       return ping == 1
    }
}
