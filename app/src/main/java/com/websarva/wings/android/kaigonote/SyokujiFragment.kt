package com.websarva.wings.android.kaigonote

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.websarva.wings.android.kaigonote.data.*
import com.websarva.wings.android.kaigonote.databinding.FragmentSyokujiBinding
import com.websarva.wings.android.kaigonote.databinding.ItemSyokujiBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.DateFormat

class SyokujiFragment : Fragment() {

    companion object {
        const val TITLE = "title"
    }

    private lateinit var binding: FragmentSyokujiBinding
    private lateinit var adapter: ArrayAdapter<BaseSyokujiData>
    private lateinit var dateFormat: DateFormat

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSyokujiBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title = arguments?.getString(TITLE) ?: "title"
        binding.title.text = title
        dateFormat = DateFormat.getDateTimeInstance()

        adapter = object : ArrayAdapter<BaseSyokujiData>(requireContext(), R.layout.item_syokuji) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                var cv = convertView
                if (cv == null) {
                    cv = layoutInflater.inflate(R.layout.item_syokuji, parent, false)
                }
                when (title) {
                    "朝食" -> {
                        val data = getItem(position)!! as Tyousyoku
                        val itemSyokujiBinding = ItemSyokujiBinding.bind(cv!!)//画面表示する
                        itemSyokujiBinding.date.text = dateFormat.format(data.hiduke)
                        itemSyokujiBinding.name.text = data.name
                        itemSyokujiBinding.syusyoku.text = data.tyousyoku
                        itemSyokujiBinding.fukusyoku.text = data.fukusyoku
                        itemSyokujiBinding.suibunryou.text = data.tyousyokuInsui
                    }
                    //昼食
                    "昼食" -> {
                        val data = getItem(position)!! as Tyuusyoku
                        val itemSyokujiBinding = ItemSyokujiBinding.bind(cv!!)//画面表示
                        itemSyokujiBinding.date.text = dateFormat.format(data.hiduke)
                        itemSyokujiBinding.name.text = data.name
                        itemSyokujiBinding.syusyoku.text = data.tyuusyoku
                        itemSyokujiBinding.fukusyoku.text = data.fukusyoku
                        itemSyokujiBinding.suibunryou.text = data.tyuusyokuInsui
                    }
                    //夕食
                    "夕食" -> {
                        val data = getItem(position)!! as Yuusyoku
                        val itemSyokujiBinding = ItemSyokujiBinding.bind(cv!!)//画面表示
                        itemSyokujiBinding.date.text = dateFormat.format(data.hiduke)
                        itemSyokujiBinding.name.text = data.name
                        itemSyokujiBinding.syusyoku.text = data.yuusyoku
                        itemSyokujiBinding.fukusyoku.text = data.fukusyoku
                        itemSyokujiBinding.suibunryou.text = data.yuusyokuInsui
                    }
                    //間食
                    "間食" -> {
                        val data = getItem(position)!! as Kannsyoku
                        val itemSyokujiBinding = ItemSyokujiBinding.bind(cv!!)//画面表示
                        itemSyokujiBinding.date.text = dateFormat.format(data.hiduke)
                        itemSyokujiBinding.name.text = data.name
                        itemSyokujiBinding.syusyoku.text = data.kannsyoku
                        itemSyokujiBinding.suibunryou.text = data.kannsyokuInsui
                    }
                }
                return cv!!
            }
        }
        binding.listView.adapter = adapter
        loadKaigoLog(title)
    }

    private fun loadKaigoLog(type: String) {
        lifecycleScope.launch {
            val application = requireContext().applicationContext as Application
            val db = KaigoDB.getInstance(application)
            when (type) {
                "朝食" -> {
                    val dao = db.tyousyoku()
                    adapter.clear()
                    val list = withContext(Dispatchers.IO) {
                        dao.gettyousyokuAll(0)
                    }
                    adapter.addAll(list)
                }
                "昼食" -> {
                    val dao = db.tyuusyoku()
                    adapter.clear()
                    val list = withContext(Dispatchers.IO) {
                        dao.gettyuusyokuAll(0)
                    }
                    adapter.addAll(list)
                }
                "夕食" -> {
                    val dao = db.yuusyoku()
                    adapter.clear()
                    val list = withContext(Dispatchers.IO) {
                        dao.gettyuusyokuAll(0)
                    }
                    adapter.addAll(list)
                }
                "間食" -> {
                    val dao = db.kannsyoku()
                    adapter.clear()
                    val list = withContext(Dispatchers.IO) {
                        dao.getkannsyokuAll(0)
                    }
                    adapter.addAll(list)
                }
            }
        }

    }
}
                
    
    
    
