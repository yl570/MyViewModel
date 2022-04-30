package com.example.myviewmodel.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myviewmodel.dao.UserDao
import com.example.myviewmodel.model.User

/**
 * Created by YiLei 2022/4/30 14:03
 *
 */
@Database(version = 1,entities = [User::class])
abstract class AppDatabase :RoomDatabase() {
    abstract  fun userDao():UserDao
    companion object{
        private var instances:AppDatabase?=null
        fun getDatabase(context: Context):AppDatabase {
            instances?.let {
                return it
            }
            return Room.databaseBuilder(context.applicationContext,AppDatabase::class.java,"app_database").build().apply {
                instances=this
            }
        }
    }
}