package com.nayantechonoogy.android.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.nayantechonoogy.android.networkservice.ApiResponse
import com.nayantechonoogy.android.respository.GitHubRespository

class GitHubTrendinViewModel(application: Application) : AndroidViewModel(application) {

    private val userDetailRepository: GitHubRespository by lazy {
        GitHubRespository()
    }

    fun getUserData(): MutableLiveData<ApiResponse> {
        return userDetailRepository.getGitHUbData()
    }
}