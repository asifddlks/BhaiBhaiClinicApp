package dev.asifddlks.bhaibhaiclinicApp.ui.mainPage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.asifddlks.bhaibhaiclinicApp.model.UserModel
import dev.asifddlks.bhaibhaiclinicApp.utils.enums.UserStatusEnum

/**
 * Created by Asif Ahmed on 17/10/23.
 */

class MainPageViewModel : ViewModel() {

    var isLoading: MutableLiveData<Boolean> = MutableLiveData(false)
    var showToast: MutableLiveData<String> = MutableLiveData()
    var userStatus: MutableLiveData<UserStatusEnum> = MutableLiveData(UserStatusEnum.ACTIVE)
    var userList: MutableLiveData<MutableList<UserModel>> = MutableLiveData(mutableListOf())
    fun loadUsers() {
        isLoading.postValue(true)
        UserModel().getUsersApi { isSuccess, dataList, error ->
            isLoading.postValue(false)
            if (isSuccess) {
                userList.postValue(dataList)
            } else {
                showToast.postValue(error)
            }
        }

    }
}