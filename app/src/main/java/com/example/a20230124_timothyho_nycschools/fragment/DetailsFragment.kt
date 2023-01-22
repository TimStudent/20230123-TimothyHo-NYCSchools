package com.example.a20230124_timothyho_nycschools.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.a20230124_timothyho_nycschools.NycCCModelFactory
import com.example.a20230124_timothyho_nycschools.databinding.FragmentDetailsBinding
import com.example.a20230124_timothyho_nycschools.theme.NycCCTheme
import com.example.a20230124_timothyho_nycschools.viewmodel.NYCSchoolsViewModel
import javax.inject.Inject

class DetailsFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: NycCCModelFactory
    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[NYCSchoolsViewModel::class.java]
    }
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.composeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                NycCCTheme() {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = Color.White
                    ) {
                        SchoolInfo(viewModel = viewModel)
                    }
                }
            }
        }
        return view
    }
}

@Composable
fun SchoolInfo(viewModel: NYCSchoolsViewModel) {
    Column() {
        Text(text = "School: " +viewModel.schoolName)
        Text(text = "DBN: " +viewModel.dbn)
        Text(text = "Address: " +viewModel.address)
        Text(text = "Phone Number: " +viewModel.phoneNumber)
        Text(text = "Email: " + viewModel.email)
        Text(text = "Website: " +viewModel.website)
        Text(text = "Math SAT: "    + viewModel.mathSAT)
        Text(text = "Reading SAT: " + viewModel.readSAT)
        Text(text = "Writing SAT: " + viewModel.writeSAT)
        Text(text = "Test Takers: " + viewModel.testTakers)
    }
}
