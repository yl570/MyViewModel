package com.example.myviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.myviewmodel.model.User

/**
 * Created by YiLei 2022/4/29 11:02
 *
 */
class MapViewModel: ViewModel() {
    private val user=MutableLiveData<User>()
    val userName:LiveData<String> = Transformations.map(user){
        it->
        "${it.firstname} ${it.lastName}"
    }
}