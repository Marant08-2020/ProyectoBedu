package user

//private var contadorUser: Int =0
data class User(var id: Int =0,
                var nombre: String,
                var apellido: String,
                var email: String,
                var password: String){
    // Variable estática
    companion object{
        private var contadorUser: Int =0
    }
    init {
        contadorUser += 1

    }
    init {
        this.id= contadorUser
    }

}
