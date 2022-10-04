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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen() {
    val verticalPadding = 16.dp
    val horizontalPadding = 32.dp

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
            value = "",
            onValueChange = {},
            label = { Text(text = "Repository / Project") }
        )
        OutlinedTextField(
            modifier = Modifier
                .padding(start = horizontalPadding, end = horizontalPadding, bottom = verticalPadding)
                .fillMaxWidth(),
            value = "",
            onValueChange = {},
            label = { Text(text = "Access token") }
        )
        Button(
            onClick = {},
            content = { Text(text = "Go") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = horizontalPadding)
                .padding(top = 8.dp)
                .height(56.dp)
        )
    }
}
