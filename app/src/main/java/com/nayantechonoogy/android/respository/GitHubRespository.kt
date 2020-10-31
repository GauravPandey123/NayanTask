package com.nayantechonoogy.android.respository

import androidx.lifecycle.MutableLiveData
import com.nayantechonoogy.android.datasource.getNetwokData
import com.nayantechonoogy.android.datasource.onError
import com.nayantechonoogy.android.datasource.onSuccess
import com.nayantechonoogy.android.networkservice.ApiResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GitHubRespository {

    fun getGitHUbData(): MutableLiveData<ApiResponse> {
        val result = MutableLiveData<ApiResponse>()
        CoroutineScope(Dispatchers.IO).launch {
            val requets = getNetwokData()
            requets.onSuccess {
                it.items.let { _ -> }
                result.postValue(ApiResponse(it, null))
            }
            requets.onError {
                result.postValue(ApiResponse(null, it))

            }
        }
        return result
    }

}