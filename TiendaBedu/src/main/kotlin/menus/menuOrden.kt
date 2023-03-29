package menus

import inventario.Inventario
import orden.Estados
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
            2 -> listaDeOrdenes()
//            3 -> eliminarOrden()
//            4 -> menuPrincipal()
            4 -> println("Saliendo")
            else -> {
                println("Opción no válida")
            }
        }

    } while (opc != 4)

}

fun listaDeOrdenes(){
    val ordenes = arregloOrden
    println("""
            Ordenes:
            ------------------------------------------------------------------------------------------------------------------------
        """.trimIndent())
    ordenes.forEach{

        println("No. de orden: ${it.noOrden}  fecha de creación: ${it.fechaCreacion}   estado de la orden: ${it.statusOrden}")
        it.visualizarListaProductos()
        println("""
            ------------------------------------------------------------------------------------------------------------------------
        """.trimIndent())
        println("Total: ${500}")
    }
}
//val orden = Orden()

fun crearOrden() {

    var opc: Int

    val orden = Orden()
    arregloOrden.addLast(orden)

    println("Productos disponibles: ")

    do {
        Inventario.visualizarInventario()

        println("Número de orden: ${orden.noOrden}")
        orden.visualizarListaProductos()

        println("1. Agregar productos")
        println("2. Confirmar Orden")
//        println("3. Cancelar orden")
        println("4. Regresar")
        print("Ingrese una opción: ")
        opc = readLine()?.toInt() as Int

        when(opc){
            1 -> agregarOrdenProducto(orden)
            2 -> confirmarOrden(orden)
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

fun confirmarOrden(orden: Orden){
    if(orden.listaProducto.isEmpty()){
        println("No se púede procesar compra porque aún no tiene productos agregados")
        return
    }

    if(orden.statusOrden != Estados.PENDIENTE){
        println("Esta orden ya fue procesada")
        return
    }

    println("""
            ------------------------------------------------------------------------------------------------------------------------
            Confirmación de Orden No. ${orden.noOrden}:
    """.trimIndent())

    orden.visualizarListaProductos()
    println("""
            ------------------------------------------------------------------------------------------------------------------------
    """.trimIndent())
    println("Total a pagar: $${orden.calcularTotal()}")

    var opc: Int

    do{
        println("1. Pagar")
        println("2. Regresar")
        print("Ingrese una opción: ")
        opc = readLine()?.toInt() as Int

        when(opc){
            1 -> {
                orden.procesarOrden()
                println("Gracias por su compra!")
                opc = 2
            }
            2 -> println("Regresando a menu de ordenes")
            else -> println("Opción no válida")
        }
    }while(opc !=2)




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