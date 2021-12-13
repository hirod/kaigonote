package com.websarva.wings.android.kaigonote

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.websarva.wings.android.kaigonote.data.KaigoDB
import com.websarva.wings.android.kaigonote.data.Koukuhiru
import com.websarva.wings.android.kaigonote.databinding.HirukoukuBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class HirukoukuActivity : AppCompatActivity() {
    private var _hirukoukuId = -1
    private var _hirukoukuName = ""

    private var binding: HirukoukuBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HirukoukuBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)
        binding!!.hirukouku.onItemClickListener = ListItemClickListner()
    }

    fun onSaveButtonClick(view: View) {
        binding!!.nameLabelu.text
        binding!!.bikouLabelu.text
        val tv_name1 = findViewById<Button>(R.id.save)
        tv_name1.isEnabled = false
        val koukuhiru = Koukuhiru(
            0,
            Date(),
            binding!!.nameLabelu.text.toString(),
            _hirukoukuName,
            binding!!.bikouLabelu.text.toString()
        )
        saveData(koukuhiru)
    }

    private fun saveData(koukuhiru: Koukuhiru) {
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                val db = KaigoDB.getInstance(application)
                val dao = db.koukuhiru()
                dao.insert(koukuhiru)
            }
            finish()
        }
    }

    private inner class ListItemClickListner : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            _hirukoukuId = position
            _hirukoukuName = parent?.getItemAtPosition(position) as String
            binding!!.senntaku.text = _hirukoukuName
            binding!!.save.isEnabled = true
        }
    }

}