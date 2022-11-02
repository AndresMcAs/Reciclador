package mx.edu.reciclador.ui.residuos

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import mx.edu.reciclador.R


class Contenedor: AppCompatActivity() {
    private lateinit var imgContenedor : ImageView;
    private lateinit var txtTituloContenedor : TextView;
    private lateinit var txtDescripcionContenedor : TextView;


    override fun onCreate(savedInstanceState: Bundle?) {
        val extras = intent.extras

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contenedor)

        Log.d("Contenedor ", "onCreateView: Img"+extras?.get("img") )

        imgContenedor = findViewById(R.id.imgContenedor)
        txtTituloContenedor = findViewById(R.id.txtTituloContenedor)
        txtDescripcionContenedor = findViewById(R.id.txtDescripcionContenedor)

        var cabecera = (extras?.get("cabecera"))
        var titulo = (extras?.get("titulo"))
        var descripcion = extras?.get("descripcion")
        var draw= (extras?.get("img"))

        supportActionBar?.setTitle("${getString(cabecera.hashCode())}")

        txtTituloContenedor.text = ""+getString(titulo.hashCode())
        txtDescripcionContenedor.text = ""+getString(descripcion.hashCode())
        imgContenedor.setImageDrawable(getDrawable(draw.hashCode()))

    }
}