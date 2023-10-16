package dev.asifddlks.bhaibhaiclinicApp.mainPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dev.asifddlks.bhaibhaiclinicApp.databinding.FragmentMainPageBinding

class MainPageFragment : Fragment() {

    private val binding get() = _binding!!
    private var _binding: FragmentMainPageBinding? = null
    private val viewModel: MainPageViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMainPageBinding.inflate(inflater, container, false)

        prepareViews()
        initListeners()


        return binding.root
    }

    private fun initListeners() {

    }

    private fun prepareViews() {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}