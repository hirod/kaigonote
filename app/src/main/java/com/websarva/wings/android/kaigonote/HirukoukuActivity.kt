package com.websarva.wings.android.kaigonote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.websarva.wings.android.kaigonote.databinding.HirukoukuBinding

class HirukoukuActivity : AppCompatActivity() {
    private var binding: HirukoukuBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HirukoukuBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)
    }
}