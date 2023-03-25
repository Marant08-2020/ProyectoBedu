package orden
import java.util.LinkedList
import producto.Producto
import impuesto.Impuesto
import java.util.Date

class Orden(var noOrden: Int = 0): Impuesto {
    var arregloProducto = LinkedList<Producto>()


    // Inicia el contador de productos instanciados
    companion object{
        protected var contadorOrden: Int = 0
    }
    init {
        contadorOrden += 1
        this.noOrden = contadorOrden
        val fecha = Date()
    }

    fun agregarProducto(producto: Producto){
        arregloProducto.addLast(producto)
        println("producto agregado")

    }

    fun eliminarProducto(producto: Producto){

    }

    fun calcularTotal(){

    }


}