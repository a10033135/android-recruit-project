package com.hahow.repository.network

import com.hahow.dataModel.Course


interface CourseNetworkRepository {
    /**
     * 從網路取得資料(暫時以本地端 json.file 代替)
     * */
    suspend fun fetchCourseData(): List<Course>
}