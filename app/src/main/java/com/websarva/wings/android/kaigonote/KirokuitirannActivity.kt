package com.websarva.wings.android.kaigonote

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
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
                val itemBinding = ItemLogBinding.bind(cv!!)
                itemBinding.date.text = data.hiduke.toString()
                return cv
            }
        }
        binding!!.list.adapter = adapter

        //読み込み
        loadLog()
    }

    private fun loadLog() {
        lifecycleScope.launch {
            // データベースから読み込み
            val list = withContext(Dispatchers.IO) {
                val db = KaigoDB.getInstance(application)
                val dao = db.hainyou()
                dao.gethainyouAll()
            }
            adapter.clear()
            adapter.addAll(list)
            //画面に表示
        }
    }
}
