package com.venancio.testcystera.data

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.View
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import com.venancio.testcystera.R
import com.venancio.testcystera.dao.DatabaseInitializer
import com.venancio.testcystera.database.AppDatabase
import com.venancio.testcystera.entity.LogUsr
import com.venancio.testcystera.utils.GpsClass
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext



/******corrutina genera una peticion get ********/
fun callWebServiceLicenseM(applicationContext:Context,Email:String,respuesta: (Boolean) -> Unit) {
     var usr: List<LogUsr>

    CoroutineScope(Dispatchers.IO).launch {
        var Gp= GpsClass(applicationContext)
        var la=Gp.latitude
        var lg=Gp.longitude
        val request = RestapiAdapter().getClientService().getStringResponse("true",la.toString(),lg.toString(),"qa_mobile_easy","full")
        withContext(Dispatchers.Main) {
            try {
                val response = request.await()
                if (response.isSuccessful ) {
                    val objResponse = Gson().fromJson(response.body(), responsedata::class.java)
                    var da = objResponse.countryCode
                    Log.i("Suses", da)
                    usr= listOf<LogUsr>()
                    usr[0].email=Email
                    usr[0].fecha=objResponse.time
                    DatabaseInitializer.logAsync(AppDatabase.getAppDatabase(applicationContext), usr)

                    respuesta(true)
                } else {
                    //toast("Error: ${response.code()}")
                    respuesta(false)
                    Log.i("ERROR", response.raw().code().toString())
                }
            } catch (e: Exception) {
                respuesta(false)
                Log.i("ERROR", "")
            } catch (e: Throwable) {
                respuesta(false)
                Log.i("ERROR", "")
            }
        }
    }

}


/******snack bar ********/
fun Activity.callsnacbar(text: String, respuesta: (Boolean) -> Unit) {

    val vista: View = this.findViewById(android.R.id.content)
    val snack = Snackbar.make(vista, text, Snackbar.LENGTH_LONG)
    snack.view.setBackgroundColor(Color.parseColor("#FFFFFF"))
    val textViewId = R.id.snackbar_text
    val textView = snack.view.findViewById(textViewId) as TextView
    textView.setTextColor(Color.BLACK)
    textView.setTextColor(Color.parseColor("#4444DD"))
    snack.show()
    respuesta(true)

}

fun Activity.callsnacbar(text: String) {
    val vista: View = this.findViewById(android.R.id.content)
    val snack = Snackbar.make(vista, text, Snackbar.LENGTH_LONG)
    snack.view.setBackgroundColor(Color.parseColor("#FFFFFF"))
    val textViewId = com.venancio.testcystera.R.id.snackbar_text
    val textView = snack.view.findViewById(textViewId) as TextView
    textView.setTextColor(Color.BLACK)
    textView.setTextColor(Color.parseColor("#4444DD"))
    snack.show()

}

fun getcoordenadas(DeviceLatitude:String ,DeviceLongitude:String):Map<String,String>{
    val data = HashMap<String,String>()
    data.put("formatted", "true")
    data.put("lat", DeviceLatitude)
    data.put("lng", DeviceLongitude)
    data.put("username", "qa_mobile_easy")
    data.put("style", "full")
    return data
}