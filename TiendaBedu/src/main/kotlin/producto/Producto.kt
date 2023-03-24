package producto
// Clase abstracta del producto
abstract class Producto(var id: Int = 0,
                        var nommbre: String,
                        var descripcion: String,
                        var tipo: String,
                        var modelo: String,
                        var precio: Float,
                        var stock: Int=0){
    // Variable estática
    companion object{
        protected var contadorProducto: Int =0
    }
    // Inica el contador de prodectos intanciados
    init {
        contadorProducto += 1

    }

    // Asigana como id el caontador
    init {
        this.id= contadorProducto
    }

    abstract  fun descripcionProducto(): String?

    open fun aumetarStock(stock: Int): Int {
        return stock.let { this@Producto.stock += it; stock }
    }

    open fun descontarStock(stock: Int): Int {
        return stock.let { this@Producto.stock -= it; stock }
    }

    override fun toString(): String {
        return """
           
           Id del producto:${this.id}
           Nombre del producto:${this.nommbre} 
           Descripción del producto:${this.descripcion} 
           Precio del producto:${this.precio} 
           Modelo del producto:${this.modelo}
           Tipo del producto:${this.tipo}
           Stock del producto:${this.stock}
        """.trimIndent()
    }

}
