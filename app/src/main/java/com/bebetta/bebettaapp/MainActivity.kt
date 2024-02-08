package com.bebetta.bebettaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.Window
import android.view.WindowManager
import androidx.fragment.app.Fragment
import com.bebetta.bebettaapp.databinding.ActivityMainBinding
import com.bebetta.bebettaapp.views.AccountFragment
import com.bebetta.bebettaapp.views.ChatFragment
import com.bebetta.bebettaapp.views.DashboardFragment
import com.bebetta.bebettaapp.views.ReceiptFragment
import com.bebetta.bebettaapp.views.RewardFragment

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val window: Window = this.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = resources.getColor(R.color.black)

        setFragment(DashboardFragment())

        binding.btmNavigation.setOnNavigationItemSelectedListener { menu ->
//            addBadgeToMenuItem(menu)

            when (menu.itemId) {

                R.id.home -> {
                    setFragment(DashboardFragment())
                    true
                }
                R.id.vector -> {
                    setFragment(RewardFragment())
                    true
                }
                R.id.receipt -> {
                    setFragment(ReceiptFragment())
                    true
                }
                R.id.chat -> {
                    setFragment(ChatFragment())
                    true
                }
                R.id.account -> {
                    setFragment(AccountFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun setFragment(fr: Fragment) {
        val frag = supportFragmentManager.beginTransaction()
        frag.replace(R.id.main_layout, fr)
        frag.addToBackStack(null)
        frag.commit()

    }

    private fun addBadgeToMenuItem(menuItem: MenuItem) {
        val badge = binding.btmNavigation.getOrCreateBadge(menuItem.itemId)
//        badge.number = count
    }
}