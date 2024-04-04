package com.example.studentapp.presentation.screens.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import com.example.studentapp.domain.models.Student
import kotlinx.coroutines.delay


@Composable
fun Details(
    usn: String, detailViewModel: DetailViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = Unit, block = {
        detailViewModel.getStudent(usn)
        detailViewModel.getSubjects(usn)
        delay(1000)
    })

    val n = detailViewModel.name.collectAsState(initial="")
    val s = detailViewModel.sem.collectAsState(initial="")


    var name by remember { mutableStateOf(n.value) }
    var sem by remember { mutableStateOf(s.value) }


    Column(
        modifier = Modifier
            .fillMaxSize().padding(20.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Usn : $usn")

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(text = "name : ${n.value}")
            TextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("update Name") },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(text = "sem : ${s.value}")
            TextField(
                value = sem,
                onValueChange = { sem = it },
                label = { Text("update sem") },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )
        }
        Button(onClick = {
            detailViewModel.upDateStudent(
                Student(
                    usn, name, sem.toInt()
                )
            )
        }) {
            Text(text = "Save")
        }
    }
}