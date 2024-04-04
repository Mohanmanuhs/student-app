package com.example.studentapp.presentation.screens.first

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.studentapp.dataStore.UsnStore
import com.example.studentapp.navigation.Screen
import kotlinx.coroutines.launch

@Composable
fun First(navController: NavHostController, firstViewModel: FirstViewModel = hiltViewModel()) {
    var usn by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var sem by remember { mutableStateOf("") }

    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val dataStore = UsnStore(context)

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = usn,
            onValueChange = { usn=it },
            label = { Text("Enter Usn") },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )
        TextField(
            value = name,
            onValueChange = {name=it},
            label = { Text("Enter name") },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )
        TextField(
            value = sem,
            onValueChange = {sem=it},
            label = { Text("Enter Sem") },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )

        Button(onClick = {
            scope.launch {
                dataStore.saveUsn(usn)
            }
            firstViewModel.addStudent(usn,name,sem)
            navController.navigate(Screen.Second.route)

        }) {
            Text(text = "Submit")
        }

    }
}