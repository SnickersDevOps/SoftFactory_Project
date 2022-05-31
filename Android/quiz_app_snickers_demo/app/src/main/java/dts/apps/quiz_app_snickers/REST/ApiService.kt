package dts.apps.quiz_app_snickers.REST



import dts.apps.quiz_app_snickers.REST.Data.questionBody.questionBody
import dts.apps.quiz_app_snickers.REST.Data.quizByCourse.quizByCourse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {

    @GET("/quiz/question")
    suspend fun question(): Response<questionBody>

    @GET("/quiz/question/{id}")
    suspend fun questionByQuizId(@Path("id")id : Int) : Response<questionBody>
    /* ---------------------------------------------------------------- */
    @GET("/quiz/quizlist/chemistry")
    suspend fun quizListChemistry(): Response<quizByCourse>

    @GET("/quiz/quizlist/geography")
    suspend fun quizListGeography(): Response<quizByCourse>

    @GET("/quiz/quizlist/math")
    suspend fun quizListMath(): Response<quizByCourse>

    @GET("/quiz/quizlist/mathliteracy")
    suspend fun quizListMathLiteracy(): Response<quizByCourse>

    @GET("/quiz/quizlist/biology")
    suspend fun quizListBiology(): Response<quizByCourse>

    @GET("/quiz/quizlist/histkaz")
    suspend fun quizListHistKaz(): Response<quizByCourse>

    @GET("/quiz/quizlist/readliteracy")
    suspend fun quizListReadLiteracy(): Response<quizByCourse>

    @GET("/quiz/quizlist/physics")
    suspend fun quizListPhysics(): Response<quizByCourse>
    /* ---------------------------------------------------------------- */
}