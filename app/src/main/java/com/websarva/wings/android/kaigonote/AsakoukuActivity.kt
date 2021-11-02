package com.websarva.wings.android.kaigonote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.websarva.wings.android.kaigonote.databinding.AsakoukuBinding

class AsakoukuActivity : AppCompatActivity() {
    private var binding: AsakoukuBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AsakoukuBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)
    }
}