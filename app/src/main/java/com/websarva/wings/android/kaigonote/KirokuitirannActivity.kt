package com.websarva.wings.android.kaigonote

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.android.material.tabs.TabLayoutMediator
import com.websarva.wings.android.kaigonote.data.Hainyou
import com.websarva.wings.android.kaigonote.data.KaigoDB
import com.websarva.wings.android.kaigonote.databinding.ItemLogBinding
import com.websarva.wings.android.kaigonote.databinding.KirokuitirannBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class KirokuitirannActivity : AppCompatActivity() {

    private lateinit var binding2: ItemLogBinding
    private lateinit var viewPagerAdapter: ViewPagerAdapter


    private var binding: KirokuitirannBinding? = null
    private lateinit var adapter: ArrayAdapter<Hainyou>
    private var page: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = KirokuitirannBinding.inflate(layoutInflater)
        binding2 = ItemLogBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        val view2: View = binding2.root
        setContentView(view)
        setContentView(view2)

        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        with(binding2) {
            viewPager.adapter = viewPagerAdapter
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
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

        adapter = object : ArrayAdapter<Hainyou>(this, R.layout.item_log) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val data = getItem(position)!!
                var cv = convertView
                if (cv == null) {
                    cv = layoutInflater.inflate(R.layout.item_log, parent, false)

                }
                val itemBinding = ItemLogBinding.bind(cv!!)//画面表示する
                itemBinding.date.text = data.hiduke.toString()
                itemBinding.name.text = data.name
                itemBinding.haisetu.text = data.hainyou
                return cv
            }

        }
        binding!!.list.adapter = adapter
        binding!!.next.setOnClickListener {
            page++
            loadLog((page * 100).toLong())
        }
        binding!!.back.setOnClickListener {
            if (page > 0) {
                page--
            }
            loadLog((page * 100).toLong())
        }

        //読み込み
        loadLog(0)
    }

    private fun loadLog(offset: Long) {
        lifecycleScope.launch {
            // データベースから読み込み
            val list = withContext(Dispatchers.IO) {
                val db = KaigoDB.getInstance(application)
                val dao = db.hainyou()
                dao.gethainyouAll(offset)
            }
            adapter.clear()
            adapter.addAll(list)
            //画面に表示
        }
    }

}
