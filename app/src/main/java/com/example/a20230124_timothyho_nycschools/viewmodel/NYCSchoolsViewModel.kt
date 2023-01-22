package com.example.a20230124_timothyho_nycschools.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a20230124_timothyho_nycschools.UIState
import com.example.a20230124_timothyho_nycschools.repository.NYCSchoolsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.migration.DisableInstallInCheck
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@DisableInstallInCheck
@HiltViewModel
class NYCSchoolsViewModel @Inject constructor(
    private val NYCRepository: NYCSchoolsRepository,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
): ViewModel() {

    init {
        getSchoolsData()
    }

    private val _schools: MutableLiveData<UIState> = MutableLiveData(UIState.LOADING)
    val schools: LiveData<UIState> get() = _schools
    // values
    var schoolName = ""
    var dbn = ""
    var address = ""
    var phoneNumber = ""
    var email = ""
    var website = ""
    var mathSAT = ""
    var readSAT = ""
    var writeSAT = ""
    var testTakers = ""

    private fun getSchoolsData() {
        viewModelScope.launch(ioDispatcher) {
            NYCRepository.getSchoolModel().collect() {
                withContext(Dispatchers.IO) {
                    _schools.postValue(it)
                }
            }
        }
    }
}