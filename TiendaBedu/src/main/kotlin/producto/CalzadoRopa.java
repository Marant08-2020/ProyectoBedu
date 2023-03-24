package producto;

public class CalzadoRopa extends  Producto{

    private static final int id = 0;
    protected String modelo;
    protected float talla;
    protected String tipo;

    protected int stock;

    public CalzadoRopa(String nombre, String descripcion, float precio,
                       String modelo, float talla, String tipo, int stock){
        super(id, nombre, descripcion, precio);

        this.modelo = modelo;
        this.talla = talla;
        this.tipo = tipo;
        this.stock = stock;
    }

    public String getModelo(){
        return this.modelo;
    }

    public String SetModelo(String modelo){
        return this.modelo = modelo;
    }

    public String getTalla(){
        return this.modelo;
    }

    public float SetTalla(float talla){
        return this.talla = talla;
    }


    public String getTipo(){
        return this.tipo;
    }

    public String SetTipo(String tipo){
        return this.tipo = tipo;
    }

    public int getStock(){
        return this.stock;
    }

    public int SetStock(int stock){
        return this.stock = stock;
    }


    @Override
    public String descripcionProducto() {
     return  ( "Id del producto:" +  this.getId() +"\n" +
                              "Nombre del producto:" +  this.getNommbre() +"\n" +
                              "Descripción del producto:" + this.getDescripcion()+"\n" +
                              "Precio del producto:" +  this.getPrecio()+"\n" +
                              "Modelo del producto:" +  this.modelo+"\n" +
                              "Talla del producto:" + this.talla+"\n" +
                              "Tipo del producto:" + this.tipo+"\n" +
                              "Stock del producto:"+ this.stock+"\n");
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
        System.out.println(zapato2.descripcionProducto());

    }
}

