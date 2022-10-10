package com.github.raininforest.dashboard_user_mr.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.github.raininforest.dashboard_user_mr.repository.model.UserInfo

private val padding = 16.dp

@Composable
fun MrDashboardScreen(viewModel: MRDashboardViewModel) {
    val screenState = viewModel.uiState.observeAsState(MrDashboardUiState.Loading)

    when (val screenStateValue = screenState.value) {
        is MrDashboardUiState.Loading -> Loading()
        is MrDashboardUiState.Result -> UserList(data = screenStateValue.data)
        is MrDashboardUiState.Error -> ErrorSnackbar(errorMsg = screenStateValue.errorMsg)
    }
}

@Composable
fun Loading() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
    ) {
        CircularProgressIndicator(
            modifier = Modifier.align(Alignment.Center),
            color = MaterialTheme.colors.primary,
        )
    }
}

@Composable
fun ErrorSnackbar(errorMsg: String) {
    Snackbar {
        Text(text = errorMsg)
    }
}

@Composable
fun UserList(data: List<UserInfo>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(padding),
        verticalArrangement = Arrangement.spacedBy(padding),
        content = {
            items(data) { userData ->
                User(userData)
            }
        }
    )
}

@Composable
fun User(user: UserInfo) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .defaultMinSize(92.dp)
            .shadow(8.dp),
        shape = RoundedCornerShape(4.dp),
        content = {
            Row {
                Image(
                    painter = rememberImagePainter(user.avaUrl),
                    contentDescription = "avatar",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(padding)
                        .height(48.dp)
                        .width(48.dp)
                        .align(Alignment.CenterVertically),
                )
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = user.userName,
                        fontSize = 14.sp
                    )
                    Text(
                        text = "${user.mrCount} MRs"
                    )
                }
            }
        }
    )
}
