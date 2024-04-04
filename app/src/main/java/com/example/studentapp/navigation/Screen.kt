package com.example.studentapp.navigation

sealed class Screen(val route:String){
    data object First: Screen("first_screen")
    data object Splash: Screen("splash_screen")
    data object Second: Screen("second_screen")
    data object Academics: Screen("academic_screen")
    data object Expense: Screen("expense_screen")
    data object Details: Screen("details_screen")
    data object Home: Screen("home")
    data object Subjects : Screen("subjects_screen")

}
