package com.example.gads20p.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.gads20p.LearnerFragment
import com.example.gads20p.SkillFragment

class ViewPagerAdapter( fm : FragmentManager, lifecycle: Lifecycle ) :
    FragmentStateAdapter(fm, lifecycle) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {

        var fragment : Fragment? = null
        when(position){
            0 -> fragment = LearnerFragment()
            1 -> fragment = SkillFragment()
        }

        return fragment!!
    }


}