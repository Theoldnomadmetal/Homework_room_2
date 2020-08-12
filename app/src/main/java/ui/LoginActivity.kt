package ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.homework_room_2.MyApp
import com.example.homework_room_2.R
import data.AppDataBase
import data.LoginModel

class LoginActivity : AppCompatActivity() {
    var etLogin:EditText? = null
    var etPassword:EditText? = null
    var etPasswordRepeat:EditText? = null
    var btnEnter:Button? = null
    var btnLogin:Button? = null
    private var db: AppDataBase? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        db = MyApp.app?.getDB()
        setupViews()
        setupListeners()

    }
    private fun setupViews(){
        etLogin = findViewById(R.id.etLogin)
        etPassword = findViewById(R.id.etPassword)
        etPasswordRepeat = findViewById(R.id.etPasswordRepeat)
        btnEnter = findViewById(R.id.btnEnter)
        btnLogin = findViewById(R.id.btnLogin)
    }
    private fun setupListeners(){
        btnEnter?.setOnClickListener {
            if (isNotEmpty()&&isPasswordsSimilar()){
                MyApp.app?.getDB()?.getLoginDao()?.addLogin(LoginModel(
                    login = etLogin?.text.toString(),
                    password = etPassword?.text.toString(),
                    id = 0 ))
                startActivity(Intent(this,ListActivity::class.java))
            }else{
                Toast.makeText(this,"Данные не верны",Toast.LENGTH_SHORT).show()
            }
        }

//        btnLogin?.setOnClickListener {
//            if (isNotEmpty()){
//                val result = MyApp.app?.getDB()?.getLoginDao()?.
//                getUserData(etLogin?.text.toString(), etPassword?.text.toString())
//                if(result != null)
//                    startActivity(Intent(this, ListActivity::class.java))
//                else{
//                    Toast.makeText(this,"Данные не верны",Toast.LENGTH_SHORT).show()
//                }
//
//            }else{
//                Toast.makeText(this,"Данные не верны",Toast.LENGTH_SHORT).show()
//            }
//
//        }
    }

    private fun isNotEmpty():Boolean{
        val resultLogin = etLogin?.text.toString().length>2
        val resultPassword = etPassword?.text.toString().length>2
        val resultRepeatPass = etPasswordRepeat?.text.toString().length>2

        return resultLogin && resultPassword && resultRepeatPass
    }
    private fun isPasswordsSimilar():Boolean{
        return etPassword?.text.toString() == etPasswordRepeat?.text.toString()
    }


}