package orden
import java.util.LinkedList
import impuesto.Impuesto
import inventario.Inventario

class Orden(noOrden: Int = 0,
    ): Impuesto {
    var objetoProducto: MutableMap<String, Any>  = mutableMapOf()
    var listaProducto = LinkedList<MutableMap<String, Any>>()
        get() = field
        set(value) {
            field= value
        }
    companion object{
        protected var contadorOrden: Int =0
    }
    // Inicia el contador de productos instanciados
    init {
        contadorOrden += 1
    }

    fun agregarProductoOrden(_id: Int, numProductos:Int){

        val prodectoOrden = Inventario.buscarProducto(_id)

        if(prodectoOrden.isEmpty()){
            println("No hay inventario pra el producto Id:$_id")
        }else{

            objetoProducto["_id"]=prodectoOrden[0].id
            objetoProducto["Descripción"] = prodectoOrden[0].descripcion
            objetoProducto["Cantidad"] = numProductos

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
    orden1.agregarProductoOrden(10, 2)
}


