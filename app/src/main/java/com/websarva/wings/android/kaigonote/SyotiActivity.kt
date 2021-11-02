package com.websarva.wings.android.kaigonote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.websarva.wings.android.kaigonote.databinding.SyotiBinding

class SyotiActivity : AppCompatActivity() {
    private var binding: SyotiBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SyotiBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)
    }
}