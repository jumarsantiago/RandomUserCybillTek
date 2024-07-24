package com.example.randomusercybilltek.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.randomusercybilltek.data.NetworkResponse
import com.example.randomusercybilltek.databinding.FragmentUsersBinding
import com.example.randomusercybilltek.view.PersonAdapter
import com.example.randomusercybilltek.viewmodel.RandomUserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class UsersFragment : Fragment() {

    private var _binding: FragmentUsersBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: RandomUserViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUsersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = PersonAdapter()

        viewModel = ViewModelProvider(this)[RandomUserViewModel::class.java]
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter


        viewModel.fetchRandomUsers(1)
        viewModel.personList.observe(viewLifecycleOwner) { persons ->
                adapter.submitList(persons)
        }
        binding.swipeRefreshLayout.setOnRefreshListener {
            viewModel.fetchRandomUsers(1)
        }
        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            // Show or hide loading indicator
        }
        viewModel.error.observe(viewLifecycleOwner) { error ->
            error?.let {
                // Show error message
            }
        }

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}