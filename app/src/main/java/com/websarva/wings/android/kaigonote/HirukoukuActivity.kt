package com.websarva.wings.android.kaigonote

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.websarva.wings.android.kaigonote.databinding.HirukoukuBinding

class HirukoukuActivity : AppCompatActivity() {
    private var binding: HirukoukuBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HirukoukuBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)

        val viewPager: ViewPager2 = findViewById(R.id.view_hainyou)

        val fragments: ArrayList<Fragment> = arrayListOf(
            HainyouFragment(),
            HaibennFragment(),
        )

        var adapter = ViewPagerAdapter(fragments, this)
        viewPager.adapter = adapter

    }
}