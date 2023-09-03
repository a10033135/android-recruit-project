package com.hahow.repository

import com.hahow.dataModel.Course

interface CourseRepository {

    /**
     * 取得課程資料
     * */
    suspend fun fetchCourseData(): List<Course>
}