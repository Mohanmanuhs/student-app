package com.example.studentapp.presentation.screens.expense

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studentapp.data.repository.Repository
import com.example.studentapp.domain.models.Expense
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExpenseViewModel @Inject constructor(private val repository: Repository):ViewModel() {
    private val _tuition = MutableStateFlow("")
    val tuition: StateFlow<String> = _tuition
    private val _txtBook = MutableStateFlow("")
    val txtBook: StateFlow<String> = _txtBook
    private val _stationery = MutableStateFlow("")
    val stationery: StateFlow<String> = _stationery
    private val _other = MutableStateFlow("")
    val other: StateFlow<String> = _other

    fun getExpense(usn:String){
        viewModelScope.launch(Dispatchers.IO) {
            val ex = repository.getExpense(usn)
            if (ex != null) {
                _tuition.value=ex.tuition
                _txtBook.value=ex.txtBook
                _stationery.value=ex.stationery
                _other.value=ex.other
            }
        }
    }
    fun updateExpense(expense: Expense){
        viewModelScope.launch(Dispatchers.IO) {
           repository.updateExpense(expense)
        }
    }


}