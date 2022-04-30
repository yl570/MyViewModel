package com.example.myviewmodel.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myviewmodel.model.User

/**
 * Created by YiLei 2022/4/30 13:52
 *
 */
@Dao
interface UserDao {
    @Insert
    fun insertUser(user:User):Long
    @Query("select * from User")
    fun loadAllUser():List<User>
}