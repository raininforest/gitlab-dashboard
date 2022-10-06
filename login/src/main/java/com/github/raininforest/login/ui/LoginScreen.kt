package com.github.raininforest.login.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(viewModel: LoginViewModel, onGo: () -> Unit) {
    val verticalPadding = 16.dp
    val horizontalPadding = 32.dp

    val hostText = viewModel.host.observeAsState("")
    val projectIdText = viewModel.projectId.observeAsState("")
    val tokenText = viewModel.token.observeAsState("")

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(
            modifier = Modifier
                .padding(start = horizontalPadding, end = horizontalPadding, bottom = verticalPadding)
                .fillMaxWidth(),
            value = hostText.value,
            onValueChange = { viewModel.setHost(it) },
            label = { Text(text = "Repository host") }
        )
        OutlinedTextField(
            modifier = Modifier
                .padding(start = horizontalPadding, end = horizontalPadding, bottom = verticalPadding)
                .fillMaxWidth(),
            value = projectIdText.value,
            onValueChange = { viewModel.setProjectId(it) },
            label = { Text(text = "Project id") }
        )
        OutlinedTextField(
            modifier = Modifier
                .padding(start = horizontalPadding, end = horizontalPadding, bottom = verticalPadding)
                .fillMaxWidth(),
            value = tokenText.value,
            onValueChange = { viewModel.setToken(it) },
            label = { Text(text = "Personal access token") }
        )
        Button(
            onClick = {
                viewModel.onGo()
                onGo.invoke()
            },
            content = { Text(text = "Go") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = horizontalPadding)
                .padding(top = 8.dp)
                .height(56.dp)
        )
    }
}
