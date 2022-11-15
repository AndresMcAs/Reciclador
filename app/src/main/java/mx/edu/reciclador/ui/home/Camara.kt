package mx.edu.reciclador.ui.home

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.test.core.app.ApplicationProvider
import mx.edu.reciclador.R
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.model.Model
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.io.IOException
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.util.*
import javax.xml.parsers.DocumentBuilderFactory.newInstance


class Camara : Fragment(R.layout.fragment_camara) {
    private lateinit var botonCamara: ImageButton
    private lateinit var foto: ImageView
    private lateinit var currentPhotoPath: String
    val REQUEST_IMAGE_CAPTURE = 1

    private lateinit var image:Bitmap
    private var dimension:Int =0
    private var imagenZ =224

    private lateinit var idResiduo:TextView

    @SuppressLint("LongLogTag")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val view = inflater.inflate(R.layout.fragment_camara, container, false)

        botonCamara = view.findViewById(R.id.botonCamara)
        foto = view.findViewById(R.id.foto_tomada)
        idResiduo = view.findViewById(R.id.resultado)
        botonCamara.setOnClickListener() {
            // abrir la camara
           // dispatchTakePictureIntent()
          iniciaResult.launch(Intent(MediaStore.ACTION_IMAGE_CAPTURE))

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

  private val iniciaResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){

      result: ActivityResult ->
      if (result.resultCode == Activity.RESULT_OK){
          val intent = result.data
          val imagenBitmap=intent?.extras?.get("data") as Bitmap
          foto.setImageBitmap(imagenBitmap)

          //clasificacionImagen(imagenBitmap)
      }
  }
    /**

    fun clasificacionImagen(image: Bitmap) {
        try {

            val model: Model = Model.newInstance(ApplicationProvider.getApplicationContext())
            // Creates inputs for reference.
            val inputFeature0 =
                TensorBuffer.createFixedSize(intArrayOf(1, 224, 224, 3), DataType.FLOAT32)
            val byteBuffer = ByteBuffer.allocateDirect(4 * imagenZ * imagenZ * 3)
            byteBuffer.order(ByteOrder.nativeOrder())

            // get 1D array of 224 * 224 pixels in image
            val intValues = IntArray(imagenZ* imagenZ)
            image.getPixels(intValues, 0, image.width, 0, 0, image.width, image.height)

            // iterate over pixels and extract R, G, and B values. Add to bytebuffer.
            var pixel = 0
            for (i in 0 until imagenZ) {
                for (j in 0 until imagenZ) {
                    val `val` = intValues[pixel++] // RGB
                    byteBuffer.putFloat((`val` shr 16 and 0xFF) * (1f / 255f))
                    byteBuffer.putFloat((`val` shr 8 and 0xFF) * (1f / 255f))
                    byteBuffer.putFloat((`val` and 0xFF) * (1f / 255f))
                }
            }
            inputFeature0.loadBuffer(byteBuffer)

            // Runs model inference and gets result.
            val outputs: Model.Outputs = model.process(inputFeature0)
            val outputFeature0: TensorBuffer = outputs.getOutputFeature0AsTensorBuffer()
            val confidences = outputFeature0.floatArray
            // find the index of the class with the biggest confidence.
            var maxPos = 0
            var maxConfidence = 0f
            for (i in confidences.indices) {
                if (confidences[i] > maxConfidence) {
                    maxConfidence = confidences[i]
                    maxPos = i
                }
            }
            val classes = arrayOf("Papel", "Vidrio", "Pet", "Plastico")
            idResiduo.setText(classes[maxPos])
            var s = ""
            for (i in classes.indices) {
                s += String.format("%s: %.1f%%\n", classes[i], confidences[i] * 100)
            }
            //porcentaje de similitud
            //confidence.setText(s)


            // Releases model resources if no longer used.
            model.close()
        } catch (e: IOException) {
            // TODO Handle the exception
        }
    }*/

}