package dev.asifddlks.bhaibhaiclinicApp.createOrUpdatePage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.gson.Gson
import dev.asifddlks.bhaibhaiclinicApp.databinding.FragmentCreateOrUpdatePageBinding
import dev.asifddlks.bhaibhaiclinicApp.model.UserModel
import dev.asifddlks.bhaibhaiclinicApp.utils.extensions.fromJson

class CreateOrUpdatePageFragment : Fragment() {

    private val binding get() = _binding!!
    private var _binding: FragmentCreateOrUpdatePageBinding? = null
    private val viewModel: CreateOrUpdatePageViewModel by viewModels()

    private var userItem: UserModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { bundle ->
            val jsonData = bundle.getString("userItem")
            jsonData?.let { userItem = Gson().fromJson(jsonData) }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCreateOrUpdatePageBinding.inflate(inflater, container, false)

        prepareViews()
        initListeners()


        return binding.root
    }

    private fun initListeners() {

    }

    private fun prepareViews() {
        userItem?.let {
            binding.text.text = it.name
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}