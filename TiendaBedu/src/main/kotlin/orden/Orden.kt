package orden
import java.util.LinkedList
import producto.Producto
import impuesto.Impuesto

class Orden(noOrden: Int = 0,
    ): Impuesto {
    var arregloProducto = LinkedList<Producto>()
    companion object{
        protected var contadorOrden: Int =0
    }
    // Inicia el contador de productos instanciados
    init {
        contadorOrden += 1
    }


}