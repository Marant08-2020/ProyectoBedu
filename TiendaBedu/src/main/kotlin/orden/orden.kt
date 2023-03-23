package orden

import Impuesto.Impuesto

class orden: Impuesto {

    override var ivaTax: Float = 1.16f
//        set(value) {}
    override fun calcularImpuesto(costo: Float): Float {
        ivaTax = 1.13f
        return super.calcularImpuesto(costo)
    }
    val total = calcularImpuesto(13.5f)

}