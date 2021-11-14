package com.websarva.wings.android.kaigonote

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.websarva.wings.android.kaigonote.databinding.ActivityDebugBinding

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
    }

    private fun addHainyou() {
    }
}
