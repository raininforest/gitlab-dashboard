package com.github.raininforest.dashboard_user_mr.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.raininforest.dashboard_user_mr.repository.MRDashboardRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch
import javax.inject.Inject

class MRDashboardViewModel @Inject constructor(
    private val mrDashboardRepository: MRDashboardRepository
) : ViewModel() {

    private val _uiState: MutableLiveData<MrDashboardUiState> = MutableLiveData()
    val uiState: LiveData<MrDashboardUiState>
        get() = _uiState

    private val vmCoroutineScope = CoroutineScope(
        Dispatchers.IO
                + SupervisorJob()
                + CoroutineExceptionHandler { _, throwable ->
            handleError(throwable)
        })

    init {
        cancelJob()
        _uiState.postValue(MrDashboardUiState.Loading)
        vmCoroutineScope.launch {
            _uiState.postValue(MrDashboardUiState.Result(mrDashboardRepository.data()))
        }
    }

    private fun handleError(e: Throwable) {
        Log.e("GitlabDashboard", e.message ?: "Error getting data from repository")
        _uiState.postValue(MrDashboardUiState.Error(e.message.orEmpty()))
    }

    private fun cancelJob() {
        vmCoroutineScope.coroutineContext.cancelChildren()
    }
}