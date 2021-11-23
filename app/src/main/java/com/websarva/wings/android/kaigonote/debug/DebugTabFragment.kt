package com.websarva.wings.android.kaigonote.debug

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.websarva.wings.android.kaigonote.R
import com.websarva.wings.android.kaigonote.data.BaseKaigoData
import com.websarva.wings.android.kaigonote.data.Haiben
import com.websarva.wings.android.kaigonote.data.Hainyou
import com.websarva.wings.android.kaigonote.data.KaigoDB
import com.websarva.wings.android.kaigonote.databinding.FragmentDebugTabBinding
import com.websarva.wings.android.kaigonote.databinding.ItemLogBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.DateFormat

class DebugTabFragment : Fragment() {

    companion object {
        const val TITLE = "title"
    }

    private var binding: FragmentDebugTabBinding? = null
    private var adapter: ArrayAdapter<BaseKaigoData>? = null
    private lateinit var dateFormat: DateFormat

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDebugTabBinding.inflate(inflater)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title = arguments?.getString(TITLE) ?: "title"
        binding!!.title.text = title
        dateFormat = DateFormat.getDateTimeInstance()

        adapter = object : ArrayAdapter<BaseKaigoData>(requireContext(), R.layout.item_log) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                var cv = convertView
                if (cv == null) {
                    cv = layoutInflater.inflate(R.layout.item_log, parent, false)
                }
                when (title) {
                    "排尿" -> {
                        val data = getItem(position)!! as Hainyou
                        val itemBinding = ItemLogBinding.bind(cv!!)
                        itemBinding.date.text = dateFormat.format(data.hiduke)
                        itemBinding.name.text = data.name
                        itemBinding.haisetu.text = data.hainyou
                    }
                    "排便" -> {
                        val data = getItem(position)!! as Haiben
                        val itemBinding = ItemLogBinding.bind(cv!!)
                        itemBinding.date.text = dateFormat.format(data.hiduke)
                        itemBinding.name.text = data.name
                    }
                }
                return cv!!
            }
        }
        binding!!.listView.adapter = adapter
        loadKaigoLog(title)
    }

    private fun loadKaigoLog(type: String) {
        lifecycleScope.launch {
            val application = requireContext().applicationContext as Application
            val db = KaigoDB.getInstance(application)
            when (type) {
                "排尿" -> {
                    val dao = db.hainyou()
                    adapter!!.clear()
                    val list = withContext(Dispatchers.IO) {
                        dao.gethainyouAll(0)
                    }
                    adapter!!.addAll(list)
                }
                "排便" -> {
                    val dao = db.haiben()
                    adapter!!.clear()
                    val list = withContext(Dispatchers.IO) {
                        dao.gethaibenAll()
                    }
                    adapter!!.addAll(list)
                }
            }
        }
    }
}
