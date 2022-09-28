package com.kimdevsubmission

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class People(
    var avatar: Int,
    var name: String,
    var username: String,
    var follower: String,
    var following: String,
    var repo: String,
    var company: String,
    var location: String,
):Parcelable
