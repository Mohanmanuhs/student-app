package com.example.studentapp.domain.repository

import com.example.studentapp.domain.models.Expense
import com.example.studentapp.domain.models.Student
import com.example.studentapp.domain.models.Subject

interface RemoteDataSource {
    suspend fun addExpense(expense: Expense):Expense?
    suspend fun updateExpense(expense:Expense):String
    suspend fun getExpense(usn:String):Expense?

    suspend fun addStudent(student: Student):Student?
    suspend fun getStudent(usn:String):Student?
    suspend fun updateStudent(student: Student):String

    suspend fun getSubject(usn:String): Subject?
    suspend fun updateSubject(subject: Subject):String
    suspend fun addSubject(subject: Subject):Subject?
    suspend fun addTest1Mark(subject: Subject):Subject?
    suspend fun addTest2Mark(subject: Subject):Subject?
    suspend fun addTest3Mark(subject: Subject):Subject?
    suspend fun getTest1Mark(usn:String,sbNumber:String):String
    suspend fun getTest2Mark(usn:String,sbNumber: String):String
    suspend fun getTest3Mark(usn:String,sbNumber: String):String
    suspend fun updateTest1Mark(subject: Subject,sbNumber: String):String
    suspend fun updateTest2Mark(subject: Subject,sbNumber: String):String
    suspend fun updateTest3Mark(subject: Subject,sbNumber: String):String
    suspend fun addTotalClasses(subject: Subject):Subject?
    suspend fun addAttendedClasses(subject: Subject):Subject?
    suspend fun getTotalClasses(usn:String,sbNumber: String):String
    suspend fun getAttendedClasses(usn:String,sbNumber: String):String
    suspend fun updateAttendedClasses(subject: Subject,sbNumber: String):String
    suspend fun updateTotalClasses(subject: Subject,sbNumber: String):String

}