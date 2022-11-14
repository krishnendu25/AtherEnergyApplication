package com.atherenergyassignment.utils

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

 object DateUtil{

    const val PATTERN_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss"
    const val PATTERN_YYYY_MM_DD = "yyyy-MM-dd"
    const val PATTERN_DD_MM_YYYY = "dd-MM-yyyy"
    const val DIGITAL_GOLD_FORMAT = "d MMM yyyy',' h:mm a"
    const val FHCR_DATE_FORMAT = "dd-mm-yy"

    /**
     * @param currentDateTime= provide actul date to be parsed  ex.("30-07-2019 14:41:38")
     * @param currentDateTimeFormat= input date format ex. ("dd-MM-yyyy hh:mm:ss")
     * @param newDateTimeFormat= outPut date format ex.("h:mm a 'on' d MMM yyyy")
     * @author Created by 1000292 on 17,June,2020
     * @return it returns list date in string format if exception occures it returns currentDateTime
     */
    fun universalParseDate(currentDateTime: String, currentDateTimeFormat: String, newDateTimeFormat: String): String {
        return try {
            val inputSimpleDateFormat = SimpleDateFormat(currentDateTimeFormat, Locale.getDefault())
            val date = inputSimpleDateFormat.parse(currentDateTime)

            val outputSimpleDateFormat = SimpleDateFormat(newDateTimeFormat, Locale.getDefault())
            outputSimpleDateFormat.format(date!!)
        }catch (e: Exception){
            Log.d(DateUtil::class.java.simpleName,"Exception while parsing date")
            currentDateTime
        }
    }

    /**
     * get current time
     * @param datePattern=  ex. ("dd-MM-yyyy hh:mm:ss")
     * @return date string
     */
    fun getCurrentDate(datePattern:String):String{
        return try {
           return SimpleDateFormat(datePattern, Locale.getDefault()).format(Date())
        }catch (e: Exception){
            Log.d(DateUtil::class.java.simpleName,"Exception while parsing date")
             ""
        }
    }
}
