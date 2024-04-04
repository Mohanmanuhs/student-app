package com.example.studentapp.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.example.studentapp.dataStore.UsnStore
import com.example.studentapp.navigation.Screen
import kotlinx.coroutines.delay

@Composable
fun Splash(navController: NavHostController,usn:String) {
    val context = LocalContext.current
    val dataStore = UsnStore(context)
    val savedUsn = dataStore.getUsn.collectAsState(initial = "")
    LaunchedEffect(key1=Unit,block={
        delay(1000)
        if (savedUsn.value != ""){
            navController.navigate(Screen.Home.route)
        }else{
            navController.navigate(Screen.First.route)
        }
    })

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Student App")
    }
}