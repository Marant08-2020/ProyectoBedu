package menus

fun menuPrincipal() {
    var opc: Int
    do {
        println("1. Inventario de Productos")
        println("2. Crear Orden")
        println("3. Salir")
        print("Ingrese una opción: ")
        opc = readLine()?.toInt() as Int
        when (opc) {
            1 -> menuInventario()
            2 -> menuOrden()
            3 -> println("Saliendo del menu")
            else -> {
                println("Opción no válida")
            }
        }

    } while (opc != 3)

}

fun main() {
    menuPrincipal()
}