package com.nayantechonoogy.android.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.nayantechonoogy.android.R
import com.nayantechonoogy.android.model.response.ItemsItem
import com.nayantechonoogy.android.utils.NavigatorUtils
import com.nayantechonoogy.android.utils.ShareUtils
import kotlinx.android.synthetic.main.detail_activity.*

class DetailActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)
        val intent = intent
        val extras = intent.extras
        if(extras!=null){
            val transactionDetails: ItemsItem =
                extras.getSerializable("arraydata") as ItemsItem
            Glide.with(this).load(transactionDetails.owner?.avatarUrl).circleCrop().into(
                item_profile_img
            )
            item_title.setText(transactionDetails.language)
            item_stars.setText(transactionDetails.stargazersCount.toString())
            item_watchers.setText(transactionDetails.watchersCount.toString())
            item_forks.setText(transactionDetails.forks.toString())
            btn_share.setOnClickListener(View.OnClickListener {
                ShareUtils.shareUrl(this, transactionDetails.htmlUrl);
            })

            btn_visit.setOnClickListener(View.OnClickListener {
                NavigatorUtils.openBrowser(this, transactionDetails.htmlUrl)
            })

        }


    }
}