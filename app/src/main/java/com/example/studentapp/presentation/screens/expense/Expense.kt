package com.example.studentapp.presentation.screens.expense

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.studentapp.domain.models.Expense
import kotlinx.coroutines.delay


@Composable
fun Expense(
    usn: String, expenseViewModel: ExpenseViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = Unit, block = {
        expenseViewModel.getExpense(usn)
        delay(100)
    })

    val t1 = expenseViewModel.tuition.collectAsState(initial = "")
    val t2 = expenseViewModel.txtBook.collectAsState(initial = "")
    val t3 = expenseViewModel.stationery.collectAsState(initial = "")
    val t4 = expenseViewModel.other.collectAsState(initial = "")


    var tuition by remember { mutableStateOf(t1.value) }
    var txtBook by remember { mutableStateOf(t2.value) }
    var stationery by remember { mutableStateOf(t3.value) }
    var other by remember { mutableStateOf(t4.value) }

    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(text = "Tuition : ${t1.value}")
            TextField(
                value = tuition,
                onValueChange = { tuition = it },
                label = { Text("Enter Tuition Fess") },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(text = "Txt Book : ${t2.value}")
            TextField(
                value = txtBook,
                onValueChange = { txtBook = it },
                label = { Text("Enter Txt Book amount") },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(text = "Stationery : ${t3.value}")
            TextField(
                value = stationery,
                onValueChange = { stationery = it },
                label = { Text("Enter stationery Amount") },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(text = "Other : ${t4.value}")
            TextField(
                value = other,
                onValueChange = { other = it },
                label = { Text("Enter Other amount") },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )

        }

        Button(onClick = {
            expenseViewModel.updateExpense(
                Expense(
                    usn, tuition, txtBook, stationery, other
                )
            )
        }) {
            Text(text = "Save")
        }
    }
}