package com.atherenergyassignment.viewModel

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.atherenergyassignment.AtherEnergyApplication
import com.atherenergyassignment.utils.Constants
import com.atherenergyassignment.utils.DateUtil
import com.atherenergyassignment.utils.SharedPreferenceHelper

class DashboardViewModel(val context: AtherEnergyApplication) : AndroidViewModel(context) {
    var currentDate = MutableLiveData<String>()
    var oldflag = false
    val preferenceHelper: SharedPreferenceHelper by lazy {
        SharedPreferenceHelper(context)
    }

    fun fetchCurrentDate() {
        currentDate.value = DateUtil.getCurrentDateFull()
    }

    fun tiggerThemeChange(checked: Boolean) {
        if (checked) {
            //Change To Dark Theme
            preferenceHelper.putValue(Constants.THEME, Constants.DARK)
        } else {
            //Change To Light Theme
            preferenceHelper.putValue(Constants.THEME, Constants.LIGHT)
        }
    }

}