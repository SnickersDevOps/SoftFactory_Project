package dts.apps.quiz_app_snickers.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dts.apps.quiz_app_snickers.REST.Data.quizByCourse.quizByCourse
import dts.apps.quiz_app_snickers.REST.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class ChosenCourseViewModel : ViewModel() {
    var repo = Repository()
    var mQuizList: MutableLiveData<Response<quizByCourse>> = MutableLiveData()

    fun quizListChemistry() {
        viewModelScope.launch {
            mQuizList.value = repo.quizListChemistry()
        }
    }

    fun quizListGeography() {
        viewModelScope.launch {
            mQuizList.value = repo.quizListGeography()
        }
    }

    fun quizListMath() {
        viewModelScope.launch {
            mQuizList.value = repo.quizListMath()
        }
    }

    fun quizListMathLiteracy() {
        viewModelScope.launch {
            mQuizList.value = repo.quizListMathLiteracy()
        }
    }

    fun quizListBiology() {
        viewModelScope.launch {
            mQuizList.value = repo.quizListBiology()
        }
    }

    fun quizListHistKaz() {
        viewModelScope.launch {
            mQuizList.value = repo.quizListHistKaz()
        }
    }

    fun quizListReadLiteracy() {
        viewModelScope.launch {
            mQuizList.value = repo.quizListReadLiteracy()
        }
    }

    fun quizListPhysics() {
        viewModelScope.launch {
            mQuizList.value = repo.quizListPhysics()
        }
    }
}