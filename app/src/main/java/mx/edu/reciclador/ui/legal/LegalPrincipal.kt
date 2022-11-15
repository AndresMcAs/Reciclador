package mx.edu.reciclador.ui.legal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import mx.edu.reciclador.MainActivity
import mx.edu.reciclador.R

class LegalPrincipal : AppCompatActivity() {
    private lateinit var regresar:Button
    private lateinit var derechosVar:TextView
    private lateinit var terminosVar:TextView
    private lateinit var politicasVar:TextView
    private lateinit var informacion:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_legal)

        //Variables a utilizar
       // regresar = findViewById(R.id.botonRegresar)
        derechosVar = findViewById(R.id.textLegalDerechos)
        terminosVar = findViewById(R.id.textTerminos)
        politicasVar = findViewById(R.id.textPoliticas)
        informacion = findViewById(R.id.textInformacion)

        derechosVar.setOnClickListener {
            var intent1 = Intent(this,LegalDerechos::class.java)
            startActivity(intent1)
        }

        terminosVar.setOnClickListener {
            var intent2 = Intent(this,LegalTerminos::class.java)
            startActivity(intent2)
        }

        politicasVar.setOnClickListener {
            var intent3 = Intent(this,LegalTerminos::class.java)
            startActivity(intent3)
        }

        informacion.setOnClickListener {
            var intent4 = Intent(this,LegalUbicacion::class.java)
            startActivity(intent4)
        }

        regresar.setOnClickListener {
            var intent5 = Intent(this, MainActivity::class.java)
            startActivity(intent5)
        }
    }

}