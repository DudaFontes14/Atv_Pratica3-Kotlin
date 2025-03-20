package br.edu.fatecpg.com.listaandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecpg.com.listaandroid.model.User
import com.google.android.material.floatingactionbutton.FloatingActionButton
import br.edu.fatecpg.com.listaandroid.dao.UserDao

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val edtnome = findViewById<EditText>(R.id.edt_nome)
        val edtgen = findViewById<EditText>(R.id.edt_gen)
        val edtnota = findViewById<EditText>(R.id.edt_nota)
        val btnSave = findViewById<Button>(R.id.btn_save)
        val fabList = findViewById<FloatingActionButton>(R.id.fab_list)
        val dao = UserDao()
        btnSave.setOnClickListener{
            val nome = edtnome.text.toString()
            val gen = edtgen.text.toString()
            val nota = edtnota.text.toString()
            val user = User(nome, gen, nota)
            dao.addUser(user)
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Sucesso")
            builder.setMessage("Filme Adicionado com Sucesso")
            val dialog = builder.create()
            dialog.show()
            edtnome.text.clear()
            edtgen.text.clear()
            edtnota.text.clear()
        }
        fabList.setOnClickListener{
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }
    }
}