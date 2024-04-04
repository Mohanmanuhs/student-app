package com.example.studentapp.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.studentapp.navigation.Screen


@Composable
fun Home(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { navController.navigate(Screen.Subjects.route) }) {
            Text(text = "Subjects")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { navController.navigate(Screen.Expense.route) }) {
            Text(text = "Expense")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { navController.navigate(Screen.Details.route) }) {
            Text(text = "Details")
        }

    }
}
