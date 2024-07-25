package com.example.randomusercybilltek.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.randomusercybilltek.databinding.FragmentUsersBinding
import com.example.randomusercybilltek.model.Results
import com.example.randomusercybilltek.viewmodel.RandomUserViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class UsersFragment : Fragment(){

    private var _binding: FragmentUsersBinding? = null
    private val binding get() = _binding!!

    private lateinit var randomUserViewModel: RandomUserViewModel
    private lateinit var personAdapter: PersonAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUsersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        personAdapter = PersonAdapter()
        randomUserViewModel = ViewModelProvider(this)[RandomUserViewModel::class.java]

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = personAdapter
        }

        randomUserViewModel.personList.observe(viewLifecycleOwner) { persons ->
            personAdapter.submitList(persons)
        }
        binding.swipeRefreshLayout.setOnRefreshListener {

        }
        randomUserViewModel.isLoading.observe(viewLifecycleOwner) {
            // Show or hide loading indicator
        }
        randomUserViewModel.error.observe(viewLifecycleOwner) { error ->
            error?.let {
                // Show error message
            }
        }
        randomUserViewModel.fetchRandomUsers()

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

   /* override fun onPersonClick(person: Results) {
       // val action = UsersFragmentDirections.actionUsersFragmentToSecondFragment(person)
        //findNavController().navigate(action)
    }*/
}