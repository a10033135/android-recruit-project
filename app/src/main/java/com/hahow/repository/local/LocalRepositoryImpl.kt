package com.hahow.repository.local

import android.content.Context
import androidx.datastore.preferences.core.edit
import com.google.gson.Gson
import com.hahow.repository.dataStore.KEY_JSON_COURSE_LIST
import com.hahow.repository.dataStore.localCacheDataStore
import com.hahow.dataModel.Course
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map


class LocalRepositoryImpl(private val context: Context) : CourseLocalRepository {

    private val gson by lazy { Gson() }

    override suspend fun saveCourseData(courseList: List<Course>) {
        val courseJson = gson.toJson(courseList)
        context.localCacheDataStore.edit { preferences ->
            preferences[KEY_JSON_COURSE_LIST] = courseJson
        }
    }

    override suspend fun fetchCourseData(): List<Course> {
        val courseJson =
            context.localCacheDataStore.data.map { preferences -> preferences[KEY_JSON_COURSE_LIST] }
                .first()
        return if (courseJson.isNullOrEmpty()) listOf()
        else gson.fromJson(courseJson, Array<Course>::class.java).toList()
    }
}
