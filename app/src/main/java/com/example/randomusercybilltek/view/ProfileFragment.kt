package com.example.randomusercybilltek.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.randomusercybilltek.databinding.FragmentProfileBinding
import com.example.randomusercybilltek.viewmodel.RandomUserViewModel

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    val value = arguments?.getString("UID")

    private lateinit var randomUserViewModel: RandomUserViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        randomUserViewModel = ViewModelProvider(this)[RandomUserViewModel::class.java]




        randomUserViewModel.person.observe(viewLifecycleOwner) { person ->
            binding.tvFullName.text = buildString {
        append(person.name?.first)
        append(" ")
        append(person.name?.last) }
            binding.tvGender.text = person.gender
            binding.tvNationality.text = person.location?.city
        }
        value?.toInt()?.let { randomUserViewModel.getByUID(it) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}
