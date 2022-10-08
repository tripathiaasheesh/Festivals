package com.gdsc_core_tripathi.festivals

import android.media.Image
import androidx.annotation.DrawableRes

data class Message(
    val name: String,
    val message:String,
    @DrawableRes val profileImage: Int
)
