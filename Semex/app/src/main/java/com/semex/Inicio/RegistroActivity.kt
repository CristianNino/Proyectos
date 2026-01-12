package com.semex.Inicio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.semex.R

class RegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val btnregis = findViewById<Button>(R.id.btnregis)
        val btvolver = findViewById<Button>(R.id.btvolver)
        val etEmailregis: EditText = findViewById(R.id.etEmailregis)



        btnregis.setOnClickListener {
            if (etEmailregis.text.isEmpty()){
                vacios()
                }
            else {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Aviso")
                builder.setMessage("Se ha enviado a tu correo la contraseña del usuario")
                builder.setPositiveButton("Aceptar", null)
                val Dialogo: AlertDialog = builder.create()
                Dialogo.show()
            }
            }
        btvolver.setOnClickListener {navigateToInicio1()}
    }

    private fun navigateToInicio1() {
        val intent = Intent(this, InicioActivity::class.java)
        startActivity(intent)}

    private fun vacios (){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Es nesesaio llenar los espacios")
        builder.setPositiveButton("Aceptar", null)
        val Dialogo: AlertDialog = builder.create()
        Dialogo.show()
    }
}