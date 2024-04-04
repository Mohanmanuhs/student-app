package com.example.studentapp.presentation.screens.second

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studentapp.data.repository.Repository
import com.example.studentapp.domain.models.Expense
import com.example.studentapp.domain.models.Subject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SecondViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    fun addSubject(
        usn: String,
        sb1: String,
        sb2: String,
        sb3: String,
        sb4: String,
        sb5: String,
        sb6: String,
        sb7: String,
        sb8: String,
        sb9: String,
        sb10: String
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addSubject(
                Subject(
                    usn, sb1, sb2, sb3, sb4, sb5, sb6, sb7, sb8, sb9, sb10
                )
            )
            addTest1Marks(usn)
            addTest2Marks(usn)
            addTest3Marks(usn)
            addAttendedClasses(usn)
            addTotalClasses(usn)
            addExpense(usn)
        }
    }

    private fun addExpense(usn: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addExpense(
                Expense(
                    usn, "", "", "", ""
                )
            )
        }
    }

    private fun addTest1Marks(usn: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addTest1Mark(
                Subject(
                    "1${usn}",
                    sb1 = "",
                    sb2 = "",
                    sb3 = "",
                    sb4 = "",
                    sb5 = "",
                    sb6 = "",
                    sb7 = "",
                    sb8 = "",
                    sb9 = "",
                    sb10 = ""
                )
            )
        }
    }

    private fun addTest2Marks(usn: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addTest2Mark(
                Subject(
                    "2${usn}",
                    sb1 = "",
                    sb2 = "",
                    sb3 = "",
                    sb4 = "",
                    sb5 = "",
                    sb6 = "",
                    sb7 = "",
                    sb8 = "",
                    sb9 = "",
                    sb10 = ""
                )
            )
        }
    }

    private fun addTest3Marks(usn: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addTest3Mark(
                Subject(
                    "3${usn}",
                    sb1 = "",
                    sb2 = "",
                    sb3 = "",
                    sb4 = "",
                    sb5 = "",
                    sb6 = "",
                    sb7 = "",
                    sb8 = "",
                    sb9 = "",
                    sb10 = ""
                )
            )
        }
    }

    private fun addTotalClasses(usn: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addTotalClasses(
                Subject(
                    "4${usn}",
                    sb1 = "",
                    sb2 = "",
                    sb3 = "",
                    sb4 = "",
                    sb5 = "",
                    sb6 = "",
                    sb7 = "",
                    sb8 = "",
                    sb9 = "",
                    sb10 = ""
                )
            )
        }
    }

    private fun addAttendedClasses(usn: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addAttendedClasses(
                Subject(
                    "5${usn}",
                    sb1 = "",
                    sb2 = "",
                    sb3 = "",
                    sb4 = "",
                    sb5 = "",
                    sb6 = "",
                    sb7 = "",
                    sb8 = "",
                    sb9 = "",
                    sb10 = ""
                )
            )
        }
    }
}