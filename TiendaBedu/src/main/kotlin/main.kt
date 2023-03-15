fun main() {
    var opc: Int
    // Menu de la aplicación
    do {
        println("1. Crear Producto")
        println("2. Crear Orden")
        println("3. Crear Venta")
        println("4. Salier")
        print("Ingrese una opción: ")
        opc = readLine()?.toInt() as Int

    } while (opc != 4)

}