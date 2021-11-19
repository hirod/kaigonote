package com.websarva.wings.android.kaigonote

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.websarva.wings.android.kaigonote.data.Hainyou
import com.websarva.wings.android.kaigonote.data.KaigoDB
import com.websarva.wings.android.kaigonote.databinding.HainyouBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class HainyouActivity : AppCompatActivity() {
    private var _kaigoId = -1
    private var _kaigoName = ""
    private var binding: HainyouBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HainyouBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)
        binding!!.kaigo.onItemClickListener = ListItemClickListner()
    }


    fun onSaveButtonClick(view: View?) {
        //名前を習得。
        binding!!.nameLabelu.text
        //備考を習得。
        binding!!.bikou.text
        val tv_name1 = findViewById<Button>(R.id.save)
        tv_name1.isEnabled = false
        val hainyou = Hainyou(
            0,
            Date(),
            binding!!.nameLabelu.text.toString(),
            _kaigoName,
            binding!!.bikou.text.toString()
        )
        saveData(hainyou)
    }

    private fun saveData(hainyou: Hainyou) {
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                val db = KaigoDB.getInstance(application)
                val dao = db.hainyou()
                dao.insert(hainyou)
            }
            //保存完了
            finish()
        }
    }

    private inner class ListItemClickListner : OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
            _kaigoId = position
            _kaigoName = parent.getItemAtPosition(position) as String
            binding!!.hainyou.text = _kaigoName
            binding!!.save.isEnabled = true
        }
    }
}
