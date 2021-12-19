package com.websarva.wings.android.kaigonote

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.websarva.wings.android.kaigonote.data.KaigoDB
import com.websarva.wings.android.kaigonote.data.Tyousyokugoyaku
import com.websarva.wings.android.kaigonote.databinding.TyosyokugoyakuBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class TyosyokugoyakuActivity : AppCompatActivity() {
    private var _fukuyakuasaId = -1
    private var _fukuyakuasaName = ""

    private var binding: TyosyokugoyakuBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TyosyokugoyakuBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)

        binding!!.fukuyakuasa.onItemClickListener = ListItemClickListner()
    }

    fun onSaveButtonClick(view: View?) {
        //名前習得
        binding!!.nameLabelu.text
        //飲水量習得
        binding!!.insuiLabelu.text
        val tv_name1 = findViewById<Button>(R.id.save)
        tv_name1.isEnabled = false
        val tyousyokugoyaku = Tyousyokugoyaku(
            0,
            Date(),
            binding!!.nameLabelu.text.toString(),
            _fukuyakuasaName,
            binding!!.insuiLabelu.text.toString()
        )
        saveData(tyousyokugoyaku)
    }

    private fun saveData(tyousyokugoyaku: Tyousyokugoyaku) {
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                val db = KaigoDB.getInstance(application)
                val dao = db.tyousyokugoyaku()
                dao.insert(tyousyokugoyaku)
            }
            finish()
        }
    }

    private inner class ListItemClickListner : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            _fukuyakuasaId = position
            _fukuyakuasaName = parent?.getItemAtPosition(position) as String
            binding!!.tvName.text = _fukuyakuasaName
            binding!!.save.isEnabled = true
        }
    }
}