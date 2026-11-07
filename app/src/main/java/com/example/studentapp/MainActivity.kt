
package com.example.studentapp

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.studentapp.databinding.ActivityMainBinding

class MainActivity : FragmentActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, StudentListFragment())
                .commit()
        }
    }

    fun showStudentDetail(student: Student) {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.fragmentContainer,
                StudentDetailFragment.newInstance(student)
            )
            .addToBackStack(null)
            .commit()
    }
}
