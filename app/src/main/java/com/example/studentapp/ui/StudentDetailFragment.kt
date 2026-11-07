
package com.example.studentapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.studentapp.databinding.FragmentStudentDetailBinding

class StudentDetailFragment : Fragment() {

    private var _binding: FragmentStudentDetailBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance(student: Student): StudentDetailFragment {
            return StudentDetailFragment().apply {
                arguments = Bundle().apply {
                    putString("id", student.id)
                    putString("name", student.name)
                    putString("major", student.major)
                    putString("email", student.email)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStudentDetailBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvId.text =
            "Mã sinh viên: ${arguments?.getString("id")}"

        binding.tvName.text =
            "Họ và tên: ${arguments?.getString("name")}"

        binding.tvMajor.text =
            "Ngành: ${arguments?.getString("major")}"

        binding.tvEmail.text =
            "Email: ${arguments?.getString("email")}"

        binding.btnBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
