package com.example.tugasp10

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Menyambungkan TabLayout dan ViewPager2
        val viewPager: ViewPager2 = findViewById(R.id.view_pager)
        val tabLayout: TabLayout = findViewById(R.id.tab_layout)

        // Adapter untuk ViewPager2, gunakan FragmentStateAdapter untuk fragment
        val adapter = ViewPager2(this)
        viewPager.adapter = adapter

        // Menghubungkan TabLayout dengan ViewPager2 menggunakan TabLayoutMediator
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Register"
                1 -> "Login"
                else -> null
            }
        }.attach()

        // Mengatur ikon dan item menu (seperti tombol logout) di ActionBar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_logout)
        supportActionBar?.setTitle("Login & Register")
    }

    // Menangani item menu, seperti logout
    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_home -> {
                // Logika logout (misal, kembali ke tampilan utama)
                finish() // Keluar dari aplikasi (atau bisa redirect ke layar login)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
