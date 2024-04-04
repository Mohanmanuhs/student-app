package com.example.studentapp.presentation.screens.academics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studentapp.data.repository.Repository
import com.example.studentapp.domain.models.Subject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AcademicsViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    private val _t1 = MutableStateFlow("")
    val t1: StateFlow<String> = _t1
    private val _t2 = MutableStateFlow("")
    val t2: StateFlow<String> = _t2
    private val _t3 = MutableStateFlow("")
    val t3: StateFlow<String> = _t3
    private val _ac = MutableStateFlow("")
    val ac: StateFlow<String> = _ac
    private val _tc = MutableStateFlow("")
    val tc: StateFlow<String> = _tc

    fun updateTest1Marks(subject: Subject, sbNumber: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateTest1Mark(subject, sbNumber)
        }
    }

    fun updateTest2Marks(subject: Subject, sbNumber: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateTest2Mark(subject, sbNumber)
        }
    }

    fun updateTest3Marks(subject: Subject, sbNumber: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateTest3Mark(subject, sbNumber)
        }
    }

    fun updateAttendedClasses(subject: Subject, sbNumber: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateAttendedClasses(subject, sbNumber)
        }
    }

    fun updateTotalClasses(subject: Subject, sbNumber: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateTotalClasses(subject, sbNumber)
        }
    }

    fun getTest1Marks(usn: String, sbNumber: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _t1.value = repository.getTest1Mark(usn, sbNumber)
        }
    }

    fun getTest2Marks(usn: String, sbNumber: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _t2.value = repository.getTest2Mark(usn, sbNumber)
        }
    }

    fun getTest3Marks(usn: String, sbNumber: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _t3.value = repository.getTest3Mark(usn, sbNumber)
        }
    }

    fun getAttendedClasses(usn: String, sbNumber: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _ac.value = repository.getAttendedClasses(usn, sbNumber)
        }
    }

    fun getTotalClasses(usn: String, sbNumber: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _tc.value = repository.getTotalClasses(usn, sbNumber)
        }
    }
}