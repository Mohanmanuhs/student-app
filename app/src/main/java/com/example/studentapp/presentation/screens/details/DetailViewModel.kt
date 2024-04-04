package com.example.studentapp.presentation.screens.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studentapp.data.repository.Repository
import com.example.studentapp.domain.models.Student
import com.example.studentapp.domain.models.Subject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: Repository):ViewModel() {
    private val _name = MutableStateFlow("")
    val name: StateFlow<String> = _name
    private val _sem = MutableStateFlow("")
    val sem: StateFlow<String> = _sem

    private val _subjects = MutableStateFlow<Subject?>(null)
    val subjects: StateFlow<Subject?> = _subjects

    fun getStudent(usn:String){
        viewModelScope.launch(Dispatchers.IO) {
            val st = repository.getStudent(usn)
            if (st != null) {
                _name.value=st.name
                _sem.value=st.sem.toString()
            }
        }
    }
    fun upDateStudent(student: Student){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateStudent(student)
        }
    }
    fun upDateSubject(subject: Subject){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateSubject(subject)
        }
    }
    fun getSubjects(usn:String){
        viewModelScope.launch(Dispatchers.IO){
            val fetchedSubjects = repository.getSubject(usn)
            _subjects.value=fetchedSubjects
        }
    }
}