package com.websarva.wings.android.kaigonote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.websarva.wings.android.kaigonote.databinding.SyusinngoyakuBinding

class SyusinngoyakuActivity : AppCompatActivity() {
    private var binding: SyusinngoyakuBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SyusinngoyakuBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)
    }
}