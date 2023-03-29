import inventario.Inventario
import menus.arregloUser
import menus.inicioSesion
import user.User

fun main() {

    // Inventario Inicial
    Inventario.agregarProductoInventario(nombre = "Zapato", descripcion = "Zapato Blanco",
        tipo = "Calzado", modelo = "ZAP-00", precio = 330f, stock = 50, talla = 22.5f)

    Inventario.agregarProductoInventario(nombre = "Pantalon", descripcion = "Pantalón mezclila azul",
        tipo = "Ropa", modelo = "PA-00", precio = 700f, stock = 20, talla = 32F)

    Inventario.agregarProductoInventario(nombre = "Televisión", descripcion = "Tv led samsung 40 pulgadas",
        tipo = "Hogar", modelo = "SA-0002", precio = 100500f, stock = 10, numeroSerie = "STVMX-0001")
  // usuario test para ingresar al demo con el Id:1
    val usuario = User(nombre = "Admin",
        apellido = "test", email = "email@bedu.com",
        password = "password")

    arregloUser.addLast(usuario)
    // Menu de la aplicación
    inicioSesion()


}


