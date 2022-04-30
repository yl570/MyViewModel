package com.example.myviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.myviewmodel.database.AppDatabase
import com.example.myviewmodel.model.User
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel=ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.count.observe(this){ it ->
            TvCount.text= it.toString()
        }
        BtnPlus.setOnClickListener {
            //viewModel.count.value++
            //viewModel.plusOne()
            val userId=(0..10000).random().toString()
            viewModel.getUser(userId)
        }
//        viewModel.getUser("").observe(this){
//            it->
//            Log.v("test",it.firstname)
//        }
        viewModel.user.observe(this){ it->
            Log.v("test",it.firstname)
        }
        val user1=User("Tom","Brady",40)
        val user2=User("Tom","Hanks",63)
        val userDao=AppDatabase.getDatabase(this).userDao()
        addDataBtn.setOnClickListener {
            thread {
                user1.id=userDao.insertUser(user1)
                user2.id=userDao.insertUser(user2)
            }
        }
        queryDataBtn.setOnClickListener {
            thread {
                for (user in userDao.loadAllUser()){
                    Log.v("MainActivity",user.toString())
                }
            }
        }
        //Respository.changedata()

    }

}