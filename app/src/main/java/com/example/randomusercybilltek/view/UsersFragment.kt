package com.example.randomusercybilltek.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.randomusercybilltek.R
import com.example.randomusercybilltek.databinding.FragmentUsersBinding
import com.example.randomusercybilltek.model.Results
import com.example.randomusercybilltek.viewmodel.RandomUserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UsersFragment : Fragment(), OnPersonClickListener {

    private var _binding: FragmentUsersBinding? = null
    private val binding get() = _binding!!

    private lateinit var randomUserViewModel: RandomUserViewModel
    private lateinit var personAdapter: PersonAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentUsersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        personAdapter = PersonAdapter(this)
        randomUserViewModel = ViewModelProvider(this)[RandomUserViewModel::class.java]

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = personAdapter
        }

        randomUserViewModel.personList.observe(viewLifecycleOwner) { persons ->
            personAdapter.submitList(persons)
        }

      binding.swipeRefreshLayout.setOnRefreshListener {
         randomUserViewModel.fetchRandomUsers()
      }
        randomUserViewModel.isLoading.observe(viewLifecycleOwner) {
            Log.d("Refresh", it.toString())
            binding.swipeRefreshLayout.isRefreshing = it
        }
        randomUserViewModel.error.observe(viewLifecycleOwner) { error ->
            error?.let {
                // Show error message
            }
        }
        randomUserViewModel.fetchRandomUsers()
        //randomUserViewModel.getAllPersons()

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

     override fun onPersonClick(person: Results) {
         Log.d("UsersFragment", "Person clicked: $person")

         val UID = person.UID
         findNavController().navigate(UsersFragmentDirections.actionUsersFragmentToProfileFragment(UID)
         )
     }
}