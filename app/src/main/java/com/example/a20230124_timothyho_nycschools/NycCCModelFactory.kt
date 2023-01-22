package com.example.a20230124_timothyho_nycschools

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.a20230124_timothyho_nycschools.repository.NYCSchoolsRepository
import com.example.a20230124_timothyho_nycschools.viewmodel.NYCSchoolsViewModel

@Suppress("UNCHECKED_CAST")
class NycCCModelFactory(private val repository: NYCSchoolsRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NYCSchoolsViewModel(repository) as T
    }
}