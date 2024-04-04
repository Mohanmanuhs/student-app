package com.example.studentapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.studentapp.dataStore.UsnStore
import com.example.studentapp.presentation.screens.Home
import com.example.studentapp.presentation.screens.Splash
import com.example.studentapp.presentation.screens.academics.Academics
import com.example.studentapp.presentation.screens.details.Details
import com.example.studentapp.presentation.screens.expense.Expense
import com.example.studentapp.presentation.screens.first.First
import com.example.studentapp.presentation.screens.second.Second
import com.example.studentapp.presentation.screens.subject.Subject


@Composable
fun SetUpNavGraph(navController: NavHostController) {
    val context = LocalContext.current
    val dataStore = UsnStore(context)
    val savedUsn = dataStore.getUsn.collectAsState(initial = "")
    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) {
            Splash(navController = navController, usn = savedUsn.value)
        }
        composable(Screen.First.route) {
            First(navController = navController)
        }
        composable(Screen.Second.route) {
            Second(navController = navController)
        }
        composable(Screen.Academics.route + "/{sbName}") { backStackEntry ->
            val sbName = backStackEntry.arguments?.getString("sbName") ?: ""
            Academics(sbName, savedUsn.value)
        }
        composable(Screen.Home.route) {
            Home(navController = navController)
        }
        composable(Screen.Details.route) {
            Details(usn = savedUsn.value)
        }
        composable(Screen.Expense.route) {
            Expense(savedUsn.value)
        }
        composable(Screen.Subjects.route) {
            Subject(navController, savedUsn.value)
        }
    }
}