package com.example.terminal.data.model

import android.icu.util.Calendar
import com.google.gson.annotations.SerializedName
import java.util.Date

class BarDto(
    @SerializedName("o") val open: Float,
    @SerializedName("c") val close: Float,
    @SerializedName("l") val low: Float,
    @SerializedName("h") val high: Float,
    @SerializedName("t") val time: Long
){
    val calendar: Calendar
        get() {
            return Calendar.getInstance().apply {
                time = Date(this@BarDto.time)
            }
        }
}