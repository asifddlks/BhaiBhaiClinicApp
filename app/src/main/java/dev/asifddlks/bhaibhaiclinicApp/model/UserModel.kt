package dev.asifddlks.bhaibhaiclinicApp.model

import dev.asifddlks.bhaibhaiclinicApp.networkCommunication.NetworkManager
import dev.asifddlks.bhaibhaiclinicApp.networkCommunication.RequestListener
import dev.asifddlks.bhaibhaiclinicApp.utils.constants.ApiConstants
import dev.asifddlks.bhaibhaiclinicApp.utils.enums.GenderEnum
import dev.asifddlks.bhaibhaiclinicApp.utils.enums.UserStatusEnum
import dev.asifddlks.bhaibhaiclinicApp.utils.extensions.parseInt
import dev.asifddlks.bhaibhaiclinicApp.utils.extensions.parseString
import org.json.JSONArray
import retrofit2.Response
import timber.log.Timber
import java.net.ConnectException

/**
 * Created by Asif Ahmed on 17/10/23.
 */
/*"id": 5366063,
"name": "Brahmdev Deshpande",
"email": "brahmdev_deshpande@rogahn.test",
"gender": "female",
"status": "inactive"*/
data class UserModel(
    var id: Int = -1,
    var name: String = "",
    var email: String = "",
    var gender: GenderEnum = GenderEnum.NONE,
    var status: UserStatusEnum = UserStatusEnum.UNKNOWN,
) {

    fun getUsersApi(
        callback: (Boolean, MutableList<UserModel>?, String?) -> Unit
    ) {
        try {
            val url = ApiConstants.USERS
            NetworkManager().getRequest(
                url = url,
                listener = object :
                    RequestListener {
                    override fun onSuccess(response: Any?) {
                        val responseObject = (response as? Response<*>)
                        val responseBody = responseObject?.body().toString()
                        val body = JSONArray(responseBody)

                        val dataList = mutableListOf<UserModel>()

                        for (i in 0 until body.length()) {
                            val itemJsonObject = body.getJSONObject(i)

                            val userModel: UserModel = UserModel()
                            itemJsonObject.parseInt("id")?.let {
                                userModel.id = it
                            }
                            itemJsonObject.parseString("name")?.let {
                                userModel.name = it
                            }
                            itemJsonObject.parseString("email")?.let {
                                userModel.email = it
                            }
                            itemJsonObject.parseString("gender")?.let {
                                if (it.equals(GenderEnum.MALE.name, ignoreCase = true)) {
                                    userModel.gender = GenderEnum.MALE
                                } else if (it.equals(GenderEnum.FEMALE.name, ignoreCase = true)) {
                                    userModel.gender = GenderEnum.FEMALE
                                } else {
                                    userModel.gender = GenderEnum.NONE
                                }
                            }
                            itemJsonObject.parseString("status")?.let {
                                if (it.equals(UserStatusEnum.ACTIVE.name, ignoreCase = true)) {
                                    userModel.status = UserStatusEnum.ACTIVE
                                } else {
                                    userModel.status = UserStatusEnum.INACTIVE
                                }
                            }
                            dataList.add(userModel)
                        }
                        callback(true, dataList, null)
                    }

                    override fun onError(error: String) {
                        Timber.e("error $error")
                        callback(false, null, error)
                    }

                })
        } catch (conEx: ConnectException) {
            callback(false, null, "Connection refused")
        } catch (ex: Exception) {
            callback(false, null, ex.cause.toString())
        }
    }
}
