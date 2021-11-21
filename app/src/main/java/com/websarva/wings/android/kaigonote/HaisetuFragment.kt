package com.websarva.wings.android.kaigonote

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.websarva.wings.android.kaigonote.data.Hainyou
import com.websarva.wings.android.kaigonote.data.KaigoDB
import com.websarva.wings.android.kaigonote.databinding.FragmentHaisetuBinding
import com.websarva.wings.android.kaigonote.databinding.ItemLogBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HaisetuFragment : Fragment() {

    private lateinit var binding: FragmentHaisetuBinding
    private lateinit var adapter: ArrayAdapter<Hainyou>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHaisetuBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = object : ArrayAdapter<Hainyou>(requireContext(), R.layout.item_log) {
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
        binding.list.adapter = adapter
        loadLog(0)
    }

    private fun loadLog(offset: Long) {
        lifecycleScope.launch {
            // データベースから読み込み
            val list = withContext(Dispatchers.IO) {
                val db = KaigoDB.getInstance(requireContext().applicationContext as Application)
                val dao = db.hainyou()
                dao.gethainyouAll(offset)
            }
            adapter.clear()
            adapter.addAll(list)
            //画面に表示
        }
        //追加
    }
}



