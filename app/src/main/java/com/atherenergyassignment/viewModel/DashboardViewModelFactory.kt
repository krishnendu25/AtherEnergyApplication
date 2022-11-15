package com.atherenergyassignment.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class DashboardViewModelFactory () : ViewModelProvider.NewInstanceFactory() {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DashboardViewModel() as T
    }
}