package com.websarva.wings.android.kaigonote

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.websarva.wings.android.kaigonote.data.KaigoDB
import com.websarva.wings.android.kaigonote.data.Kannsyoku
import com.websarva.wings.android.kaigonote.databinding.KansyokuBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class KansyokuActivity : AppCompatActivity() {
    private var _kannsyokuId = -1
    private var _kansyokuName = ""


    private var binding: KansyokuBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = KansyokuBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)

        binding!!.kansyoku.onItemClickListener = ListItemClickListner()
    }

    fun onSaveButtonClick(view: View?) {
        //名前習得
        binding!!.nameLabelu.text
        //飲水量習得
        binding!!.insuiLabelu.text
        val tv_name1 = findViewById<Button>(R.id.save)
        tv_name1.isEnabled = false
        val kannsyoku = Kannsyoku(
            0,
            Date(),
            binding!!.nameLabelu.text.toString(),
            _kansyokuName,
            binding!!.insuiLabelu.text.toString()
        )
        saveData(kannsyoku)
    }

    private fun saveData(kannsyoku: Kannsyoku) {
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                val db = KaigoDB.getInstance(application)
                val dao = db.kannsyoku()
                dao.insert(kannsyoku)
            }
            //保存完了
            finish()
        }
    }

    private inner class ListItemClickListner : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            _kannsyokuId = position
            _kansyokuName = parent?.getItemAtPosition(position) as String
            binding!!.tvName.text = _kansyokuName
            binding!!.save.isEnabled = true
        }
    }
}