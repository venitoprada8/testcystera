package com.venancio.testcystera

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.venancio.testcystera.dao.DatabaseInitializer
import com.venancio.testcystera.database.AppDatabase
import com.venancio.testcystera.entity.User
import com.venancio.testcystera.utils.Utils
import kotlinx.android.synthetic.main.activity_registrar.*

class Registrar : AppCompatActivity() {
    internal var usr: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)
        btn_valida.setOnClickListener {

            if (txt_email.text.toString().isNotEmpty() && !Utils().isEmailValid(txt_email.text.toString())) {
                email.error = "ingrese un correo valido"
                return@setOnClickListener
            } else if (txt_password.text.toString().isNotEmpty() && !Utils().isValidPassword(txt_password.text.toString())) {
                pass.error =
                    "Password: De mínimo 8 caracteres donde incluya mayúsculas, minúsculas, números y caracteres especiales."
                return@setOnClickListener
            }
            usr = User()
            usr = DatabaseInitializer.getdata(AppDatabase.getAppDatabase(this@Registrar), txt_email.text.toString())
            if (usr == null) {
                usr!!.age = txt_edad.text.toString()
                usr!!.apellido = txt_apellido.text.toString()
                usr!!.email = txt_email.text.toString()
                usr!!.nombre = txt_nombre.text.toString()
                usr!!.password = txt_password.text.toString()
            } else {
                Toast.makeText(this, "Correo ya registrado", Toast.LENGTH_LONG)
                startActivity(Intent(this@Registrar,MainActivity::class.java))
            }


            DatabaseInitializer.populateAsync(AppDatabase.getAppDatabase(this@Registrar), usr)

        }
    }
}
