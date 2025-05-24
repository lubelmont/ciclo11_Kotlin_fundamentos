package com.lubelsoft.miaplicacion101.app

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.firestore.FirebaseFirestore
import com.lubelsoft.miaplicacion101.R
import okhttp3.OkHttpClient
import org.json.JSONObject

class FirstActivity : AppCompatActivity() {

    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)



        val btnLogin= findViewById<AppCompatButton>( R.id.btnLogin)
        val usernameEditText = findViewById<AppCompatEditText>(R.id.username)

        btnLogin.setOnClickListener(){
            val username = usernameEditText.text.toString()
            Log.i("miLogs","se ah pulsado el boton")
            Log.i("miLogs", "Texto ingresado: $username")
            loginUser(username)
            //testConexion()

        }


    }
    private fun testConexion(){
        db = FirebaseFirestore.getInstance()
        db.collection("test").add(mapOf("timestamp" to System.currentTimeMillis()))
    }

    private fun loginUser(username:String){

        //firebase-adminsdk-fbsvc@cliclo11-firebase.iam.gserviceaccount.com

        val cliente = OkHttpClient()
        val jsonObj = JSONObject()


        db = FirebaseFirestore.getInstance()

        db.collection("users")
            .whereEqualTo("username", username)
            .get()
            .addOnSuccessListener { documents ->
                if (documents.isEmpty) {
                    Log.d("miLogs", "No se encontraron usuarios con el username: $username")
                    // Maneja el caso donde no se encuentra ningún usuario
                } else {
                    for (document in documents) {
                        Log.d("miLogs", "${document.id} => ${document.data}")

                    }
                }
            }
            .addOnFailureListener { exception ->
                Log.w("miLogs", "Error al obtener documentos: ", exception)
                // Maneja el error
            }

    }
}