package mx.edu.reciclador.ui.home

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.ActivityNotFoundException
import android.content.ContentValues.TAG
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.media.ExifInterface
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import mx.edu.reciclador.R
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.max
import kotlin.math.min


class Camara : Fragment(R.layout.fragment_camara) {
    private lateinit var botonCamara: ImageButton
    private lateinit var foto: ImageView
    private lateinit var currentPhotoPath: String
    val REQUEST_IMAGE_CAPTURE = 1
    private lateinit var extra : Bundle
    private lateinit var imagenBit:Bitmap

    @SuppressLint("LongLogTag")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val view = inflater.inflate(R.layout.fragment_camara, container, false)

        botonCamara = view.findViewById(R.id.botonCamara)
        foto = view.findViewById(R.id.foto_tomada)

        botonCamara.setOnClickListener() {
            // abrir la camara
            dispatchTakePictureIntent()

        }


        return view

    }



    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        } catch (e: ActivityNotFoundException) {
            // display error state to the user
        }
    }






}