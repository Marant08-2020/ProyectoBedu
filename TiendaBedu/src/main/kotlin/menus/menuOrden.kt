package menus

import inventario.Inventario
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import orden.Estados
import orden.Orden
import java.util.*
import kotlin.collections.List

// Variable global de ordenes
var arregloOrden = LinkedList<Orden>()

fun menuOrden() {
    println("\n********** Menú de Ordenes ***********")
//    println("usuario con el que se registrará la orden: ${usuario.id}")
    var opc: Int

    do {
        println("1. Crear nueva orden")
        println("2. Ver lista de ordenes")
        println("3. Salir")
        print("Ingrese una opción: ")
        try {
//            opc = readlnOrNull()?.toInt() as Int
            opc = readlnOrNull()?.toIntOrNull() ?: 0
            when (opc) {
                1 -> {
                    val orden = Orden()
                    arregloOrden.addLast(orden)
                    modificarOrden(orden)
                }

                2 -> printListaDeOrdenes()
//            3 -> eliminarOrden()
//            4 -> menuPrincipal()
                3 -> {
                    println("Saliendo") //; return menuPrincipal()
                }

                else -> {
                    println("Opción no válida")
                }
            }
        } catch (exception: NumberFormatException) {
            opc = 0
            println("Solo acepta valores del 1..4")
        }
    } while (opc != 3)

}

fun printListaDeOrdenes() {     /*Es correcto que esta función este aquí en lugar de la clase orden?*/
    if (arregloOrden.isEmpty()) {
        println("No hay órdenes registradas aún.")
    } else {
        println(
            """
                Ordenes:
                ------------------------------------------------------------------------------------------------------------------------
            """.trimIndent()
        )
        arregloOrden.forEach {

            println("No. de orden: ${it.noOrden}  fecha de creación: ${it.fechaCreacion}   estado de la orden: ${it.statusOrden}")
            it.printListaProductos()
            println("\nTotal: ${it.calcularTotal()}")
            println(
                """
                ------------------------------------------------------------------------------------------------------------------------
            """.trimIndent()
            )
        }

        var opc: Int

        do {
            println("1. Modificar orden")
            println("2. Eliminar orden")
            println("4. Salir")
            print("Ingrese una opción: ")
            try {
//                opc = readlnOrNull()?.toInt() as Int
                opc = readlnOrNull()?.toIntOrNull() ?: 0
                when (opc) {
                    1 -> {
                        println("Ingrese número de orden a modificar: ")
                        val id = readln().toInt()
                        modificarOrden(buscarOrden(id)[0])
                    }

                    2 -> {
                        println("Ingrese número de orden a eliminar: ")
                        val id = readln().toInt()
                        eliminarOrden(buscarOrden(id)[0])
                        return
                    }

                    3 -> println("Saliendo")
                    else -> println("Opción no válida")
                }
            } catch (exception: IndexOutOfBoundsException) {
                opc = 0
                println("No se encontró orden con ese número.")
            } catch (exception: NumberFormatException) {
                opc = 0
                println("No se encontró orden con ese número.")
            }

        } while (opc != 3)
    }
}

fun modificarOrden(orden: Orden) {

    var opc: Int

    println("Productos disponibles: ")
    Inventario.visualizarInventario()
    do {

        println("Número de orden: ${orden.noOrden}")
        orden.printListaProductos()

        println("1. Agregar productos")
        println("2. Confirmar Orden")
        println("3. Cancelar orden")
        println("4. Regresar")
        print("Ingrese una opción: ")
        try {
//            opc = readlnOrNull()?.toInt() as Int
            opc = readlnOrNull()?.toIntOrNull() ?: 0

            when (opc) {
                1 -> agregarOrdenProducto(orden)
                2 -> confirmarOrden(orden)
                3 -> {
                    eliminarOrden(orden); return
                }
//            4 -> menuOrden()
                4 -> println("Saliendo")
                else -> println("Opción no válida")
            }
        } catch (exception: NumberFormatException) {
            opc = 0
            println("Solo acepta valores del 1..4")
        }
    } while (opc != 4)

}

fun eliminarOrden(orden: Orden) {
    if (arregloOrden.indexOf(orden) != -1) {
        arregloOrden.removeAt(arregloOrden.indexOf(orden))
        println("orden eliminada")
    } else {
        println("La orden no se encuentra registrada")
    }
}

fun agregarOrdenProducto(orden: Orden) {
    try {
        println("Ingrese id del producto: ")
        val idProducto = readln().toInt()

        println("Ingrese la cantidad: ")
        val cantidad = readln().toInt()

        if (buscarOrden(orden.noOrden).isEmpty()) {
            println("Orden no encontrada")
        } else {
            orden.agregarProductoOrden(idProducto, cantidad)
        }
    } catch (exception: NumberFormatException) {
        println("Solo se pueden ingresar valores numéricos")
    }
}

fun buscarOrden(noOrden: Int): List<Orden> {
    return arregloOrden.filter { Orden -> Orden.noOrden == noOrden }
}

fun confirmarOrden(orden: Orden) {
    orden.procesarOrden()

//    Tema de corrutinas
    runBlocking {
        println("Imprimiendo ticket\n")
        delay(2000)
        orden.ticketVenta()

    }

    menuOrden()
}
//fun confirmarOrden2(orden: Orden) {
//    if (orden.listaProducto.isEmpty()) {
//        println("No se puede procesar compra porque aún no tiene productos agregados")
//        return
//    }
//
//    if (orden.statusOrden != Estados.PENDIENTE) {
//        println("Esta orden ya fue procesada")
//        return
//    }
//
//    println(
//        """
//            ------------------------------------------------------------------------------------------------------------------------
//            Confirmación de Orden No. ${orden.noOrden}:
//    """.trimIndent()
//    )
//
//    orden.printListaProductos()
//    println("\nTotal a pagar: $${orden.calcularTotal()}")
//    println(
//        """
//            ------------------------------------------------------------------------------------------------------------------------
//    """.trimIndent()
//    )
//
//    var opc: Int
//
//    do {
//        println("1. Pagar")
//        println("2. Regresar")
//        print("Ingrese una opción: ")
//        try {
////            opc = readlnOrNull()?.toInt() as Int
//            opc = readlnOrNull()?.toIntOrNull() ?: 0
//
//            when (opc) {
//                1 -> {
//                    orden.procesarOrden()
//                    orden.ticketVenta()
//                    println("Gracias por su compra!")
//                    return menuOrden()
//                }
//
//                2 -> println("Regresando a menu de ordenes")
//                else -> println("Opción no válida")
//            }
//        } catch (exception: NumberFormatException) {
//            opc = 0
//            println("Solo acepta valores del 1..2")
//        }
//    } while (opc != 2)
//
//}

fun main() {
    Inventario.agregarProductoInventario(
        nombre = "Zapato", descripcion = "Zapato Blanco",
        tipo = "Calzado", modelo = "ZAP-00", precio = 330f, stock = 50, talla = 22.5f
    )

    Inventario.agregarProductoInventario(
        nombre = "Pantalon", descripcion = "Pantalón mezclila azul",
        tipo = "Ropa", modelo = "PA-00", precio = 700f, stock = 20, talla = 32F
    )

    Inventario.agregarProductoInventario(
        nombre = "Televisión", descripcion = "Tv led samsung 40 pulgadas",
        tipo = "Hogar", modelo = "SA-0002", precio = 100500f, stock = 10, numeroSerie = "STVMX-0001"
    )

    menuOrden()
}