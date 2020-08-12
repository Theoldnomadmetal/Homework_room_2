package data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [LoginModel::class],version = 1)
abstract class AppDataBase:RoomDatabase() {
    abstract fun getLoginDao():LoginDao
}