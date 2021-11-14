package com.websarva.wings.android.kaigonote

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.websarva.wings.android.kaigonote.data.Haiben
import com.websarva.wings.android.kaigonote.data.KaigoDB
import com.websarva.wings.android.kaigonote.databinding.HaibennBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Date

class HaibennActivity : AppCompatActivity() {
    private var _haibennId = -1
    private var _haibennName = ""
    private var binding: HaibennBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HaibennBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)
        binding!!.haibenn.onItemClickListener = ListItemClickListner()
    }

    fun onSaveButtonClick(view: View) {
        binding!!.nameLabelu.text
        binding!!.bikou.text
        val tv_name1 = findViewById<Button>(R.id.save)
        tv_name1.isEnabled = false
        val haiben = Haiben(0, Date(), binding!!.nameLabelu.text.toString(), _haibennName, binding!!.bikou.text.toString())
        saveData(haiben)
    }

    private fun saveData(haiben: Haiben) {
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                val db = KaigoDB.getInstance(application)
                val dao = db.haiben()
                dao.insert(haiben)
            }
            finish()
        }
    }

    private inner class ListItemClickListner : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
            _haibennId = position
            _haibennName = parent.getItemAtPosition(position) as String
            binding!!.selectedHaibenn.text = _haibennName
            binding!!.save.isEnabled = true
        }
    }
}
