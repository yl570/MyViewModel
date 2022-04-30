package com.example.myviewmodel

import android.os.Handler
import android.os.Message
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.myviewmodel.model.User


/**
 * Created by YiLei 2022/4/27 16:50
 *
 */
class MainViewModel: ViewModel() {
    private var _count=MutableLiveData<Int>()
    private val userIDLiveData=MutableLiveData<String>()
    val user:LiveData<User> = Transformations.switchMap(userIDLiveData){it->
        Respository.getUser(it)
    }
    val count:LiveData<Int>
        get() =_count
    private val handler=object : Handler(){
        override fun handleMessage(msg: Message) {
            when(msg.what){

                0->{
                    val it=_count.value?:0
                    _count.value= it+1
                }
            }
        }
    }

    fun plusOne(){
        Thread(Runnable {
            Thread.sleep(2000)
            handler.sendEmptyMessage(0)

        }).start()
    }
//    fun getUser(userId: String):LiveData<User>{
//        return Respository.getUser(userId)
//    }
fun getUser(userId: String){
    userIDLiveData.value=userId
}
}
object Respository{

    private val liveData=MutableLiveData<User>()
    private val handler=object : Handler(){
        override fun handleMessage(msg: Message) {
            when(msg.what){
                0->liveData.value=User("userId","",1)
            }
        }
    }
    fun getUser(userId:String):LiveData<User>{
            liveData.value=User(userId,"$userId",0)
        return liveData
    }
    fun changedata(){
        Thread(Runnable {
            Thread.sleep(2000)

            handler.sendEmptyMessage(0)

        }).start()
    }
}