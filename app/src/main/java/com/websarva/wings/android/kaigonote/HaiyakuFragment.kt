package com.websarva.wings.android.kaigonote

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.websarva.wings.android.kaigonote.data.BaseHaiyakuData
import com.websarva.wings.android.kaigonote.data.KaigoDB
import com.websarva.wings.android.kaigonote.data.Tyousyokugoyaku
import com.websarva.wings.android.kaigonote.databinding.FragmentHaiyakuBinding
import com.websarva.wings.android.kaigonote.databinding.ItemHaiyakuBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.DateFormat


class HaiyakuFragment : Fragment() {

    companion object {
        const val TITLE = "title"
    }

    private lateinit var binding: FragmentHaiyakuBinding
    private lateinit var adapter: ArrayAdapter<BaseHaiyakuData>
    private lateinit var dateFormat: DateFormat

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHaiyakuBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title = arguments?.getString(TITLE) ?: "title"
        binding.title.text = title
        dateFormat = DateFormat.getDateTimeInstance()

        adapter = object : ArrayAdapter<BaseHaiyakuData>(requireContext(), R.layout.item_haiyaku) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                var cv = convertView
                if (cv == null) {
                    cv = layoutInflater.inflate(R.layout.item_haiyaku, parent, false)
                }
                when (title) {
                    "朝食後薬" -> {
                        val data = getItem(position)!! as Tyousyokugoyaku
                        val itemHaiyakuBinding = ItemHaiyakuBinding.bind(cv!!)
                        itemHaiyakuBinding.date.text = dateFormat.format(data.hiduke)
                        itemHaiyakuBinding.name.text = data.name
                        itemHaiyakuBinding.kusuri.text = data.tyousyokugoyaku
                        itemHaiyakuBinding.suibunryou.text = data.suibunnryou
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
                "朝食後薬" -> {
                    val dao = db.tyousyokugoyaku()
                    adapter.clear()
                    val list = withContext(Dispatchers.IO) {
                        dao.gettyousyokugoyakuAll(0)
                    }
                    adapter.addAll(list)
                }
            }
        }

    }

}


