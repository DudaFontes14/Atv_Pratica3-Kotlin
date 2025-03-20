package br.edu.fatecpg.com.listaandroid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.com.listaandroid.R
import br.edu.fatecpg.com.listaandroid.model.User

class UserAdapter(private val users:List<User>):RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val txvnome = itemView.findViewById<TextView>(R.id.txv_nome)
        val txvgen = itemView.findViewById<TextView>(R.id.txv_gen)
        val txvnota = itemView.findViewById<TextView>(R.id.txv_nota)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users[position]
        holder.txvnome.text = user.nome
        holder.txvgen.text = user.gen
        holder.txvnota.text = user.nota
    }

}