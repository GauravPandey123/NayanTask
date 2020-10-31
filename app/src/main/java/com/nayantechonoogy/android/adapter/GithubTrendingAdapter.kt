package com.nayantechonoogy.android.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.nayantechonoogy.android.R
import com.nayantechonoogy.android.activity.DetailActivity
import com.nayantechonoogy.android.model.response.ItemsItem
import com.nayantechonoogy.android.utils.ShareUtils

class GithubTrendingAdapter(val activity: Activity,val arrayList: ArrayList<ItemsItem>) :
    RecyclerView.Adapter<GithubTrendingAdapter.GitHubTrendingViewHolder>() {


    inner class GitHubTrendingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val item_profile_img: ImageView = itemView.findViewById(R.id.item_profile_img)
        val item_title: TextView = itemView.findViewById(R.id.item_title)
        val item_time : TextView = itemView.findViewById(R.id.item_time)
        val item_desc : TextView = itemView.findViewById(R.id.item_desc)
        val item_img_language : ImageView = itemView.findViewById(R.id.item_img_language)
        val item_likes : TextView  = itemView.findViewById(R.id.item_likes)
        val btn_share : FloatingActionButton = itemView.findViewById(R.id.btn_share)
        val card_view : CardView = itemView.findViewById(R.id.card_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitHubTrendingViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.trending_item, parent, false)
        return GitHubTrendingViewHolder(view)
    }

    override fun onBindViewHolder(holder: GitHubTrendingViewHolder, position: Int) {
        val arrayListData = arrayList[position]
        Glide.with(activity).load(arrayListData.owner?.avatarUrl).circleCrop().into(holder.item_profile_img)
        holder.item_title.text = arrayListData.owner?.login
        holder.item_time.text = arrayListData.language
        holder.item_desc.text = arrayListData.description
        holder.item_likes.text = arrayListData.owner?.type

        holder.card_view.setOnClickListener {
            val intent = Intent(activity, DetailActivity::class.java)
            val mBundle = Bundle()
            mBundle.putSerializable("arraydata", arrayListData)
            intent.putExtras(mBundle);
            activity.startActivity(intent)

        }

        holder.btn_share.setOnClickListener {
            ShareUtils.shareUrl(activity, arrayListData.htmlUrl);

        }

    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}