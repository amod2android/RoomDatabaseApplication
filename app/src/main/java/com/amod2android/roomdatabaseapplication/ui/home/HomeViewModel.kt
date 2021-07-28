package com.amod2android.roomdatabaseapplication.ui.home

import android.app.Application
import android.renderscript.Sampler
import androidx.lifecycle.*
import com.amod2android.roomdatabaseapplication.database.DatabaseBuilder
import com.amod2android.roomdatabaseapplication.database.User
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private var usersList: MutableLiveData<List<User>>
    private val db = DatabaseBuilder.getInstance(application)

    init {
        usersList = MutableLiveData()
        setValue()
    }

    fun setValue() {
        viewModelScope.launch {
            usersList.value = db.getUserDao().getAll()
        }
    }

    val users: LiveData<List<User>> = usersList
}
