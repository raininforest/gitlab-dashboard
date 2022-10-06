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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(viewModel: LoginViewModel, onGo: () -> Unit) {
    val verticalPadding = 16.dp
    val horizontalPadding = 32.dp

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val hostText = remember { mutableStateOf("") }
        val projectIdText = remember { mutableStateOf("") }
        val tokenText = remember { mutableStateOf("") }

        OutlinedTextField(
            modifier = Modifier
                .padding(start = horizontalPadding, end = horizontalPadding, bottom = verticalPadding)
                .fillMaxWidth(),
            value = hostText.value,
            onValueChange = { hostText.value = it },
            label = { Text(text = "Repository host") }
        )
        OutlinedTextField(
            modifier = Modifier
                .padding(start = horizontalPadding, end = horizontalPadding, bottom = verticalPadding)
                .fillMaxWidth(),
            value = projectIdText.value,
            onValueChange = {
                projectIdText.value = it
            },
            label = { Text(text = "Project id") }
        )
        OutlinedTextField(
            modifier = Modifier
                .padding(start = horizontalPadding, end = horizontalPadding, bottom = verticalPadding)
                .fillMaxWidth(),
            value = tokenText.value,
            onValueChange = { tokenText.value = it },
            label = { Text(text = "Personal access token") }
        )
        Button(
            onClick = {
                viewModel.setHost(hostText.value)
                viewModel.setProjectId(projectIdText.value)
                viewModel.setToken(tokenText.value)
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
