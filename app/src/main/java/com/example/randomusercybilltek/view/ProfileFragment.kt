package com.example.randomusercybilltek.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.randomusercybilltek.databinding.FragmentProfileBinding
import com.example.randomusercybilltek.viewmodel.ProfileVIewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    private val args: ProfileFragmentArgs by navArgs()

    private lateinit var profileViewModel: ProfileVIewModel
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
        profileViewModel = ViewModelProvider(this)[ProfileVIewModel::class.java]

        profileViewModel.person.observe(viewLifecycleOwner) { person ->
            binding.tvFullName.text = buildString {
        append(person.name?.first)
        append(" ")
        append(person.name?.last) }
            binding.tvGender.text = person.gender
            binding.tvNationality.text = person.location?.city

            Glide.with(binding.root.context)
                .load(person.picture?.large ?: person.picture?.medium)
                .into(binding.imgUser)
        }
        val uid = args.UID
        uid.let { profileViewModel.getByUID(it) }
    }

}
