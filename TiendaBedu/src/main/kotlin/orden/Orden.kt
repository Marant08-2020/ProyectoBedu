package orden
import java.util.LinkedList
import producto.CalzadoRopa
import impuesto.Impuesto

class Orden(noOrden: Int = 0,
    ): Impuesto {
    var arregloProducto = LinkedList<Any>()
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

    fun agregarProducto(producto: Any){
        arregloProducto.addLast(producto)
    }




}

fun main(args: Array<String>) {
   val  orden1 = Orden()
   val product1 = CalzadoRopa("Zapato Blanco","Zapato",350f,"B-50",
       22f,"casual",30)
   println(product1.descripcionProducto())
  orden1.agregarProducto(product1)
  println(orden1.arregloProducto)
  val product2 = CalzadoRopa("Zapato Negro","Zapato",380f,"N-50",
        22.5f,"casual",10)
  orden1.agregarProducto(product2)

  println(orden1.arregloProducto)

}


