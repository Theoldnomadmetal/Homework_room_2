package ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import data.LoginModel
import kotlinx.android.synthetic.main.recycler_layout.view.*

class ViewHolder(view: View):RecyclerView.ViewHolder(view) {

    fun bind(loginModel: LoginModel){
        itemView.new_login.text = loginModel.login
        itemView.new_pass.text = loginModel.id.toString()

    }


}