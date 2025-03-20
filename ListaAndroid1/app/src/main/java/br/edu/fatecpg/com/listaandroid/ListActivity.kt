package br.edu.fatecpg.com.listaandroid

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.com.listaandroid.adapter.UserAdapter
import br.edu.fatecpg.com.listaandroid.dao.UserDao

class ListActivity : AppCompatActivity(R.layout.activity_list) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val dao = UserDao()
        val users = dao.getUsers()
        Log.i("ListUsers", users.toString())
        val rvUsers = findViewById<RecyclerView>(R.id.rv_filmes)

        rvUsers.layoutManager = LinearLayoutManager(this)
        rvUsers.adapter = UserAdapter(users)

    }
}