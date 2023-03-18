package user

private var contadorUser: Int =0
data class User(var nombre: String,
                var apellido: String,
                var email: String,
                var password: String){

    var id: Int =0

    init {
        contadorUser += 1
        id = contadorUser

    }
    constructor(id: Int,
                nombre: String,
                apellido: String,
                email: String,
                password: String): this(email,nombre, apellido, password){
                    this.id = id
                }


}
