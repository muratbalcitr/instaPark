package com.veripark.instapark.ui.users

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.veripark.instapark.data.model.Users
import com.veripark.instapark.data.repository.MainRepository
import com.veripark.instapark.utils.NetworkHelper
import com.veripark.instapark.utils.Resource
import kotlinx.coroutines.launch

class UsersViewModel@ViewModelInject constructor(

    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper

) : ViewModel() {

    private val _users = MutableLiveData<Resource<List<Users>>>()
    val users: LiveData<Resource<List<Users>>>
        get() = _users

    init {
        fetchUsers()
    }

    private fun fetchUsers(){
        viewModelScope.launch {
            _users.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                mainRepository.getUsers().let {
                    if (it.isSuccessful) {
                        _users.postValue(Resource.success(it.body()))
                    } else _users.postValue(Resource.error(it.errorBody().toString(), null))
                }
            } else _users.postValue(Resource.error("No internet connection", null))
        }
    }
}