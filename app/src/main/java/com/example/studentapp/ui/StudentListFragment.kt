
package com.example.studentapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.studentapp.databinding.FragmentStudentListBinding

class StudentListFragment : Fragment() {

    private var _binding: FragmentStudentListBinding? = null
    private val binding get() = _binding!!

    private val students = listOf(
        Student(
            "2415053122131",
            "Dương Phước Quang",
            "Công nghệ thông tin",
            "2415053122131@sv.ute.udn.vn"
        ),
        Student(
            "SV002",
            "Nguyễn Văn A",
            "Công nghệ thông tin",
            "student02@example.com"
        ),
        Student(
            "SV003",
            "Trần Thị B",
            "Công nghệ thông tin",
            "student03@example.com"
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStudentListBinding.inflate(
            inflater, container, false
        )
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        val names = students.map {
            "${it.name}\nMSSV: ${it.id}"
        }

        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            names
        )

        binding.listStudents.adapter = adapter

        binding.listStudents.setOnItemClickListener {
                _, _, position, _ ->

            val student = students[position]

            (requireActivity() as MainActivity)
                .showStudentDetail(student)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
