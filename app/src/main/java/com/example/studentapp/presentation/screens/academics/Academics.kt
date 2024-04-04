package com.example.studentapp.presentation.screens.academics

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
import com.example.studentapp.domain.models.Subject
import kotlinx.coroutines.delay


@Composable
fun Academics(
    sbNumber: String, usn: String, academicsViewModel: AcademicsViewModel = hiltViewModel()
) {


    LaunchedEffect(key1 = Unit, block = {
        academicsViewModel.getTest1Marks(usn, sbNumber).toString()
        academicsViewModel.getTest2Marks(usn, sbNumber)
        academicsViewModel.getTest3Marks(usn, sbNumber)
        academicsViewModel.getAttendedClasses(usn, sbNumber)
        academicsViewModel.getTotalClasses(usn, sbNumber)
        delay(100)
    })
    val t11 = academicsViewModel.t1.collectAsState(initial = "")
    val t22 = academicsViewModel.t2.collectAsState(initial = "")
    val t33 = academicsViewModel.t3.collectAsState(initial = "")
    val acc = academicsViewModel.ac.collectAsState(initial = "")
    val tcc = academicsViewModel.tc.collectAsState(initial = "")


    var t1 by remember { mutableStateOf(t11.value) }
    var t2 by remember { mutableStateOf(t22.value) }
    var t3 by remember { mutableStateOf(t33.value) }
    var tc by remember { mutableStateOf(tcc.value) }
    var ac by remember { mutableStateOf(acc.value) }


    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(text = "Test 1 : ${t11.value}")
            TextField(
                value = t1,
                onValueChange = { t1 = it },
                label = { Text("update Test 1 Marks") },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )

        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(text = "Test 2 : ${t22.value}")
            TextField(
                value = t2,
                onValueChange = { t2 = it },
                label = { Text("update Test 2 Marks") },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )

        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(text = "Test 3 : ${t33.value}")
            TextField(
                value = t3,
                onValueChange = { t3 = it },
                label = { Text("update Test 3 Marks") },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )

        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(text = "Total Classes : ${tcc.value}")
            TextField(
                value = tc,
                onValueChange = { tc = it },
                label = { Text("update Number of classes taken") },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )

        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(text = "Attended classes : ${acc.value}")
            TextField(
                value = ac,
                onValueChange = { ac = it },
                label = { Text("update Number of classes Attended") },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )
        }

        Button(onClick = {
            academicsViewModel.updateTest1Marks(Subject("1$usn", t1, t1, t1, t1, t1, t1, t1, t1, t1, t1), sbNumber)
            academicsViewModel.updateTest2Marks(Subject("2$usn",t2, t2, t2, t2, t2, t2,t2, t2, t2, t2),sbNumber)
            academicsViewModel.updateTest3Marks(Subject("3$usn", t3, t3, t3, t3, t3, t3, t3, t3, t3,t3),sbNumber)
            academicsViewModel.updateTotalClasses(Subject("4$usn",tc,tc,tc,tc,tc,tc,tc,tc,tc,tc),sbNumber)
            academicsViewModel.updateAttendedClasses(Subject("5$usn",ac,ac,ac,ac,ac,ac,ac,ac,ac,ac),sbNumber)

        }) {
            Text(text = "save")
        }
    }
}