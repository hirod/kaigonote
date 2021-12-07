package com.websarva.wings.android.kaigonote

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.websarva.wings.android.kaigonote.data.KaigoDB
import com.websarva.wings.android.kaigonote.data.Yuusyoku
import com.websarva.wings.android.kaigonote.databinding.YuusyokuBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class YuusyokuActivity : AppCompatActivity() {
    private var _yuusyokuId = -1
    private var _fukusyokuId = -1
    private var _yuusyokuName = ""
    private var _fukusyokuName = ""

    private var binding: YuusyokuBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = YuusyokuBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)

        binding!!.yuusyoku.onItemClickListener = ListItemClickListner()
        binding!!.fukusyoku.onItemClickListener = ListClickListner()
    }

    fun onSaveButtonClick(view: View?) {
        //名前習得
        binding!!.nameLabelu.text
        //飲水量習得
        binding!!.insuiLabelu.text
        val tv_name1 = findViewById<Button>(R.id.save)
        tv_name1.isEnabled = false
        val yuusyoku = Yuusyoku(
            0,
            Date(),
            binding!!.nameLabelu.text.toString(),
            _yuusyokuName,
            _fukusyokuName,
            binding!!.insuiLabelu.text.toString()
        )
        saveData(yuusyoku)
    }

    private fun saveData(yuusyoku: Yuusyoku) {
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                val db = KaigoDB.getInstance(application)
                val dao = db.yuusyoku()
                dao.insert(yuusyoku)
            }
            //保存完了
            finish()
        }
    }

    private inner class ListItemClickListner : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            _yuusyokuId = position
            _yuusyokuName = parent?.getItemAtPosition(position) as String
            binding!!.tvName.text = _yuusyokuName
            binding!!.save.isEnabled = true
        }
    }

    private inner class ListClickListner : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            _fukusyokuId = position
            _fukusyokuName = parent?.getItemAtPosition(position) as String
            binding!!.noSenntaku.text = _fukusyokuName
            binding!!.save.isEnabled = true
        }
    }


}