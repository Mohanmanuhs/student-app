package com.example.studentapp.data.repository

import com.example.studentapp.domain.models.Expense
import com.example.studentapp.domain.models.Student
import com.example.studentapp.domain.models.Subject
import com.example.studentapp.domain.repository.RemoteDataSource
import javax.inject.Inject

class Repository @Inject constructor(private val remote: RemoteDataSource) {
    suspend fun addExpense(expense: Expense): Expense? {
        return remote.addExpense(expense)
    }

    suspend fun updateExpense(expense: Expense): String {
        return remote.updateExpense(expense)
    }

    suspend fun getExpense(usn: String): Expense? {
        return remote.getExpense(usn)
    }

    suspend fun addStudent(student: Student):Student? {
        return remote.addStudent(student)
    }

    suspend fun getStudent(usn: String): Student? {
        return remote.getStudent(usn)
    }

    suspend fun updateStudent(student: Student): String {
        return remote.updateStudent(student)
    }

    suspend fun getSubject(usn: String): Subject? {
        return remote.getSubject(usn)
    }

    suspend fun updateSubject(subject: Subject): String {
        return remote.updateSubject(subject)
    }

    suspend fun addSubject(subject: Subject): Subject? {
        return remote.addSubject(subject)
    }

    suspend fun addTest1Mark(subject: Subject): Subject? {
        return remote.addTest1Mark(subject)
    }

    suspend fun addTest2Mark(subject: Subject): Subject? {
        return remote.addTest2Mark(subject)
    }

    suspend fun addTest3Mark(subject: Subject): Subject? {
        return remote.addTest3Mark(subject)
    }

    suspend fun getTest1Mark(usn: String,sbNumber:String): String {
        return remote.getTest1Mark(usn,sbNumber)
    }

    suspend fun getTest2Mark(usn: String,sbNumber: String): String {
        return remote.getTest2Mark(usn, sbNumber)
    }

    suspend fun getTest3Mark(usn: String,sbNumber: String):String {
        return remote.getTest3Mark(usn,sbNumber)
    }

    suspend fun updateTest1Mark(subject: Subject,sbNumber: String): String {
        return remote.updateTest1Mark(subject,sbNumber)
    }

    suspend fun updateTest2Mark(subject: Subject,sbNumber: String): String {
        return remote.updateTest2Mark(subject,sbNumber)
    }

    suspend fun updateTest3Mark(subject: Subject,sbNumber: String): String {
        return remote.updateTest3Mark(subject,sbNumber)
    }

    suspend fun addTotalClasses(subject: Subject): Subject? {
        return remote.addTotalClasses(subject)
    }

    suspend fun addAttendedClasses(subject: Subject): Subject? {
        return remote.addAttendedClasses(subject)
    }

    suspend fun getTotalClasses(usn: String,sbNumber: String): String {
        return remote.getTotalClasses(usn,sbNumber)
    }

    suspend fun getAttendedClasses(usn: String,sbNumber: String): String {
        return remote.getAttendedClasses(usn,sbNumber)
    }

    suspend fun updateAttendedClasses(subject: Subject,sbNumber: String): String {
        return remote.updateAttendedClasses(subject,sbNumber)
    }

    suspend fun updateTotalClasses(subject: Subject,sbNumber: String): String {
        return remote.updateTotalClasses(subject,sbNumber)
    }

}