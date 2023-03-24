package producto;

public class CalzadoRopa extends  Producto{

    private static final int id = 0;
    protected float talla;


    public CalzadoRopa(String nombre, String descripcion, float precio,
                       String modelo, float talla, String tipo, int stock){
        super(id, nombre, descripcion,tipo,modelo, precio, stock);
        this.talla = talla;
    }


    public float getTalla(float talla){
        return this.talla = talla;
    }
    public void  setTalla(float talla){
        this.talla = talla;
    }

    @Override
    public String descripcionProducto() {
     return  "\nTalla del producto:" + this.talla;
    }

    // Quitar esto
    public static void main(String[] args)
    {

        CalzadoRopa zapato2 = new CalzadoRopa("Casa Roja","Zapato Rojo",
                500, "B-52", 25, "Casual",2 );
        CalzadoRopa zapato3 = new CalzadoRopa("Casa Blanc","Zapato Blanco",
                500, "B-50", 22, "Casual",20 );
        System.out.println(zapato2.getId());
        System.out.println(zapato3.getId());
        System.out.println(zapato2.toString() + zapato2.descripcionProducto());
        zapato2.aumetarStock(10);
        System.out.println(zapato2.descripcionProducto());

    }
}

