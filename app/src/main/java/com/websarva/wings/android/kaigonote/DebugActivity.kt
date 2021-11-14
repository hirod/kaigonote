package com.websarva.wings.android.kaigonote

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.websarva.wings.android.kaigonote.data.Hainyou
import com.websarva.wings.android.kaigonote.data.KaigoDB
import com.websarva.wings.android.kaigonote.databinding.ActivityDebugBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Date

class DebugActivity : AppCompatActivity() {

    private var binding: ActivityDebugBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDebugBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        binding!!.clearHainyou.setOnClickListener {
            clearHainyou()
        }

        binding!!.addHainyou.setOnClickListener {
            addHainyou()
        }
    }

    private fun clearHainyou() {
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                val dao = KaigoDB.getInstance(application).hainyou()
                dao.deleteAll()
            }
        }
    }

    private fun addHainyou() {
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                val dao = KaigoDB.getInstance(application).hainyou()
                for (i in 0 until 100) {
                    dao.insert(Hainyou(0, Date(), "${i}さん", "あり", "$i"))
                }
            }
        }
    }
}
