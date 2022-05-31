package dts.apps.quiz_app_snickers.REST.Data.quizByCourse

import retrofit2.http.Path
import retrofit2.http.Query

data class quizByCourseItem(
    @Query("id")
    val id: Int,
    val name: String
)
