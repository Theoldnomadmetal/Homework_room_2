package ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_room_2.MyApp
import com.example.homework_room_2.R
import data.AppDataBase
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {
    private var db: AppDataBase? =null
    private var loginRecycler: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        setupViews()
        db = MyApp.app?.getDB()
        setupRecycler()

    }

    private fun setupRecycler() {
        val adapter = AdapterRecycler()
        loginRecycler?.adapter = adapter
        val data = db?.getLoginDao()?.getAllEtData()

        if(data!= null)
            adapter.update(data)
    }
    private fun setupViews(){
        loginRecycler = findViewById(R.id.loginRecycler)
    }
}