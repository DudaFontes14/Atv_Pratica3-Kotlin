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
        val edtdes = findViewById<EditText>(R.id.edt_des)
        val edtdata = findViewById<EditText>(R.id.edt_data)
        val btnSave = findViewById<Button>(R.id.btn_save)
        val fabList = findViewById<FloatingActionButton>(R.id.fab_list)
        val dao = UserDao()
        btnSave.setOnClickListener{
            val nome = edtnome.text.toString()
            val des = edtdes.text.toString()
            val data = edtdata.text.toString()
            val user = User(nome,des,data)
            dao.addUser(user)
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Sucesso")
            builder.setMessage("Tarefa Criada com Sucesso")
            val dialog = builder.create()
            dialog.show()
            edtnome.text.clear()
            edtdes.text.clear()
            edtdata.text.clear()
        }
        fabList.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }
    }
}