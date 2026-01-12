package com.semex.Inicio
import android.content.Intent
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.semex.R

class InicioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        val btnIngreso = findViewById<Button>(R.id.btnRegistro)
        val btnRegistro = findViewById<Button>(R.id.btnIngreso)
        val etEmail: EditText = findViewById(R.id.etEmail)
        val etpass: EditText = findViewById(R.id.etpassword)

        btnIngreso.setOnClickListener {
            if (etpass.text.isEmpty() and etEmail.text.isEmpty()) {
                vacios()
            } else {
                navigateToRegistro()
            }
        }
        btnRegistro.setOnClickListener {
            if (etpass.text.isEmpty() and etEmail.text.isEmpty()) {
                vacios()
            } else {
                navigateToNpassword()
            }
        }
    }
    private fun navigateToRegistro() {
        val intent = Intent(this, RegistroActivity::class.java)
        startActivity(intent)}
    private fun navigateToNpassword() {
        val intent = Intent(this, NpasswordaActivity::class.java)
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