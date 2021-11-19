package com.websarva.wings.android.kaigonote

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.websarva.wings.android.kaigonote.data.Haiben
import com.websarva.wings.android.kaigonote.data.Hainyou
import com.websarva.wings.android.kaigonote.data.KaigoDB
import com.websarva.wings.android.kaigonote.databinding.ItemLogBinding
import com.websarva.wings.android.kaigonote.databinding.KirokuitirannBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class KirokuitirannActivity : AppCompatActivity() {

    private var binding: KirokuitirannBinding? = null
    private lateinit var adapter: ArrayAdapter<Hainyou>
    private lateinit var adapter2: ArrayAdapter<Haiben>
    private var page: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = KirokuitirannBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)


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
