package com.github.raininforest.home.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.raininforest.home.repository.DashboardItem
import com.github.raininforest.home.repository.HomeRepository
import javax.inject.Inject

class HomeViewModel @Inject constructor(homeRepository: HomeRepository) : ViewModel() {

    private val _dashboardItems: MutableLiveData<List<DashboardItem>> = MutableLiveData()
    val dashboardItems: LiveData<List<DashboardItem>>
        get() = _dashboardItems

    init {
        _dashboardItems.value = homeRepository.dashboardItems
    }
}