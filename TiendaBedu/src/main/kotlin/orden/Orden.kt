package orden
import java.util.LinkedList
import Producto
import `interface`.Impuesto

class Orden(noOrden: Int = 0,
            listaProductos: listOf<Producto>
    ): Impuesto {

    companion object{
        protected var contadorOrden: Int =0
    }
    // Inicia el contador de productos instanciados
    init {
        contadorOrden += 1
    }


}