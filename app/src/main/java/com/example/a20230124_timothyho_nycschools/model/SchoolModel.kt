package com.example.a20230124_timothyho_nycschools.model

data class SchoolModel(
    val school: HighSchool?= null,
    val satScores: SATScore?= null
){
    val dbn: String? = school?.dbn
    val schoolName: String? = school?.schoolName
    val addressString: String get() = "${school?.primaryAddressLine1}, ${school?.city}, ${school?.stateCode}, ${school?.zip}"
    val phoneNumber: String? = school?.phoneNumber
    val email: String? = school?.schoolEmail
    val website: String? = school?.website
    val mathSATScore: String? = satScores?.satMathAvgScore
    val readSATScore: String? = satScores?.satCriticalReadingAvgScore
    val writeSATScore: String? = satScores?.satWritingAvgScore
    val testTakers: String? = satScores?.numOfSatTestTakers
}
