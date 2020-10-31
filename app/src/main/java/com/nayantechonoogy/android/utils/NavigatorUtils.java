package com.nayantechonoogy.android.utils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

import com.nayantechonoogy.android.activity.DetailActivity;
import com.nayantechonoogy.android.model.response.ItemsItem;


public class NavigatorUtils {

    public static void redirectToDetailScreen(Activity activity,
                                              ItemsItem githubEntity,
                                              ActivityOptionsCompat options) {

        Intent intent = new Intent(activity, DetailActivity.class);
        intent.putExtra("intent_post", githubEntity);
        ActivityCompat.startActivity(activity, intent, options.toBundle());
    }

    public static void openBrowser(Activity activity,
                                   String url) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        activity.startActivity(i);
    }
}
