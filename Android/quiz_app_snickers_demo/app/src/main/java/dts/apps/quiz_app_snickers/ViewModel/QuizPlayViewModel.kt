package dts.apps.quiz_app_snickers.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dts.apps.quiz_app_snickers.REST.Data.questionBody.questionBody
import dts.apps.quiz_app_snickers.REST.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class QuizPlayViewModel : ViewModel(){
    val repo = Repository()
    var mQuestionList: MutableLiveData<Response<questionBody>> = MutableLiveData()

    fun question() {
        viewModelScope.launch {
            mQuestionList.value = repo.question()
        }
    }

    fun questionByQuizId(id : Int) {
        viewModelScope.launch {
            mQuestionList.value = repo.questionByQuizId(id)
        }
    }
}