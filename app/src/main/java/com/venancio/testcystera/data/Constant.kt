package com.venancio.testcystera.data

import android.util.Base64

object Constant {


    val URL="http://5.9.152.54/"
    val stringdata = Base64.encodeToString(URL.toByteArray(), Base64.NO_WRAP)//produccion



}