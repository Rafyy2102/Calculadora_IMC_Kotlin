package com.grupo2.imc.extension

/**
 * Created by logonrm on 02/03/2018.
 */
fun Double.format(digits: Int) = java.lang.String.format("%.${digits}f", this)