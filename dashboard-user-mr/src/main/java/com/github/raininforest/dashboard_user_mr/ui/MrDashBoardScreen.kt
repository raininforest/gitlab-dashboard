package com.github.raininforest.dashboard_user_mr.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.raininforest.dashboard_user_mr.repository.model.UserInfo

@Composable
fun MrDashboardScreen(viewModel: MRDashboardViewModel) {
    val padding = 16.dp
    val data = viewModel.userData.observeAsState(listOf())

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(padding),
        verticalArrangement = Arrangement.spacedBy(padding),
        content = {
            items(data.value) {
                User(it)
            }
        }
    )
}

@Composable
fun User(user: UserInfo) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        content = {
            Row(
                modifier = Modifier.fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(16.dp),
                ) {
                    Text(
                        text = user.userName,
                        fontSize = 24.sp
                    )
                    Text(
                        text = "${user.mrCount} MRs"
                    )
                }
            }
        }
    )
}
