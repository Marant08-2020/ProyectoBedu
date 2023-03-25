package orden
import producto.Producto
import impuesto.Impuesto
import java.util.*

class Orden(noOrden: Int = 0,
            listProducto: LinkedList<Producto> =  LinkedList<Producto>()
    ): Impuesto {

    companion object{
        protected var contadorOrden: Int =0
    }
    // Inicia el contador de productos instanciados
    init {
        contadorOrden += 1
    }


}