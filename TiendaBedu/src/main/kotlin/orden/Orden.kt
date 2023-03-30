package orden
import impuesto.Impuesto
import inventario.Inventario
import java.util.*
import kotlin.reflect.typeOf

enum class Estados {
    PENDIENTE, COMPLETA, SURTIDO
}

class Orden(var noOrden: Int = 0,
    ): Impuesto {

    var objetoProducto: MutableMap<String, Any>  = mutableMapOf()
    var listaProducto = LinkedList<MutableMap<String, Any>>()
    var statusOrden = Estados.PENDIENTE
    var totalOrden = 0f

    var fechaCreacion = Date().toString()
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
                "total" to subtotal + iva,
                "statusProducto" to Estados.PENDIENTE
            )

            listaProducto.addLast(objetoProducto)
        }
        return objetoProducto
    }

    fun visualizarListaProductos(){
        if (listaProducto.isEmpty()){
            println("Aún no hay productos agregados")
        }else{
            println("productos: ")
            listaProducto.forEach(){
                println(it)
            }
        }
    }

    fun procesarOrden(){
        if (statusOrden == Estados.COMPLETA){
            println("La orden ya fue procesada")
        }
        else{
            println("Procesando orden")
            listaProducto.forEach {
                val idProducto = it["_id"]?.let { it1 -> castingInt(it1) }
                val cantidadProducto = it["Cantidad"]?.let { it2 -> castingInt(it2) }
                if (idProducto != null && cantidadProducto != null &&
                    it["statusProducto"] == Estados.PENDIENTE) {
                   try{
                       Inventario.actualizarStock(idProducto,
                           cantidadProducto, "-")
                       it["statusProducto"] = Estados.SURTIDO
                       statusOrden = Estados.COMPLETA
                   }catch (e:Error){
                       println("${e.message} en id:$idProducto ")
                       statusOrden = Estados.PENDIENTE
                   }

                }

            }
        }
    }

    fun castingInt(value:Any): Int {
        var intValue = 0
        if (value is Any) {
           intValue= value.toString().toInt()

        }
        return  intValue
    }

    fun calcularTotal(): Float {
        var sumaTotal = 0f
        if (!listaProducto.isEmpty()){
            for (producto in listaProducto)
                sumaTotal += producto["total"].toString().toFloat()
        }
        return sumaTotal
    }

    fun actualizarNumCantidaProducto(_id: Int, cantidad: Int){

         val objetoLista = listaProducto.
         filter { objetoProducto-> objetoProducto["_id"] == _id }
        if(objetoLista.isEmpty()){
            println("Producto no existe")
        }else{
            objetoLista[0]["Cantidad"]=cantidad
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
    orden1.agregarProductoOrden(3, 100)
    orden1.visualizarListaProductos()

    orden1.actualizarNumCantidaProducto(3,2)
    orden1.visualizarListaProductos()
//    println( orden1.listaProducto )
//    orden1.procesarOrden()

//    Inventario.visualizarInventario()
//    orden1.visualizarListaProductos()
}


