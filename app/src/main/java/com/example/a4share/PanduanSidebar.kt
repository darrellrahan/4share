package com.example.a4share

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.header.*

class PanduanSidebar : AppCompatActivity() {
    lateinit var toggleSidebar: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.panduan_sidebar)

        supportActionBar?.hide()

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val sidebar: NavigationView = findViewById(R.id.sidebar_view)
        val sidebarHeader: View = sidebar.getHeaderView(0)

        sidebarHeader.setOnClickListener {
            Toast.makeText(this@PanduanSidebar, "Clicked", Toast.LENGTH_SHORT).show()
        }

        toggleSidebar = ActionBarDrawerToggle(this@PanduanSidebar, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggleSidebar)
        toggleSidebar.syncState()

        open_sidebar.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        open_chat.setOnClickListener {
            startActivity(Intent(this@PanduanSidebar, Chat::class.java))
        }

        sidebar.setNavigationItemSelectedListener {
            if(it.itemId == R.id.ic_panduan) {
                startActivity(Intent(this@PanduanSidebar, PanduanSidebar::class.java))
                finish()
            }

            if(it.itemId == R.id.ic_home) {
                startActivity(Intent(this@PanduanSidebar, Dashboard::class.java))
                finish()
            }

            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggleSidebar.onOptionsItemSelected(item)) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}