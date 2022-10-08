package com.github.raininforest.datepicker.ui

import android.app.DatePickerDialog
import android.content.Context
import android.widget.DatePicker
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.github.raininforest.core.model.DateModel
import java.util.*

private val padding = 16.dp

@Composable
fun DatePickerScreen(viewModel: DatePickerViewModel, onNextClick: () -> Unit) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val fromDate = viewModel.fromDateUi.observeAsState("")
        val toDate = viewModel.toDateUi.observeAsState("")
        DateButton(text = "From: ${fromDate.value}") {
            showDatePicker(context = context, updatedDate = { fromDateInMs -> viewModel setFromDate fromDateInMs })
        }
        DateButton(text = "To: ${toDate.value}") {
            showDatePicker(context = context, updatedDate = { toDateInMs -> viewModel setToDate toDateInMs })
        }
        Button(
            onClick = onNextClick,
            content = { Text(text = "Next") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = padding)
                .padding(top = 8.dp)
                .height(56.dp)
        )
    }
}

@Composable
fun DateButton(text: String, onClick: () -> Unit) {
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = padding, end = padding, bottom = padding),

        ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(36.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(Icons.Default.DateRange, contentDescription = "Localized description")
            Text(
                text = text,
                modifier = Modifier.padding(horizontal = padding)
            )
        }
    }
}

private fun showDatePicker(
    context: Context,
    updatedDate: (DateModel) -> Unit
) {
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)
    calendar.time = Date()

    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, _year: Int, _month: Int, _dayOfMonth: Int ->
            updatedDate(DateModel(year = _year, month = _month, dayOfMonth = _dayOfMonth))
        },
        year,
        month,
        day
    )
    datePickerDialog.show()
}