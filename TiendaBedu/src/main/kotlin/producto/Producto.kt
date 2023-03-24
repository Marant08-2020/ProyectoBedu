package producto

abstract class Producto(var id: Int = 0,
                        var nommbre: String,
                        var descripcion: String,
                        var precio: Float){
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

}
