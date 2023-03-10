package com.example.a20230124_timothyho_nycschools.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.a20230124_timothyho_nycschools.UIStates
import com.example.a20230124_timothyho_nycschools.fragment.SchoolInfo
import com.example.a20230124_timothyho_nycschools.viewmodel.NYCSchoolsViewModel

@Composable
fun Navigation(navController: NavHostController, viewModel: NYCSchoolsViewModel) {
    NavHost(navController = navController, startDestination = "first") {
        composable("first") {
            viewModel.schools.observeAsState().value?.let { UIStates(uiState = it, viewModel) }
        }
        composable("second") {
            SchoolInfo(viewModel = viewModel)
        }
    }
}

@Composable
fun BottomNavigationBar(
    items: List<BottomNavBarItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavBarItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.Blue,
        elevation = 5.dp
    ) {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(item) },
                selectedContentColor = Color.Green,
                unselectedContentColor = Color.Gray,
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        if (item.badgeCount > 0)
                            BadgedBox(
                                badge = {
                                    Badge { Text(item.badgeCount.toString()) }
                                }) {
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.name
                                )
                            }
                        else {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.name
                            )
                        }
                    }
                }
            )
        }
    }
}