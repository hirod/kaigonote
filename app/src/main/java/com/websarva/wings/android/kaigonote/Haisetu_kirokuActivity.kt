package com.websarva.wings.android.kaigonote

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.lifecycleScope
import com.websarva.wings.android.kaigonote.data.Haiben
import com.websarva.wings.android.kaigonote.data.Hainyou
import com.websarva.wings.android.kaigonote.data.KaigoDB
import com.websarva.wings.android.kaigonote.databinding.ActivityHaisetuKirokuBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class Haisetu_kirokuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHaisetuKirokuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHaisetuKirokuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.clearHainyou.setOnClickListener {
            clearDb()
        }
        binding.addHainyou.setOnClickListener {
            addHainyou()
        }
        binding.addHaibenn.setOnClickListener {
            addHaibenn()
        }
        setPagerAdapter()
    }

    private fun clearDb() {
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                val db = KaigoDB.getInstance(application)
                db.hainyou().deleteAll()
                db.haiben().deleteAll()
            }
        }
    }

    private fun addHaibenn() {
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                val dao = KaigoDB.getInstance(application).haiben()
                for (i in 0 until 100) {
                    dao.insert(Haiben(0, Date(), "", "", ""))

                }
            }
        }
    }

    private fun addHainyou() {
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                val dao = KaigoDB.getInstance(application).hainyou()
                for (i in 0 until 100) {
                    dao.insert(Hainyou(0, Date(), "", "", ""))
                }
            }
        }
    }


    private fun setPagerAdapter() {
        binding.viewPager.adapter = object : FragmentPagerAdapter(supportFragmentManager) {
            private val titles = arrayOf("??????", "??????")
            override fun getCount(): Int {
                //?????????
                return titles.size
            }

            //???????????????
            override fun getPageTitle(position: Int): CharSequence {
                return titles[position]
            }

            override fun getItem(position: Int): Fragment {
                val title = titles[position]
                //Fragment????????????????????????
                val bundle = Bundle()
                bundle.putString(HaisetuFragment.TITLE, title)
                val fragment = HaisetuFragment()
                fragment.arguments = bundle
                return fragment
            }

        }
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }
}



