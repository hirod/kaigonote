package com.websarva.wings.android.kaigonote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.websarva.wings.android.kaigonote.databinding.YusyokugoyakuBinding

class YusyokugoyakuActivity : AppCompatActivity() {
    private var binding: YusyokugoyakuBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = YusyokugoyakuBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)
    }
}