package com.venancio.testcystera

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.gson.JsonObject
import com.venancio.testcystera.data.RestapiAdapter
import com.venancio.testcystera.data.callWebServiceLicenseM
import com.venancio.testcystera.utils.GpsClass
import com.venancio.testcystera.utils.Utils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {



    companion object {
        const val REQUEST_PERMISSION = 1
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (!Utils().checkInternetConnection(this))
            if (
                ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED

            ) {
                ActivityCompat.requestPermissions(
                    this, arrayOf(
                        Manifest.permission.CAMERA,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE
                    ), REQUEST_PERMISSION
                )

            }

        Log.i("TAG", Utils().gettimedate())


        var email = findViewById<TextInputLayout>(R.id.email)
        var txt_email = findViewById<TextInputEditText>(R.id.txt_email)

        var pass = findViewById<TextInputLayout>(R.id.pass)
        var Password = findViewById<TextInputEditText>(R.id.Password)


        var btn_valida = findViewById<Button>(R.id.btn_valida)
        var btn_registrar = findViewById<Button>(R.id.btn_registrar)
        btn_valida.setOnClickListener {

            Log.i("TAG", Utils().isEmailValid(txt_email.text.toString()).toString())

            /* if (txt_email.text.toString().isNotEmpty() && !Utils().isEmailValid(txt_email.text.toString())) {
                 email.error = "ingrese un correo valido"
             }
             if (Password.text.toString().isNotEmpty() && !Utils().isValidPassword(Password.text.toString())) {
                 pass.error = "Password: De mínimo 8 caracteres donde incluya mayúsculas, minúsculas, números y caracteres especiales."
             }*/


            /*callWebServiceLicenseM {

            }*/
            var Gp=GpsClass(applicationContext)
            var la=Gp.latitude
            var lg=Gp.longitude
            Log.i("TAG",la.toString())


        }


        btn_registrar.setOnClickListener {
            startActivity(Intent(this@MainActivity, Registrar::class.java))
        }
    }


    private fun AlertNoGps() {

        val builder = AlertDialog.Builder(this)
        builder.setMessage("El sistema GPS esta desactivado, ¿Desea activarlo?")
            .setCancelable(false)
            .setPositiveButton("Si") { _, _ ->
                startActivity(Intent(ACTION_LOCATION_SOURCE_SETTINGS))
            }
            .setNegativeButton("No") { dialog, _ ->
                dialog.cancel()
            }
        builder.create().show()
    }

    override fun onResume() {
        super.onResume()
    }
}
