package com.websarva.wings.android.kaigonote

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.websarva.wings.android.kaigonote.data.KaigoDB
import com.websarva.wings.android.kaigonote.data.Tyousyoku
import com.websarva.wings.android.kaigonote.databinding.TyousyokuBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class TyousyokuActivity : AppCompatActivity() {
    private var _tyousyokuId = -1
    private var _fukusyokuId = -1
    private var _tyousyokuName = ""
    private var _fukusyokuName = ""


    private var binding: TyousyokuBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TyousyokuBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)

        binding!!.syusyoku.onItemClickListener = ListItemClickListner()

        binding!!.fukusyoku.onItemClickListener = ListClickListner()//副食リスト
    }


    fun onSaveButtonClick(view: View?) {
        //名前習得
        binding!!.nameLabelu.text
        //飲水量習得
        binding!!.insuiLabelu.text
        val tv_name1 = findViewById<Button>(R.id.save)
        tv_name1.isEnabled = false
        val tyousyoku = Tyousyoku(
            0,
            Date(),
            binding!!.nameLabelu.text.toString(),
            _tyousyokuName,
            _fukusyokuName,
            binding!!.insuiLabelu.text.toString()
        )
        saveData(tyousyoku)
    }

    private fun saveData(tyousyoku: Tyousyoku) {
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                val db = KaigoDB.getInstance(application)
                val dao = db.tyousyoku()
                dao.insert(tyousyoku)
            }
            //保存完了
            finish()
        }
    }

    private inner class ListItemClickListner : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
            _tyousyokuId = position
            _tyousyokuName = parent.getItemAtPosition(position) as String
            binding!!.tvName.text = _tyousyokuName

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
   
