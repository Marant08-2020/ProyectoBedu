package user

private var contadorUser: Int =0
data class User(var id: Int =0,
                var nombre: String,
                var apellido: String,
                var email: String,
                var password: String){
    init {
        contadorUser += 1

    }
    init {
        this.id= contadorUser
    }

}
