package br.edu.fatecpg.com.listaandroid

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.com.listaandroid.adapter.UserAdapter
import br.edu.fatecpg.com.listaandroid.dao.UserDao
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListActivity : AppCompatActivity(R.layout.activity_list) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val dao = UserDao()
        val users = dao.getUsers()
        val fabList = findViewById<FloatingActionButton>(R.id.btn_sair)
        Log.i("ListUsers", users.toString())
        val rvUsers = findViewById<RecyclerView>(R.id.rv_users)

        rvUsers.layoutManager = LinearLayoutManager(this)
        rvUsers.adapter = UserAdapter(users)

        fabList.setOnClickListener {
            finish()
        }
    }
}