package com.github.raininforest.datepicker.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.raininforest.core.model.DateModel
import com.github.raininforest.core.model.toDateTime
import com.github.raininforest.core.model.toHumanString
import com.github.raininforest.datepicker.service.DateStorage
import javax.inject.Inject

class DatePickerViewModel @Inject constructor(
    private val dateStorage: DateStorage
): ViewModel() {

    private val _fromDateUi = MutableLiveData<String>()
    val fromDateUi: LiveData<String>
        get() = _fromDateUi
    private val _toDateUi = MutableLiveData<String>()
    val toDateUi: LiveData<String>
        get() = _toDateUi

    infix fun setFromDate(fromDate: DateModel) {
        _fromDateUi.postValue(fromDate.toHumanString())
        dateStorage.fromDate = fromDate.toDateTime()
    }

    infix fun setToDate(toDate: DateModel) {
        _toDateUi.postValue(toDate.toHumanString())
        dateStorage.toDate = toDate.toDateTime()
    }
}