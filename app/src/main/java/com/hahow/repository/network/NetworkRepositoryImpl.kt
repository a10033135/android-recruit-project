package com.hahow.repository.network

import android.content.Context
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import com.hahow.dataModel.Course

class NetworkRepositoryImpl(private val context: Context) : CourseNetworkRepository {

    private val testFile = "homePageTestFile.json"
    private val gson by lazy { Gson() }
    override suspend fun fetchCourseData(): List<Course> {
        val jsonString = context.assets.open(testFile).bufferedReader().use { it.readText() }
        val jsonObject = gson.fromJson(jsonString, JsonObject::class.java)
        val data = jsonObject.getAsJsonArray("data")
        return gson.fromJson(data, Array<Course>::class.java).toList()
    }
}