package com.example.a4share

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.a4share.bottomnavfragment.AccountFragment
import com.example.a4share.bottomnavfragment.HomeFragment
import com.example.a4share.bottomnavfragment.PostFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)

        supportActionBar?.hide()

        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_nav)
        val homeFragment = HomeFragment()
        val postFragment = PostFragment()
        val accountFragment = AccountFragment()

        makeCurrentFragment(homeFragment)

        bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_home -> makeCurrentFragment(homeFragment)
                R.id.ic_post -> makeCurrentFragment(postFragment)
                R.id.ic_account -> makeCurrentFragment(accountFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
}