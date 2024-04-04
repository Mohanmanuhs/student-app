package com.example.studentapp.presentation.screens.subject

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.studentapp.presentation.components.ItemView

@Composable
fun Subject(
    navController: NavHostController,
    usn: String,
    subjectViewModel: SubjectViewModel = hiltViewModel()
) {
    subjectViewModel.getSubjects(usn)
    val subjects by subjectViewModel.subjects.collectAsState()
    LazyColumn(
        modifier = Modifier.padding(
            start = 20.dp,
            end = 10.dp,
            top = 10.dp,
            bottom = 10.dp
        )
    ) {
        if (subjects == null) {
            item {
                LoadingState()
            }
            return@LazyColumn
        }

        item {
            if (subjects!!.sb1 != "") {
                ItemView(navController = navController, title = subjects!!.sb1, sbNumber = "1")
            }
        }
        item {
            if (subjects!!.sb2 != "") {
                ItemView(navController = navController, title = subjects!!.sb2, sbNumber = "2")
            }
        }
        item {
            if (subjects!!.sb3 != "") {
                ItemView(navController = navController, title = subjects!!.sb3, sbNumber = "3")
            }
        }
        item {
            if (subjects!!.sb4 != "") {
                ItemView(navController = navController, title = subjects!!.sb4, sbNumber = "4")
            }
        }
        item {
            if (subjects!!.sb5 != "") {
                ItemView(navController = navController, title = subjects!!.sb5, sbNumber = "5")
            }
        }
        item {
            if (subjects!!.sb6 != "") {
                ItemView(navController = navController, title = subjects!!.sb6, sbNumber = "6")
            }
        }
        item {
            if (subjects!!.sb7 != "") {
                ItemView(navController = navController, title = subjects!!.sb7, sbNumber = "7")
            }
        }
        item {
            if (subjects!!.sb8 != "") {
                ItemView(navController = navController, title = subjects!!.sb8, sbNumber = "8")
            }
        }
        item {
            if (subjects!!.sb9 != "") {
                ItemView(navController = navController, title = subjects!!.sb9, sbNumber = "9")
            }
        }
        item {
            if (subjects!!.sb10 != "") {
                ItemView(navController = navController, title = subjects!!.sb10, sbNumber = "10")
            }
        }

    }
}


@Composable
fun LoadingState() {
    CircularProgressIndicator(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 8.dp),
        color = Color.Black
    )
}