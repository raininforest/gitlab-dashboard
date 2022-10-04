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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MrDashboardScreen() {
    val padding = 16.dp

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(padding),
        verticalArrangement = Arrangement.spacedBy(padding),
        content = {
            items(listOf("user 1", "user 2")) {
                User(it)
            }
        }
    )
}

@Composable
fun User(user: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        content = {
            Row(
                modifier = Modifier.fillMaxSize()
            ) {
                //Image(painter = painterResource(id = R.drawable.), contentDescription = "")
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(16.dp),
                ) {
                    Text(
                        text = user,
                        fontSize = 24.sp
                    )
                    Text(
                        text = "12 MRs"
                    )
                }
            }
        }
    )
}
