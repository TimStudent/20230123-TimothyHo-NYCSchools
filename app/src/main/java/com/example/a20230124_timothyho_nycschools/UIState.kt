package com.example.a20230124_timothyho_nycschools

import com.example.a20230124_timothyho_nycschools.model.SchoolModel


sealed class UIState {
    object LOADING: UIState()
    data class SUCCESS(
        val success: List<SchoolModel>? = null
    ) : UIState()
    data class ERROR(val error:Exception) : UIState()
}