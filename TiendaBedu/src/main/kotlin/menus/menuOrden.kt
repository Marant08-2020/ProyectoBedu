package menus

import orden.Orden
import user.User
import java.util.*

// Variable global de ordenes
var arregloOrdenes =  LinkedList<Orden>()

fun menuOrden(){
    println("\n********** Menú de Ordenes ***********")
//    println("usuario con el que se registrará la orden: ${usuario.id}")
    var opc: Int

    do {
        println("1. Crear nueva orden")
        println("2. Ver lista de ordenes")
        println("3. Eliminar orden")
        println("4. Regresar a menú principal")
        print("Ingrese una opción: ")
        opc = readLine()?.toInt() as Int

        when (opc) {
            1 -> crearOrden()
//            2 -> listaDeOrden()
//            3 -> eliminarOrden()
            4 -> menuPrincipal()
            else -> {
                println("Opción no válida")
            }
        }

    } while (opc != 4)

}

fun crearOrden(){
    println("\n")

    var opc: Int

    val orden = Orden()
//    println("Se agregó el usuario con id:${usuario.id}")

    arregloOrdenes.addLast(orden)

    do {
        println("Orden actual No. ${orden.noOrden}")

//        Productos en el carrito:
        if (orden.arregloProducto.isEmpty()){
            println("Aún no hay productos agregados")
        } else{
            println("Productos en el carrito: ")
            println(orden.arregloProducto)
        }

        println("1. agregar/quitar productos")
        println("2. Confirmar Orden")
        println("3. Cancelar orden")
        println("4. Regresar a menú principal")
        print("Ingrese una opción: ")
        opc = readLine()?.toInt() as Int

        when (opc) {
//            1 -> modificarOrden()
//            2 -> confirmarOrden()
//            3 -> cancelarOrden()
            4 -> menuOrden()
            else -> {
                println("Opción no válida")
            }
        }

    } while (opc != 4)
}