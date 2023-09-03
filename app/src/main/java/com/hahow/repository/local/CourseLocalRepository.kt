package com.hahow.repository.local

import com.hahow.dataModel.Course

interface CourseLocalRepository {
    /**
     * 將資料儲存於本地端
     * */
    suspend fun saveCourseData(courseList: List<Course>)

    /**
     * 從本地端取得資料
     * */
    suspend fun fetchCourseData(): List<Course>
}