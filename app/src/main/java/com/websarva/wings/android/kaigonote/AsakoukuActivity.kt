package com.websarva.wings.android.kaigonote

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.websarva.wings.android.kaigonote.data.KaigoDB
import com.websarva.wings.android.kaigonote.data.Koukuasa
import com.websarva.wings.android.kaigonote.databinding.AsakoukuBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class AsakoukuActivity : AppCompatActivity() {
    private var _asakoukuId = -1
    private var _asakoukuName = ""

    private var binding: AsakoukuBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AsakoukuBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)
        binding!!.asakouku.onItemClickListener = ListItemClickListner()
    }

    fun onSaveButtonClick(view: View) {
        binding!!.nameLabelu.text
        binding!!.bikouLabelu.text
        val tv_name1 = findViewById<Button>(R.id.save)
        tv_name1.isEnabled = false
        val koukuasa = Koukuasa(
            0,
            Date(),
            binding!!.nameLabelu.text.toString(),
            _asakoukuName,
            binding!!.bikouLabelu.text.toString()
        )

        saveData(koukuasa)
    }

    private fun saveData(koukuasa: Koukuasa) {
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                val db = KaigoDB.getInstance(application)
                val dao = db.koukuasa()
                dao.insert(koukuasa)
            }
            finish()
        }
    }

    private inner class ListItemClickListner : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            _asakoukuId = position
            _asakoukuName = parent?.getItemAtPosition(position) as String
            binding!!.senntaku.text = _asakoukuName
            binding!!.save.isEnabled = true
        }
    }
}