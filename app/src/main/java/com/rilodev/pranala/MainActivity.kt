package com.rilodev.pranala

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.rilodev.pranala.databinding.ActivityMainBinding
import com.rilodev.pranala.prima_number.PrimaCheckerActivity
import com.rilodev.pranala.starting.ConfirmationFragment
import com.rilodev.pranala.starting.IntroductionFragment
import com.rilodev.pranala.starting.PreviewFragment

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private var currentIndex = 0

    override fun onResume() {
        super.onResume()

        currentIndex = 0
        loadFragment(PreviewFragment())
        binding.first.setBackgroundResource(R.drawable.bg_indicator_selected)
        binding.second.setBackgroundResource(R.drawable.bg_indicator)
        binding.third.setBackgroundResource(R.drawable.bg_indicator)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            initUI()
        }
    }

    private fun ActivityMainBinding.initUI() {
        getStartedBtn.setOnClickListener {
            when (currentIndex) {
                0 -> {
                    loadFragment(IntroductionFragment())
                    ++currentIndex
                    getStartedBtn.text = resources.getString(R.string.next)
                    second.setBackgroundResource(R.drawable.bg_indicator_selected)
                }
                1 -> {
                    loadFragment(ConfirmationFragment())
                    ++currentIndex
                    getStartedBtn.text = resources.getString(R.string.start_it)
                    third.setBackgroundResource(R.drawable.bg_indicator_selected)
                }
                else -> {
                    startActivity(Intent(this@MainActivity, PrimaCheckerActivity::class.java))
                }
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()

        transaction.replace(binding.fragmentView.id, fragment)

        transaction.commit()
    }
}