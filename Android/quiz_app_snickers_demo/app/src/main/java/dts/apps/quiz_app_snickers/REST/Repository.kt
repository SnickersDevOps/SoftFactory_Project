package dts.apps.quiz_app_snickers.REST



import dts.apps.quiz_app_snickers.REST.Data.questionBody.questionBody
import dts.apps.quiz_app_snickers.REST.Data.quizByCourse.quizByCourse


import retrofit2.Response

class Repository {

    suspend fun question(): Response<questionBody> {
        return RetrofitInstance.api.question()
    }

    suspend fun questionByQuizId(id : Int) : Response<questionBody> {
        return RetrofitInstance.api.questionByQuizId(id)
    }

    /* --------------------------------------------------------------------- */
    suspend fun quizListChemistry(): Response<quizByCourse> {
        return RetrofitInstance.api.quizListChemistry()
    }

    suspend fun quizListGeography(): Response<quizByCourse> {
        return RetrofitInstance.api.quizListGeography()
    }

    suspend fun quizListMath(): Response<quizByCourse> {
        return RetrofitInstance.api.quizListMath()
    }

    suspend fun quizListMathLiteracy(): Response<quizByCourse> {
        return RetrofitInstance.api.quizListMathLiteracy()
    }

    suspend fun quizListBiology(): Response<quizByCourse> {
        return RetrofitInstance.api.quizListBiology()
    }

    suspend fun quizListHistKaz(): Response<quizByCourse> {
        return RetrofitInstance.api.quizListHistKaz()
    }

    suspend fun quizListReadLiteracy(): Response<quizByCourse> {
        return RetrofitInstance.api.quizListReadLiteracy()
    }

    suspend fun quizListPhysics(): Response<quizByCourse> {
        return RetrofitInstance.api.quizListPhysics()
    }
    /* --------------------------------------------------------------------- */
}