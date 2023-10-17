package dev.asifddlks.bhaibhaiclinicApp.createOrUpdatePage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.asifddlks.bhaibhaiclinicApp.model.UserModel

/**
 * Created by Asif Ahmed on 17/10/23.
 */

class CreateOrUpdatePageViewModel : ViewModel() {

    var isLoading: MutableLiveData<Boolean> = MutableLiveData(false)
    var showToast: MutableLiveData<String> = MutableLiveData()
    var userItem: UserModel? = null

    fun updateUser(tempUser: UserModel) {
        isLoading.postValue(true)
        userItem?.updateUserApi(tempUser) { isSuccess, error ->
            isLoading.postValue(false)
            if (isSuccess) {
                showToast.postValue("Updated Successfully!")
            } else {
                showToast.postValue(error)
            }
        }
    }

    fun createUser(tempUser: UserModel) {
        isLoading.postValue(true)
        tempUser.createUserApi() { isSuccess, error ->
            isLoading.postValue(false)
            if (isSuccess) {
                showToast.postValue("User Created!")
            } else {
                showToast.postValue(error)
            }
        }
    }
}