package com.hahow.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import `in`.hahow.android_recruit_project.R


/**
 * 藉由 thumbnail 加載 placeholder 有圓角
 * */
fun ImageView.loadUrl(
    url: String,
    roundedCorners: Int = 20,
    placeholder: Int = R.drawable.img_placeholder
) {
    Glide.with(context)
        .load(url)
        .apply(
            RequestOptions()
                .placeholder(placeholder)
                .transform(RoundedCorners(roundedCorners))
        )
        .thumbnail(
            Glide.with(context)
                .load(placeholder)
                .apply(RequestOptions().transform(RoundedCorners(roundedCorners)))
        ) // 添加圆角转换
        .into(this)
}