package com.nayantechonoogy.android.utils

import android.app.Activity
import android.content.Context
import androidx.core.app.ShareCompat

object ShareUtils {
    fun shareUrl(
        activity: Activity?,
        url: String?
    ) {
        ShareCompat.IntentBuilder
            .from(activity!!)
            .setType("text/plain")
            .setChooserTitle("Share URL")
            .setText(url)
            .startChooser()
    }
}
