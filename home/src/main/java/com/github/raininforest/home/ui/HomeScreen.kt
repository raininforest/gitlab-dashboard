package com.github.raininforest.home.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.github.raininforest.navigation.NavigationDestination

@Composable
fun HomeScreen(onItemClick: (String) -> Unit) {
    val padding = 16.dp

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(padding),
        verticalArrangement = Arrangement.spacedBy(padding),
        horizontalArrangement = Arrangement.spacedBy(padding)
    ) {
        items(listOf("TOP-5 users with high MR count", "empty", "empty", "empty", "empty", "empty")) {
            DashboardItem(text = it, onClick = { onItemClick(NavigationDestination.DashboardUserMr.route) })
        }
    }
}

@Composable
fun DashboardItem(text: String, onClick: () -> Unit) {
    OutlinedButton(
        modifier = Modifier
            .defaultMinSize(minWidth = 192.dp, minHeight = 192.dp),
        shape = RoundedCornerShape(16.dp),
        content = {
            Text(text, textAlign = TextAlign.Center)
        },
        onClick = onClick
    )
}
