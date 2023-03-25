package Impuesto

interface Impuesto {

    companion object{
        protected val ivaTax: Float = 1.16f
    }

//    fun setIvaTax(newTax: Float){
//        ivaTax = newTax
//    }
//
//    fun getIvaTax(): Float {
//        return ivaTax
//    }

    fun calcularImpuesto(costo: Float): Float {
        return ivaTax * costo
    }
}