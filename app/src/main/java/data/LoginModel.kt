package data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class LoginModel(
    @PrimaryKey(autoGenerate = true)
    val id :Int,
    val login:String,
    val password:String
)