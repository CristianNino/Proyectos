package com.semex.Inicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.semex.R

class NpasswordaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_npassworda)

        val btnpass = findViewById<Button>(R.id.btnpass)
        val etNpassword = findViewById<EditText>(R.id.etNpassword)


        btnpass.setOnClickListener {

            if(etNpassword.text.isEmpty()){
                vacios()
            }else if (etNpassword.validateInput()) {
                etNpassword.error = null
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Aviso")
                builder.setMessage("Contraseña Cambiada")
                builder.setPositiveButton("Aceptar", null)
                val Dialogo: AlertDialog = builder.create()
                Dialogo.show()
            }else{
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Error")
                builder.setMessage("La Contraseña no cumple con los requisitos")
                builder.setPositiveButton("Aceptar", null)
                val Dialogo: AlertDialog = builder.create()
                Dialogo.show()
            }
        }
    }
        private fun vacios() {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Error")
            builder.setMessage("Es nesesaio llenar los espacios")
            builder.setPositiveButton("Aceptar", null)
            val Dialogo: AlertDialog = builder.create()
            Dialogo.show()
        }
    fun EditText.validateInput(): Boolean {
        val input = this.text.toString()

        val hasUpperCase = input.any { it.isUpperCase() }
        val hasSpecialCharacter = input.any { it.isLetterOrDigit().not() }
        val hasNumber = input.any { it.isDigit() }
        val hasMinimumLength = input.length >= 8

        return hasUpperCase && hasSpecialCharacter && hasNumber && hasMinimumLength
    }
}