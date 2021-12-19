package com.websarva.wings.android.kaigonote

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.lifecycleScope
import com.websarva.wings.android.kaigonote.data.KaigoDB
import com.websarva.wings.android.kaigonote.data.Tyousyokugoyaku
import com.websarva.wings.android.kaigonote.databinding.ActivityFukuyakuKirokuBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class Fukuyaku_kirokuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFukuyakuKirokuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFukuyakuKirokuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.clear.setOnClickListener {
            clearDb()
        }
        binding.addFukuyaku.setOnClickListener {
            addFukuyaku()
        }
        setPagerAdapter()
    }

    private fun clearDb() {
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                val db = KaigoDB.getInstance(application)
                db.tyousyokugoyaku().deleteAll()
            }
        }
    }

    private fun addFukuyaku() {
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                val dao = KaigoDB.getInstance(application).tyousyokugoyaku()
                for (i in 0 until 100) {
                    dao.insert(Tyousyokugoyaku(0, Date(), "", "", ""))
                }
            }
        }
    }

    private fun setPagerAdapter() {
        binding.viewPager.adapter = object : FragmentPagerAdapter(supportFragmentManager) {
            private val titles =
                arrayOf("朝食後薬", "昼食後薬")

            override fun getCount(): Int {
                //タブ数
                return titles.size
            }

            override fun getPageTitle(position: Int): CharSequence {
                return titles[position]
            }

            override fun getItem(position: Int): Fragment {
                val title = titles[position]
                //Fragumentにデータを渡す
                val bundle = Bundle()
                bundle.putString(HaiyakuFragment.TITLE, title)
                val fragment = HaiyakuFragment()
                fragment.arguments = bundle
                return fragment
            }
        }
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }
}