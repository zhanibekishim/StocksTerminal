package com.example.terminal.data.model

import android.icu.util.Calendar
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.Date
@Parcelize
class BarDto(
    @SerializedName("o") val open: Float,
    @SerializedName("c") val close: Float,
    @SerializedName("l") val low: Float,
    @SerializedName("h") val high: Float,
    @SerializedName("t") val time: Long
):Parcelable{
    val calendar: Calendar
        get() {
            return Calendar.getInstance().apply {
                time = Date(this@BarDto.time)
            }
        }
}