package com.example.studentapp.presentation.screens.second

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.studentapp.dataStore.UsnStore
import com.example.studentapp.navigation.Screen

@Composable
fun Second(navController: NavHostController,secondViewModel: SecondViewModel= hiltViewModel()) {
    var sb1 by remember { mutableStateOf("") }
    var sb2 by remember { mutableStateOf("") }
    var sb3 by remember { mutableStateOf("") }
    var sb4 by remember { mutableStateOf("") }
    var sb5 by remember { mutableStateOf("") }
    var sb6 by remember { mutableStateOf("") }
    var sb7 by remember { mutableStateOf("") }
    var sb8 by remember { mutableStateOf("") }
    var sb9 by remember { mutableStateOf("") }
    var sb10 by remember { mutableStateOf("") }

    val context = LocalContext.current
    val dataStore = UsnStore(context)
    val savedUsn = dataStore.getUsn.collectAsState(initial = "")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = sb1,
            onValueChange = { sb1 = it },
            label = { Text("Enter Subject 1") },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )

        TextField(
            value = sb2,
            onValueChange = { sb2 = it },
            label = { Text("Enter Subject 2") },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )

        TextField(
            value = sb3,
            onValueChange = { sb3 = it },
            label = { Text("Enter Subject 3") },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )

        TextField(
            value = sb4,
            onValueChange = { sb4 = it },
            label = { Text("Enter Subject 4") },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )

        TextField(
            value = sb5,
            onValueChange = { sb5 = it },
            label = { Text("Enter Subject 5") },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )

        TextField(
            value = sb6,
            onValueChange = { sb6 = it },
            label = { Text("Enter Subject 6") },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )

        TextField(
            value = sb7,
            onValueChange = { sb7 = it },
            label = { Text("Enter Subject 7") },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )

        TextField(
            value = sb8,
            onValueChange = { sb8 = it },
            label = { Text("Enter Subject 8") },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )
        TextField(
            value = sb9,
            onValueChange = { sb9 = it },
            label = { Text("Enter Subject 9") },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )
        TextField(
            value = sb10,
            onValueChange = { sb10 = it },
            label = { Text("Enter Subject 10") },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )
        Button(onClick = {
            secondViewModel.addSubject(savedUsn.value, sb1, sb2, sb3, sb4, sb5, sb6, sb7, sb8, sb9, sb10)
            navController.navigate(Screen.Home.route)
        }) {
            Text(text = "Submit")
        }

    }
}