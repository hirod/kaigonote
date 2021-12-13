package com.websarva.wings.android.kaigonote

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.websarva.wings.android.kaigonote.data.BaseKoukuData
import com.websarva.wings.android.kaigonote.data.KaigoDB
import com.websarva.wings.android.kaigonote.data.Koukuasa
import com.websarva.wings.android.kaigonote.databinding.FragmentKoukuBinding
import com.websarva.wings.android.kaigonote.databinding.ItemKoukuBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.DateFormat


class KoukuFragment : Fragment() {
    companion object {
        const val TITLE = "title"
    }

    private lateinit var binding: FragmentKoukuBinding
    private lateinit var adapter: ArrayAdapter<BaseKoukuData>
    private lateinit var dateFormat: DateFormat

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentKoukuBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title = arguments?.getString(TITLE) ?: "title"
        binding.title.text = title
        dateFormat = DateFormat.getDateTimeInstance()

        adapter = object : ArrayAdapter<BaseKoukuData>(requireContext(), R.layout.item_kouku) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                var cv = convertView
                if (cv == null) {
                    cv = layoutInflater.inflate(R.layout.item_kouku, parent, false)
                }
                when (title) {
                    "口腔朝" -> {
                        val data = getItem(position)!! as Koukuasa
                        val itemKoukuBinding = ItemKoukuBinding.bind(cv!!)
                        itemKoukuBinding.date.text = dateFormat.format(data.hiduke)
                        itemKoukuBinding.name.text = data.name
                        itemKoukuBinding.kouku.text = data.koukuasa
                        itemKoukuBinding.bikou.text = data.bikou
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
                "口腔朝" -> {
                    val dao = db.koukuasa()
                    adapter.clear()
                    val list = withContext(Dispatchers.IO) {
                        dao.getkoukuasaAll(0)
                    }
                    adapter.addAll(list)
                }
            }
        }
    }
}



