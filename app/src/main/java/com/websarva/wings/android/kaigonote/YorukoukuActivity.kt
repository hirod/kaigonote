package com.websarva.wings.android.kaigonote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.websarva.wings.android.kaigonote.databinding.YorukoukuBinding

class YorukoukuActivity : AppCompatActivity() {
    private var binding: YorukoukuBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = YorukoukuBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)
    }
}