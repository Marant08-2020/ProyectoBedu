package producto

abstract class Producto {
    abstract var id: Int
    abstract var nombre: String
    abstract var descripcion: String
    abstract var precio: Float
    protected var stock: Int = 0

    protected fun getId(): Int = this.id
    protected fun setId(id: Int){ this.id = id }
    protected fun getNombre(): String = this.nombre
    protected fun setNombre(nombre: String){ this.nombre = nombre }
    protected fun getDescripcion(): String = this.descripcion
    protected fun setDescripcion(descripcion: String){ this.descripcion = descripcion }
    protected fun getPrecio(): Float = this.precio
    protected fun setPrecio(precio: Float){ this.precio = precio }


    protected fun setStock(number: Int) = stock

    abstract fun descripcionProducto()

}