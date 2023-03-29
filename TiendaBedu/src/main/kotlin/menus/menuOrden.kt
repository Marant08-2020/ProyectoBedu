package menus

import inventario.Inventario
import orden.Orden
import producto.Producto
import user.User
import java.util.*

// Variable global de ordenes
var arregloOrden =  LinkedList<Orden>()

fun menuOrden(){
    println("\n********** Menú de Ordenes ***********")
//    println("usuario con el que se registrará la orden: ${usuario.id}")
    var opc: Int

    do {
        println("1. Crear nueva orden")
        println("2. Ver lista de ordenes")
        println("3. Eliminar orden")
        println("4. Salir")
        print("Ingrese una opción: ")
        opc = readLine()?.toInt() as Int

        when (opc) {
            1 -> crearOrden()
            2 -> listaDeOrden()
//            3 -> eliminarOrden()
//            4 -> menuPrincipal()
            4 -> println("Saliendo")
            else -> {
                println("Opción no válida")
            }
        }

    } while (opc != 4)

}

fun listaDeOrden(){
    val ordenes = arregloOrden
    println("""
            Ordenes:
            -------------------------------------------------------
        """.trimIndent())
    ordenes.forEach{

        println(it)
        println("""
            -------------------------------------------------------
        """.trimIndent())

    }
}
//val orden = Orden()

fun crearOrden() {

    var opc: Int

    val orden = Orden()
    arregloOrden.addLast(orden)

    println("ID de orden:${orden.noOrden}")
    println("Productos disponibles: ")
    Inventario.visualizarInventario()

    do {
        println("1. agregar/quitar productos")
        println("2. Confirmar Orden")
//        println("3. Cancelar orden")
        println("4. Regresar a menú principal")
        print("Ingrese una opción: ")
        opc = readLine()?.toInt() as Int

        when(opc){
            1 -> agregarOrdenProducto(orden)
//            2 -> confirmarOrden()
//            3 -> cancelarOrden()
            4 -> menuOrden()
            else -> println("Opción no válida")
        }

    }while (opc != 4)

}

fun agregarOrdenProducto(orden: Orden){
    println("Ingrese id del producto: ")
    val id_producto = readln().toInt()

    println("Ingrese la cantidad: ")
    val cantidad = readln().toInt()

    if (buscarOrden(orden.noOrden).isEmpty()){
        println("Orden no encontrada")
    }else{
        orden.agregarProductoOrden(id_producto, cantidad)
        println("productos agregados")

    }

}

fun buscarOrden(noOrden: Int): List<Orden>{
    val objetoOrden = arregloOrden.filter {Orden -> Orden.noOrden == noOrden}
    return objetoOrden
}




fun main(){
    Inventario.agregarProductoInventario(nombre = "Zapato", descripcion = "Zapato Blanco",
        tipo = "Calzado", modelo = "ZAP-00", precio = 330f, stock = 50, talla = 22.5f)

    Inventario.agregarProductoInventario(nombre = "Pantalon", descripcion = "Pantalón mezclila azul",
        tipo = "Ropa", modelo = "PA-00", precio = 700f, stock = 20, talla = 32F)

    Inventario.agregarProductoInventario(nombre = "Televisión", descripcion = "Tv led samsung 40 pulgadas",
        tipo = "Hogar", modelo = "SA-0002", precio = 100500f, stock = 10, numeroSerie = "STVMX-0001")

    menuOrden()
}