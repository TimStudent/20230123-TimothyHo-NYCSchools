package com.example.a20230124_timothyho_nycschools

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModelProvider
import com.example.a20230124_timothyho_nycschools.di.App
import com.example.a20230124_timothyho_nycschools.theme.NycCCTheme
import com.example.a20230124_timothyho_nycschools.viewmodel.NYCSchoolsViewModel
import javax.inject.Inject

class MainActivity2 : AppCompatActivity() {
    //ignore mainActivity2
//    @Inject
//    lateinit var viewModelFactory: NycCCModelFactory
//    private val viewModel by lazy {
//        ViewModelProvider(this, viewModelFactory)[NYCSchoolsViewModel::class.java]
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        App.Component.inject2(this)
//
//        setContent {
//            NycCCTheme() {
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = Color.White
//                ) {
//                    //put composable here
//                    SchoolInfo(viewModel)
//                }
//            }
//        }
//    }
//}
//@Composable
//fun SchoolInfo(viewModel:NYCSchoolsViewModel) {
//    Column() {
//        Text(text = viewModel.schoolName)
//        Text(text = viewModel.dbn)
//        Log.d(TAG, viewModel.schoolName)
//        Log.d(TAG, viewModel.dbn)
//        Text(text = viewModel.address)
//        Text(text = viewModel.phoneNumber)
//        Text(text = viewModel.email)
//        Text(text = viewModel.website)
//        Text(text = viewModel.mathSAT)
//        Text(text = viewModel.readSAT)
//        Text(text = viewModel.writeSAT)
//        Text(text = viewModel.testTakers)
//        Text(text = "test")
//    }
}