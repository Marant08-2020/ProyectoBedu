package menus

fun menuPrincipal(){
    var opc: Int
    do {
        println("1. Crear Producto")
        println("2. Crear Orden")
        println("3. Crear Venta")
        println("4. Salir")
        print("Ingrese una opción: ")
        opc = readLine()?.toInt() as Int

    } while (opc != 4)

}