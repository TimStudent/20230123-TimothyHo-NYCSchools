package com.example.a20230124_timothyho_nycschools.repository

import com.example.a20230124_timothyho_nycschools.UIState
import com.example.a20230124_timothyho_nycschools.api.NYCAPI
import com.example.a20230124_timothyho_nycschools.model.HighSchool
import com.example.a20230124_timothyho_nycschools.model.SATScore
import com.example.a20230124_timothyho_nycschools.model.SchoolModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


interface NYCSchoolsRepository {
    fun getSchoolModel(): Flow<UIState>
}
class NYCSchoolsRepositoryImpl @Inject constructor(private val nycapi:NYCAPI): NYCSchoolsRepository {
    override fun getSchoolModel(): Flow<UIState> = flow {
        emit(UIState.LOADING)
        try {
            val response = nycapi.highSchools()
            val response2 = nycapi.satScores()
            emit(UIState.SUCCESS(
                iterateSchoolAndSAT(response, response2)
            ))
        }
        catch (e: Exception) {
            emit(UIState.ERROR(e))
        }
    }
}

private fun iterateSchoolAndSAT(highSchools: List<HighSchool>?, satScores: List<SATScore>?) : List<SchoolModel> {
    // null check
    if (highSchools == null) return emptyList()
    if (satScores == null) return emptyList()
    // null check
    val mapOfSchools = mutableMapOf<String, SATScore>()
    for (satScore in satScores) {
        mapOfSchools[satScore.dbn ?: ""] = satScore
    }
    return highSchools.map {
        SchoolModel(school = it, satScores = mapOfSchools[it.dbn])
    }
}