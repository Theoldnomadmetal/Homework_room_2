package data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LoginDao {
    @Insert()
    fun addLogin(login:LoginModel)
    @Query("SELECT * FROM LoginModel")
    fun getAllEtData(): List<LoginModel>
//    @Query("SELECT * FROM LoginModel WHERE login = :loginText AND password = :passwordText")
//    fun getUserData(loginText:String,passwordText:String)




}