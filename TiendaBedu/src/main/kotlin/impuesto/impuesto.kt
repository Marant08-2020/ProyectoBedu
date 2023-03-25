package impuesto

interface Impuesto {

        companion object {
            val  taxIvaMx = 1.16f
        }
   open fun calcularImpuestos(){}
}