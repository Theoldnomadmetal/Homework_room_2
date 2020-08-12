package com.example.homework_room_2

import android.app.Application
import androidx.room.Room
import data.AppDataBase

class MyApp:Application() {
    private var db : AppDataBase? = null
    override fun onCreate() {

        super.onCreate()
        app = this
        db = Room.databaseBuilder(this,AppDataBase::class.java,"MY_DATA")
            .allowMainThreadQueries()
            .build()
    }
    fun getDB() = db
    companion object{
        var app:MyApp? = null
    }
}