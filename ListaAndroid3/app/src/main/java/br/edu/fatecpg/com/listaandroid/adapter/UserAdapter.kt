package br.edu.fatecpg.com.listaandroid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.com.listaandroid.R
import br.edu.fatecpg.com.listaandroid.model.User

class UserAdapter(private val users:List<User>):RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val txvnome = itemView.findViewById<TextView>(R.id.txv_nome)
        val txvdes = itemView.findViewById<TextView>(R.id.txv_des)
        val txvdata = itemView.findViewById<TextView>(R.id.txv_data)
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
        holder.txvdes.text = user.des
        holder.txvdata.text = user.data
    }

}