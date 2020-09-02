package com.example.gads20p

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.gads20p.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val tabLayout = findViewById<TabLayout>(R.id.leaderboardTab)
        val viewPager = findViewById<ViewPager2>(R.id.leaderboardViewpager)

        viewPager.adapter =
            ViewPagerAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(tabLayout, viewPager,
            TabLayoutMediator.TabConfigurationStrategy{ tab, position ->
                when(position){
                    0 -> tab.text = "Learning Leaders"
                    1 -> tab.text = "Skill IQ Leaders"
                }
            }
        ).attach()

        submit_project.setOnClickListener {
            startActivity(Intent(this, FormActivity::class.java))
        }
    }

}
