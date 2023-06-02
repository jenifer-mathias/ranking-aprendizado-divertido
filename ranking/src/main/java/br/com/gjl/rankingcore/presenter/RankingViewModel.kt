package br.com.gjl.rankingcore.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.gjl.rankingcore.domain.model.Student
import br.com.gjl.rankingcore.domain.usecase.GetStudentResult
import br.com.gjl.rankingcore.domain.usecase.GetStudentUseCase
import kotlinx.coroutines.launch

class RankingViewModel(private val getStudentUseCase: GetStudentUseCase) : ViewModel() {

    private val _students = MutableLiveData<List<Student>>()
    val students: LiveData<List<Student>> get() = _students

    private val _errorMessage = MutableLiveData<String>()

    fun getStudents() {
        viewModelScope.launch {
            try {
                when (val result = getStudentUseCase()) {
                    is GetStudentResult.Success -> _students.value = result.students
                    is GetStudentResult.Error -> _errorMessage.value =
                        "Error fetching students: ${result.exception.message}"
                }
            } catch (e: Exception) {
                _errorMessage.value = "Error fetching students: ${e.message}"
            }
        }
    }
}

