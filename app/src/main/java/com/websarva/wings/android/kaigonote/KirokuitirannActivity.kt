package com.websarva.wings.android.kaigonote

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.websarva.wings.android.kaigonote.databinding.KirokuitirannBinding

class KirokuitirannActivity : AppCompatActivity() {

    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var binding: KirokuitirannBinding
    private var page: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = KirokuitirannBinding.inflate(layoutInflater)

        val view: View = binding.root

        setContentView(view)

        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        with(binding) {
            binding.viewPager.adapter = viewPagerAdapter
            TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
                when (position) {
                    0 -> tab.text = "排泄"
                    1 -> tab.text = "食事"
                    2 -> tab.text = "口腔"
                    3 -> tab.text = "入浴"
                    4 -> tab.text = "日常記録"
                    5 -> tab.text = "申し送り"
                    6 -> tab.text = "ヒヤリハット"
                    7 -> tab.text = "事故報告"
                    8 -> tab.text = "処置"
                }
            }.attach()
        }
    }
}


/*

  //読み込み
  loadLog(0))*/

