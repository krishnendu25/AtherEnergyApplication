package com.atherenergyassignment.ui.activity


import android.os.Bundle
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import com.atherenergyassignment.databinding.ActivityMainBinding
import com.atherenergyassignment.utils.Constants
import com.atherenergyassignment.viewModel.DashboardViewModel
import com.atherenergyassignment.viewModel.DashboardViewModelFactory


class DashboardActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {
    lateinit var binding: ActivityMainBinding
    lateinit var mDashboardViewModel: DashboardViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.getRoot())
        initialization()
        initObserv()
        themeConfig()


    }

    private fun themeConfig() {
        // pick which theme DAY or NIGHT from settings
        if (mDashboardViewModel.preferenceHelper.getString(Constants.THEME).isNullOrEmpty()) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        } else {
            if (mDashboardViewModel.preferenceHelper.getString(Constants.THEME)
                    .equals(Constants.LIGHT)
            )
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

        }
    }

    private fun initObserv() {
        mDashboardViewModel.currentDate.observe(this) { date ->
            binding.dateTV.setText(date)
            binding.dayTV.setText("Today")
        }
        mDashboardViewModel.fetchCurrentDate()
    }

    private fun initialization() {
        mDashboardViewModel =
            ViewModelProvider(this, DashboardViewModelFactory()).get(DashboardViewModel::class.java)
        binding.dayNightTigger.setOnCheckedChangeListener(this)
    }

    override fun onCheckedChanged(compoundButton: CompoundButton?, isChecked: Boolean) {
        if (mDashboardViewModel.oldflag != isChecked) {
            mDashboardViewModel.oldflag = isChecked
            mDashboardViewModel.tiggerThemeChange(isChecked)
            this@DashboardActivity.recreate()
        }
    }
}