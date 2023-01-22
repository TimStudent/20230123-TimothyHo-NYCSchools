package com.example.a20230124_timothyho_nycschools

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.example.a20230124_timothyho_nycschools.di.App
import com.example.a20230124_timothyho_nycschools.fragment.SchoolInfo
import com.example.a20230124_timothyho_nycschools.model.SchoolModel
import com.example.a20230124_timothyho_nycschools.navigation.BottomNavBarItem
import com.example.a20230124_timothyho_nycschools.navigation.BottomNavigationBar
import com.example.a20230124_timothyho_nycschools.navigation.Navigation
import com.example.a20230124_timothyho_nycschools.theme.NycCCTheme
import com.example.a20230124_timothyho_nycschools.viewmodel.NYCSchoolsViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: NycCCModelFactory
    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[NYCSchoolsViewModel::class.java]
    }

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.Component.inject(this)
        setContent {
            NycCCTheme() {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    supportActionBar?.hide()
                    val navController = rememberNavController()
                    Scaffold(
                        bottomBar = {
                            BottomNavigationBar(
                                items = listOf(
                                    BottomNavBarItem(
                                        name = "first",
                                        route = "first",
                                        icon = Icons.Default.Home
                                    ),
//                                    BottomNavBarItem(
//                                        name = "second",
//                                        route = "second",
//                                        icon = Icons.Default.Handshake
//                                    )
                                ),
                                navController = navController,
                                onItemClick = {
                                    navController.navigate(it.route)
                                }
                            )
                        }
                    ) {
                        Navigation(navController = navController, viewModel = viewModel)
                    }
                }
            }
        }
    }
}

@Composable
fun UIStates(uiState: UIState, viewModel: NYCSchoolsViewModel) {
    when (uiState) {
        is UIState.LOADING -> {
            CircularProgressIndicator(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                color = Color.Blue,
            )
        }
        is UIState.SUCCESS -> {
            Column() {
                uiState.success?.let { ScrollList(ListOfSchools = it, viewModel) }
            }
        }
        is UIState.ERROR -> {
            uiState.error
        }
    }
}

@Composable
fun ScrollList(ListOfSchools: List<SchoolModel>, viewModel: NYCSchoolsViewModel) {
    LazyColumn(){
        val newList = mutableListOf<SchoolModel>()
        for (schools in ListOfSchools) {
            newList.add(schools)
        }
        itemsIndexed(items = newList) { position, school ->
            Item(School = school, viewModel)
        }
    }
}
@Composable
fun Item(School: SchoolModel, viewModel: NYCSchoolsViewModel) {
    var state by remember { mutableStateOf(false)}
    Column(modifier = Modifier.clickable {
        viewModel.schoolName = School.schoolName.toString()
        viewModel.dbn = School.dbn.toString()
        viewModel.address = School.addressString
        viewModel.phoneNumber = School.phoneNumber.toString()
        viewModel.email = School.email.toString()
        viewModel.website = School.website.toString()
        viewModel.mathSAT = School.mathSATScore.toString()
        viewModel.readSAT = School.readSATScore.toString()
        viewModel.writeSAT = School.writeSATScore.toString()
        viewModel.testTakers = School.testTakers.toString()
        state = !state
    }) {
        Text(text = (School.schoolName + " " + School.dbn), color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Text(text = (School.addressString), color = Color.Black)
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(5.dp))
    }
    if (state) {
        SchoolInfo(viewModel = viewModel)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){

}