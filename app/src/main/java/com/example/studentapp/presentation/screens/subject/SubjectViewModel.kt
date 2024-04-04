package com.example.studentapp.presentation.screens.subject

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
class SubjectViewModel @Inject constructor(private val repository: Repository):ViewModel() {
    private val _subjects = MutableStateFlow<Subject?>(null)
    val subjects: StateFlow<Subject?> = _subjects

    fun getSubjects(usn:String){
        viewModelScope.launch(Dispatchers.IO){
            val fetchedSubjects = repository.getSubject(usn)
            _subjects.value=fetchedSubjects
        }
    }

}