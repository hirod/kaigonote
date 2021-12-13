package com.websarva.wings.android.kaigonote

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.websarva.wings.android.kaigonote.data.KaigoDB
import com.websarva.wings.android.kaigonote.data.Koukuyoru
import com.websarva.wings.android.kaigonote.databinding.YorukoukuBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class YorukoukuActivity : AppCompatActivity() {
    private var _yorukoukuId = -1
    private var _yorukoukuName = ""

    private var binding: YorukoukuBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = YorukoukuBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)
        binding!!.yorukouku.onItemClickListener = ListItemClickListner()
    }

    fun onSaveButtonClick(view: View) {
        binding!!.nameLabelu.text
        binding!!.bikouLabelu.text
        val tv_name1 = findViewById<Button>(R.id.save)
        tv_name1.isEnabled = false
        val koukuyoru = Koukuyoru(
            0,
            Date(),
            binding!!.nameLabelu.text.toString(),
            _yorukoukuName,
            binding!!.bikouLabelu.text.toString()
        )
        saveData(koukuyoru)
    }

    private fun saveData(koukuyoru: Koukuyoru) {
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                val db = KaigoDB.getInstance(application)
                val dao = db.koukuyoru()
                dao.insert(koukuyoru)
            }
            finish()
        }
    }

    private inner class ListItemClickListner : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            _yorukoukuId = position
            _yorukoukuName = parent?.getItemAtPosition(position) as String
            binding!!.senntaku.text = _yorukoukuName
            binding!!.save.isEnabled = true
        }
    }
}