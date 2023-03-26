package inventario

import producto.CalzadoRopa
import producto.Producto
import producto.Hogar
import java.util.*

class Inventario {



    companion object{
        var listaDeInventario = LinkedList<Producto>()

        fun agregarInventario(producto: Producto){
            listaDeInventario.addLast(producto)
        }
        fun agregarProductoInventario(
            nombre: String,
            descripcion: String,
            tipo: String,
            modelo: String,
            precio: Float,
            stock: Int=0,
            talla: Float=0f,
            numeroSerie:String=" "){
            val  tipo = tipo.lowercase()
            if(tipo == "ropa" || tipo =="calzado"){
                val productoCalzadoRopa = CalzadoRopa(nombre, descripcion
                    ,precio,modelo,talla,tipo, stock)
                agregarInventario(productoCalzadoRopa)

            }else if (tipo=="hogar"){
                val productoHogar = Hogar(nombre,numeroSerie,modelo,
                    descripcion,precio,tipo,stock)
                agregarInventario(productoHogar)
            }
        }


    }



}

fun main(args: Array<String>) {

  Inventario.agregarProductoInventario("Zapato Blanco","Zapato casual",
      "calzado", "B-22",350f,20,22.5f)
 Inventario.agregarProductoInventario("Tenis Blanco","Zapato casual",
        "calzado", "B-23",550f,10,23f)
 Inventario.agregarProductoInventario("Refrigerador Mabe","Refrigerador 10 pies cubicos",
     "Hogar", "Mabe-12",100000f,10, numeroSerie = "MB-'1112")


    for (p in Inventario.listaDeInventario){
      println(p.id)

   }

   val test = Inventario.listaDeInventario.filter { Producto-> Producto.id == 3  }
  // println(test[0].id)
  println(test)
}
