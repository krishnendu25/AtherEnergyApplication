package com.atherenergyassignment.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.atherenergyassignment.databinding.ActivityMainBinding
import com.atherenergyassignment.viewModel.DashboardViewModel
import com.atherenergyassignment.viewModel.DashboardViewModelFactory

class DashboardActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var mDashboardViewModel: DashboardViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.getRoot())
        initialization()
        initObserv()
    }

    private fun initObserv() {
        mDashboardViewModel.currentDate.observe(this){date->
            binding.dateTV.setText(date)
            binding.dayTV.setText("Today")
        }
        mDashboardViewModel.fetchCurrentDate()
    }

    private fun initialization() {
        mDashboardViewModel =
            ViewModelProvider(this, DashboardViewModelFactory()).get(DashboardViewModel::class.java)
    }


}