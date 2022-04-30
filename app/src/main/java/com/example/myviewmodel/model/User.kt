package com.example.myviewmodel.model

import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Created by YiLei 2022/4/29 11:10
 *
 */
@Entity
data class User(var firstname:String,var lastName: String,var age:Int){
    @PrimaryKey(autoGenerate = true)
    var id:Long=0
}