package menus

import  inventario.Inventario

fun menuInventario() {

    var opc: Int

    do {
        println("1. Agregar producto")
        println("2. Visualizar inventario")
        println("3. Eliminar producto")
        println("4. Actualizar Stock")
        println("5. Salir")
        print("Ingrese una opción: ")
        try {
            opc = readLine()?.toInt() as Int
            when (opc) {
                1 -> agregarProducto()
                2 -> visulizarInventario()
                3 -> eliminarProducto()
                4 -> actualizarInventario()
                5 -> println("Saliendo del menu")
                else -> {
                    println("Opción no válida")
                }
            }
        }catch (exception: NumberFormatException){
            opc=0
            println("Solo acepta valores del 1..4")

        }
    } while (opc != 5)
}

fun agregarProducto(){
    var tallaProducto: Float = 0f
    val serieProducto: String = " "
    print("Nombre del producto:")
    val nombreProducto: String = readln()
    print("Descripción del producto:")
    val descripcionProducto: String = readln()
    print("Modelo del producto:")
    val modeloProducto: String = readln()
    print("Tipo de producto:")
    var tipoProducto: String = readln()
    tipoProducto = tipoProducto.lowercase()
    if (tipoProducto=="calzado" || tipoProducto=="ropa"){
       print("Talla de producto:")
       tallaProducto = readln().toFloat()
    }else if(tipoProducto=="hogar"){
      print("Número de serie:")
      val serieProducto: String = readln()
    }
    print("Precio del producto:")
    val precioProducto: Float = readln().toFloat()
    print("Stock del producto:")
    val stockProducto: Int = readln().toInt()

    Inventario.agregarProductoInventario(nombre = nombreProducto, descripcion = descripcionProducto,
                                         modelo = modeloProducto, tipo = tipoProducto,
                                         talla = tallaProducto, numeroSerie = serieProducto,
                                         stock = stockProducto, precio = precioProducto )
}

fun visulizarInventario(){
   Inventario.visualizarInventario()
}

fun eliminarProducto(){
    print("Identificador del producto:")
    val identificadorProducto: Int = readln().toInt()

    Inventario.eliminarProducto(_id = identificadorProducto)
    println("Producto eliminado")

}

fun actualizarInventario(){
    print("Identificador del producto:")
    val identificadorProducto: Int = readln().toInt()
    print("Cantidad de producto:")
    val cantidadProducto: Int = readln().toInt()
    print("Tipo de ajuste amuentar/disminuir:")
    val ajusteTipo: String = readln()

    Inventario.actualizarStock(_id = identificadorProducto,
                               cantidad = cantidadProducto,
                               operacion = ajusteTipo)

    println("Inventario actualizado")


}


