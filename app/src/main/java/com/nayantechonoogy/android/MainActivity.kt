package com.nayantechonoogy.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.nayantechonoogy.android.adapter.GithubTrendingAdapter
import com.nayantechonoogy.android.model.response.GithubTrendingResponse
import com.nayantechonoogy.android.model.response.ItemsItem
import com.nayantechonoogy.android.viewmodels.GitHubTrendinViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var arrayListGitHub: ArrayList<ItemsItem>

    private val gitHubTrendinViewModel: GitHubTrendinViewModel by lazy {
        ViewModelProvider(this).get(GitHubTrendinViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        arrayListGitHub = ArrayList()
        setUpElements()
    }

    private fun setUpElements() {
        gitHubTrendinViewModel.getUserData().observe(this, Observer {
            val response = it.response as GithubTrendingResponse
            contatinProgresBarDashBoard.visibility = View.GONE
            setupWebService(response.items)

        })
    }

    private fun setupWebService(items: ArrayList<ItemsItem>) {
        arrayListGitHub.addAll(items)
        val adapter = GithubTrendingAdapter(this, arrayListGitHub)
        recylerViewGithub.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recylerViewGithub.adapter = adapter

    }
}