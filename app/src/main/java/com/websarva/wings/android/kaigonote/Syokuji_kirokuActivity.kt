package com.websarva.wings.android.kaigonote

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.lifecycleScope
import com.websarva.wings.android.kaigonote.data.KaigoDB
import com.websarva.wings.android.kaigonote.data.Tyousyoku
import com.websarva.wings.android.kaigonote.databinding.ActivitySyokujiKirokuBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class Syokuji_kirokuActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySyokujiKirokuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySyokujiKirokuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.clear.setOnClickListener {
            clearDb()
        }
        binding.addSyokuji.setOnClickListener {
            addSyokuji()
        }
        setPagerAdapter()
    }

    private fun clearDb() {
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                val db = KaigoDB.getInstance(application)
                db.tyousyoku().deleteAll()
                db.tyuusyoku().deleteAll()
                db.yuusyoku().deleteAll()
            }
        }
    }

    private fun addSyokuji() {
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                val dao = KaigoDB.getInstance(application).tyousyoku()
                for (i in 0 until 100) {
                    dao.insert(Tyousyoku(0, Date(), "", "", "", ""))
                }
            }
        }
    }

    private fun setPagerAdapter() {
        binding.viewPager.adapter = object : FragmentPagerAdapter(supportFragmentManager) {
            private val titles = arrayOf("朝食", "昼食", "夕食", "間食")
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
                bundle.putString(SyokujiFragment.TITLE, title)
                val fragment = SyokujiFragment()
                fragment.arguments = bundle
                return fragment
            }
        }
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }
}

