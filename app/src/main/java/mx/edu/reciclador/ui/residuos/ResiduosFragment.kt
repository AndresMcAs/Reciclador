package mx.edu.reciclador.ui.residuos

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.core.view.MotionEventCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import mx.edu.reciclador.R

class ResiduosFragment : Fragment() {
    private lateinit var btnContenedorAzul : ImageButton;
    private lateinit var btnContenedorVerde : ImageButton;
    private lateinit var btnContenedorAmarillo : ImageButton;
    private lateinit var btnContenedorNaranja : ImageButton;
    private lateinit var btnContenedorGris : ImageButton;

    companion object {
        fun newInstance() = ResiduosFragment()
    }

    private lateinit var viewModel: ResiduosViewModel

    @SuppressLint("LongLogTag")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        val view = inflater.inflate(R.layout.fragment_residuos, container, false)

        btnContenedorAzul = view.findViewById(R.id.imgBtnContenedorAzul)
        btnContenedorVerde = view.findViewById(R.id.imgBtnContenedorVerde)
        btnContenedorAmarillo = view.findViewById(R.id.imgBtnContenedorAmarrillo)
        btnContenedorNaranja = view.findViewById(R.id.imgBtnContenedorNaranja)
        btnContenedorGris = view.findViewById(R.id.imgBtnContenedorGris)

        //var contenedor = ContenedorBasura()

        btnContenedorAzul.setOnClickListener(){
            var intent = Intent(activity,Contenedor::class.java)
            intent.putExtra("img", R.drawable.bote_azul)
            intent.putExtra("cabecera", R.string.contenedor_azul_cabecera)
            intent.putExtra("titulo", R.string.contenedor_azul_titulo)
            intent.putExtra("descripcion",R.string.contenedor_azul_descripcion)

            startActivity(intent)

            }

        btnContenedorVerde.setOnClickListener(){
            var intent = Intent(activity,Contenedor::class.java)


            intent.putExtra("img", R.drawable.bote_verde)
            intent.putExtra("titulo", R.string.contenedor_verde_titulo)
            intent.putExtra("cabecera", R.string.contenedor_verde_cabecera)
            intent.putExtra("descripcion",R.string.contenedor_verde_descripcion)

            startActivity(intent)

            }

        btnContenedorAmarillo.setOnClickListener(){
            var intent = Intent(activity,Contenedor::class.java)


            intent.putExtra("img", R.drawable.bote_amarrillo)
            intent.putExtra("titulo", R.string.contenedor_amarillo_titulo)
            intent.putExtra("cabecera", R.string.contenedor_amarillo_cabecera)
            intent.putExtra("descripcion",R.string.contenedor_amarillo_descripcion)

            startActivity(intent)

            }

        btnContenedorNaranja.setOnClickListener(){
            var intent = Intent(activity,Contenedor::class.java)


            intent.putExtra("img", R.drawable.bote_naranja)
            intent.putExtra("cabecera", R.string.contenedor_naranja_cabecera)
            intent.putExtra("titulo", R.string.contenedor_naranja_titulo)
            intent.putExtra("descripcion",R.string.contenedor_naranja_descripcion)

            startActivity(intent)

            }

        btnContenedorGris.setOnClickListener(){
            var intent = Intent(activity,Contenedor::class.java)


            intent.putExtra("img", R.drawable.bote_gris)
            intent.putExtra("cabecera", R.string.contenedor_gris_cabecera)
            intent.putExtra("titulo", R.string.contenedor_gris_titulo)
            intent.putExtra("descripcion",R.string.contenedor_gris_descripcion)

            startActivity(intent)

            }

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this).get(ResiduosViewModel::class.java)
        // TODO: Use the ViewModel
    }

}