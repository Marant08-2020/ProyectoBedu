package orden
import java.util.LinkedList
import impuesto.Impuesto
import inventario.Inventario

class Orden(var noOrden: Int = 0,
    ): Impuesto {
    var objetoProducto: MutableMap<String, Any>  = mutableMapOf()
    var listaProducto = LinkedList<MutableMap<String, Any>>()
    override fun calcularImpuestos(precio: Float): Float{
        return precio * Impuesto.taxIvaMx
    }


    companion object{
        protected var contadorOrden: Int =0
    }
    // Inicia el contador de productos instanciados
    init {
        contadorOrden += 1
    }

    init {
        this.noOrden = contadorOrden
    }

    fun agregarProductoOrden(_id: Int, numProductos:Int): MutableMap<String, Any> {

        val productoOrden = Inventario.buscarProducto(_id)



        if(productoOrden.isEmpty()){
            println("No hay inventario pra el producto Id:$_id")
        }else{
            val subtotal = numProductos * productoOrden[0].precio
            val iva: Float = calcularImpuestos(subtotal)
            objetoProducto = mutableMapOf<String, Any>(
                "_id" to productoOrden[0].id,
                "Descripción" to productoOrden[0].descripcion,
                "Cantidad" to numProductos,
                "precio" to productoOrden[0].precio,
                "subtotal" to subtotal,
                "iva" to iva,
                "total" to subtotal + iva
            )

            listaProducto.addLast(objetoProducto)
        }
        return objetoProducto
    }

    fun visualizarListaProductos(){

        listaProducto.forEach(){
            println(it)
        }
    }


}

fun main(args: Array<String>) {


    Inventario.agregarProductoInventario(nombre = "Zapato", descripcion = "Zapato Blanco",
    tipo = "Calzado", modelo = "ZAP-00", precio = 330f, stock = 50, talla = 22.5f)

    Inventario.agregarProductoInventario(nombre = "Pantalon", descripcion = "Pantalón mezclila azul",
        tipo = "Ropa", modelo = "PA-00", precio = 700f, stock = 20, talla = 32F)

    Inventario.agregarProductoInventario(nombre = "Televisión", descripcion = "Tv led samsung 40 pulgadas",
        tipo = "Hogar", modelo = "SA-0002", precio = 100500f, stock = 10, numeroSerie = "STVMX-0001")

    Inventario.visualizarInventario()

    val orden1 = Orden()
    orden1.agregarProductoOrden(1, 3)
    orden1.agregarProductoOrden(2, 2)
    orden1.agregarProductoOrden(3, 3)
    orden1.visualizarListaProductos()
//    println( orden1.listaProducto )
}


