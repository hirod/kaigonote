package com.websarva.wings.android.kaigonote

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
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