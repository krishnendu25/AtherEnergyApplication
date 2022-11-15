package com.atherenergyassignment.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.atherenergyassignment.utils.DateUtil
import com.atherenergyassignment.utils.DateUtil.PATTERN_DD_MM_YYYY
import java.text.DateFormat

class DashboardViewModel: ViewModel() {
    var currentDate = MutableLiveData<String>()

    fun fetchCurrentDate(){
        currentDate.value= DateUtil.getCurrentDateFull()
    }


}