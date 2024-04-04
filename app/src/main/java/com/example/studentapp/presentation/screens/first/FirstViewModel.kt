package com.example.studentapp.presentation.screens.first

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studentapp.data.repository.Repository
import com.example.studentapp.domain.models.Student
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor(private val repository: Repository):ViewModel() {
    fun addStudent(usn:String,name:String,sem:String){
        viewModelScope.launch(Dispatchers.IO){
            repository.addStudent(Student(
                usn,name,sem.toInt()
            ))
        }
    }



}