package com.example.studentapp.data.repository

import com.example.studentapp.domain.models.Expense
import com.example.studentapp.domain.models.Student
import com.example.studentapp.domain.models.Subject
import com.example.studentapp.domain.repository.RemoteDataSource
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.put
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class RemoteDataSourceImpl(private val httpClient: HttpClient) : RemoteDataSource {
    override suspend fun addExpense(expense: Expense):Expense? {
        return httpClient.post("/expense"){
            contentType(ContentType.Application.Json)
            setBody(expense)
        }.body()
    }

    override suspend fun updateExpense(expense: Expense): String {
        return httpClient.put("/expense"){
            contentType(ContentType.Application.Json)
            setBody(expense)
        }.body()
    }

    override suspend fun getExpense(usn: String): Expense? {
        return httpClient.get("/expense/${usn}").body()
    }

    override suspend fun addStudent(student: Student):Student?{
         val httpResponse = httpClient.post("/student"){
            contentType(ContentType.Application.Json)
            setBody(student)
        }
        return httpResponse.body()
    }

    override suspend fun getStudent(usn: String): Student? {
        return httpClient.get("/student/${usn}").body()
    }

    override suspend fun updateStudent(student: Student): String {
        return httpClient.put("/student"){
            contentType(ContentType.Application.Json)
            setBody(student)
        }.body()
    }

    override suspend fun getSubject(usn: String): Subject? {
        return httpClient.get("/subject/${usn}").body()
    }

    override suspend fun updateSubject(subject: Subject): String {
        return httpClient.put("/subject"){
            contentType(ContentType.Application.Json)
            setBody(subject)
        }.body()
    }

    override suspend fun addSubject(subject: Subject): Subject? {
        return httpClient.post("/subject"){
            contentType(ContentType.Application.Json)
            setBody(subject)
        }.body()
    }

    override suspend fun addTest1Mark(subject: Subject): Subject? {
        return httpClient.post("/subject/1"){
            contentType(ContentType.Application.Json)
            setBody(subject)
        }.body()
    }

    override suspend fun addTest2Mark(subject: Subject): Subject? {
        return httpClient.post("/subject/2"){
            contentType(ContentType.Application.Json)
            setBody(subject)
        }.body()
    }

    override suspend fun addTest3Mark(subject: Subject): Subject? {
        return httpClient.post("/subject/3"){
            contentType(ContentType.Application.Json)
            setBody(subject)
        }.body()
    }

    override suspend fun getTest1Mark(usn: String,sbNumber:String): String {
        val marks =  httpClient.get("/subject/1/${usn}").body<Subject>()
        return when(sbNumber){
            "1" -> marks.sb1
            "2" -> marks.sb2
            "3" -> marks.sb3
            "4" -> marks.sb4
            "5" -> marks.sb5
            "6" -> marks.sb6
            "7" -> marks.sb7
            "8" -> marks.sb8
            "9" -> marks.sb9
            "10" -> marks.sb10
            else -> { "" }
        }
    }

    override suspend fun getTest2Mark(usn: String,sbNumber: String): String {
        val marks =  httpClient.get("/subject/2/${usn}").body<Subject>()
        return when(sbNumber){
            "1" -> marks.sb1
            "2" -> marks.sb2
            "3" -> marks.sb3
            "4" -> marks.sb4
            "5" -> marks.sb5
            "6" -> marks.sb6
            "7" -> marks.sb7
            "8" -> marks.sb8
            "9" -> marks.sb9
            "10" -> marks.sb10
            else -> { "" }
        }
    }

    override suspend fun getTest3Mark(usn: String,sbNumber: String): String {
        val marks =  httpClient.get("/subject/3/${usn}").body<Subject>()
        return when(sbNumber){
            "1" -> marks.sb1
            "2" -> marks.sb2
            "3" -> marks.sb3
            "4" -> marks.sb4
            "5" -> marks.sb5
            "6" -> marks.sb6
            "7" -> marks.sb7
            "8" -> marks.sb8
            "9" -> marks.sb9
            "10" -> marks.sb10
            else -> { "" }
        }
    }

    override suspend fun updateTest1Mark(subject: Subject,sbNumber: String): String {
        return httpClient.put("/subject/1/$sbNumber"){
            contentType(ContentType.Application.Json)
            setBody(subject)
        }.body()
    }

    override suspend fun updateTest2Mark(subject: Subject,sbNumber: String): String {
        return httpClient.put("/subject/2/$sbNumber"){
            contentType(ContentType.Application.Json)
            setBody(subject)
        }.body()
    }

    override suspend fun updateTest3Mark(subject: Subject,sbNumber: String): String {
        return httpClient.put("/subject/3/$sbNumber"){
            contentType(ContentType.Application.Json)
            setBody(subject)
        }.body()
    }

    override suspend fun addTotalClasses(subject: Subject): Subject? {
        return httpClient.post("/subject/4"){
            contentType(ContentType.Application.Json)
            setBody(subject)
        }.body()
    }

    override suspend fun addAttendedClasses(subject: Subject): Subject? {
        return httpClient.post("/subject/5"){
            contentType(ContentType.Application.Json)
            setBody(subject)
        }.body()
    }

    override suspend fun getTotalClasses(usn: String,sbNumber: String):String {
        val marks =  httpClient.get("/subject/4/${usn}").body<Subject>()
        return when(sbNumber){
            "1" -> marks.sb1
            "2" -> marks.sb2
            "3" -> marks.sb3
            "4" -> marks.sb4
            "5" -> marks.sb5
            "6" -> marks.sb6
            "7" -> marks.sb7
            "8" -> marks.sb8
            "9" -> marks.sb9
            "10" -> marks.sb10
            else -> { "" }
        }
    }

    override suspend fun getAttendedClasses(usn: String,sbNumber: String): String {
        val marks =  httpClient.get("/subject/5/${usn}").body<Subject>()
        return when(sbNumber){
            "1" -> marks.sb1
            "2" -> marks.sb2
            "3" -> marks.sb3
            "4" -> marks.sb4
            "5" -> marks.sb5
            "6" -> marks.sb6
            "7" -> marks.sb7
            "8" -> marks.sb8
            "9" -> marks.sb9
            "10" -> marks.sb10
            else -> { "" }
        }
    }

    override suspend fun updateAttendedClasses(subject: Subject,sbNumber: String): String {
        return httpClient.put("/subject/4/$sbNumber"){
            contentType(ContentType.Application.Json)
            setBody(subject)
        }.body()
    }

    override suspend fun updateTotalClasses(subject: Subject,sbNumber: String): String {
        return httpClient.put("/subject/5/$sbNumber"){
            contentType(ContentType.Application.Json)
            setBody(subject)
        }.body()
    }


}