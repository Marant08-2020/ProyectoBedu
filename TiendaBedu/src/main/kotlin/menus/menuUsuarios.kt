package menus

import user.User
import java.util.LinkedList
import menus.menuPrincipal


fun inicioSesion(){
    var opc: Int

    do {
        println("1. Iniciar sesión")
        println("2. Crear user")
        println("3. Cambiar pasword")
        println("4. Salir")
        print("Ingrese una opción: ")
        opc = readLine()?.toInt() as Int

        when (opc) {
            1 -> iniciarSesion()
            2 -> crearUser()
            3 -> cambiarPassword()
            4 -> println("Saliendo del menu")
            else -> {
                println("Opción no válida")
            }
        }

    } while (opc != 4)

}
// Variable global de usuarios
var arregloUser =  LinkedList<User>()

// Funcion que instancia y crear usuarios
fun crearUser(){

    print("Nombre:")
    val name =readln()
    print("Apellido:")
    val apellido =readln()
    print("Email:")
    val email =readln()
    print("Contraseña:")
    val password =readln()

    val usuario = User(nombre = name,
        apellido = apellido, email = email,
        password = password)
    println("Se agredo el userio con id:${usuario.id}")

    arregloUser.addLast(usuario)



}
// Función que inicia sesión usando el id del usuario
fun iniciarSesion() {
    if(arregloUser.isEmpty()){
        println("**Por favor agregar usuarios**")
    }else{
        print("UserID:")
        val userId =readln().toInt()
        print("Constraseña:")
        val passwordUser =readln()
        // Funcion lambda
        val loginUser = arregloUser.
        filter { User-> User.id == userId }
        if (loginUser.isEmpty()){
            println("**El usuario no existe**")
        }else{
            if( loginUser[0].password == passwordUser){
                menuPrincipal()
            }else{
                println("***Contraseña inválidad***")
            }
        }

    }
}

fun cambiarPassword(){
    print("UserID:")
    val userId =readln().toInt()
    val userAmodificar = arregloUser.filter { User-> User.id == userId }
    if(userAmodificar.isEmpty()){
        println("***Usuario no encontrado***")

    }else{
        print("contraseña nueva:")
        val nuevoPassword =readln()
        print("Con firmar contraseña nueva:")
        val confirmarPassword =readln()
        if(nuevoPassword== confirmarPassword){
            // usa el set de la class data
            userAmodificar[0].password = nuevoPassword
            println("***Contraseña modificada***")
        }else{
            println("***Validar contraseña***")
        }

    }

}