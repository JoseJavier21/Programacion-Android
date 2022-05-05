package com.example.appgatosfinal.dataclass

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class RespuestaVoto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("message")
    val message: String
) : Parcelable