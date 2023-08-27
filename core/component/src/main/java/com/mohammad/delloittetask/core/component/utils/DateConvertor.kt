package com.mohammad.delloittetask.core.component.utils

import android.text.format.DateUtils
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Locale

/**
 * Project: Motory
 * Created: Oct 21, 2021
 *
 * @author Yousef Nasr
 */
object DateConvertor {

    fun getTimeAgo(timestamp: String): String {
        val timeInMillis = convertTimestampToMillis(timestamp)
        val currentTimeMillis = System.currentTimeMillis()
        return DateUtils.getRelativeTimeSpanString(
            timeInMillis,
            currentTimeMillis,
            DateUtils.MINUTE_IN_MILLIS
        ).toString()
    }

    private fun convertTimestampToMillis(timestamp: String): Long {
        // Parse the timestamp and convert it to milliseconds
        // You may need to adjust this code based on your specific timestamp format
        // Here's an example assuming your timestamp is in "yyyy-MM-dd HH:mm:ss" format:
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        return try {
            val date = dateFormat.parse(timestamp)
            date.time
        } catch (e: ParseException) {
            e.printStackTrace()
            0
        }
    }
}