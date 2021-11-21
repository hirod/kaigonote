package com.websarva.wings.android.kaigonote

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 9
    }


    override fun createFragment(position: Int): Fragment {
        var fragment = Fragment()
        when (position) {
            0 -> {
                fragment = HaisetuFragment()
            }
            1 -> {
                fragment = SyokujiFragment()
            }
            2 -> {
                fragment = KoukuFragment()
            }
            3 -> {
                fragment = NyuyokuFragment()
            }
            4 -> {
                fragment = NitizyoukirokuFragment()
            }
            5 -> {
                fragment = MousiokuriFragment()
            }
            6 -> {
                fragment = HiyarihatFragment()
            }
            7 -> {
                fragment = ZikohoukokuFragment()
            }
            8 -> {
                fragment = SyotiFragment()
            }
            else -> {
                Fragment()
            }
        }
        return fragment
    }

}