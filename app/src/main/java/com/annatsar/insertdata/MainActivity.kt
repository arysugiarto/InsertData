package com.annatsar.insertdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var ref : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        ref = FirebaseDatabase.getInstance().getReference("USERS")

        ButtonSave.setOnClickListener {
            savedata()
            val intent = Intent (this, Show::class.java)
            startActivity(intent)
        }
    }

    private fun savedata() {
        val nim = inputNIM.text.toString()
        val nama = inputNama.text.toString()
        val jurusan = inputJurusan.text.toString()
        val universitas = inputUniversitas.text.toString()


        val user = Users (nim,nama,jurusan,universitas)
        val userId = ref.push().key.toString()

        ref.child(userId).setValue(user).addOnCompleteListener {
            Toast.makeText(this, "Successs", Toast.LENGTH_SHORT).show()
            inputNIM.setText("")
            inputNama.setText("")
            inputJurusan.setText("")
            inputUniversitas.setText("")
        }
    }
}
