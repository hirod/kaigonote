package com.websarva.wings.android.kaigonote

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.lifecycleScope
import com.websarva.wings.android.kaigonote.data.KaigoDB
import com.websarva.wings.android.kaigonote.data.Koukuasa
import com.websarva.wings.android.kaigonote.databinding.ActivityKoukuKirokuBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class Kouku_kirokuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityKoukuKirokuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKoukuKirokuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.clear.setOnClickListener {
            clearDb()
        }
        binding.addKouku.setOnClickListener {
            addKouku()
        }
        setPagerAdapter()
    }

    private fun clearDb() {
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                val db = KaigoDB.getInstance(application)
                db.koukuasa().deleteAll()
            }
        }
    }

    private fun addKouku() {
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                val dao = KaigoDB.getInstance(application).koukuasa()
                for (i in 0 until 100) {
                    dao.insert(Koukuasa(0, Date(), "", "", ""))
                }
            }
        }
    }

    private fun setPagerAdapter() {
        binding.viewPager.adapter = object : FragmentPagerAdapter(supportFragmentManager) {
            private val titles = arrayOf("口腔朝", "口腔昼", "口腔夜")
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
                bundle.putString(KoukuFragment.TITLE, title)
                val fragment = KoukuFragment()
                fragment.arguments = bundle
                return fragment
            }
        }
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }
}