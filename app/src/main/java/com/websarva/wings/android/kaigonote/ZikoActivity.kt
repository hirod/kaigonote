package com.websarva.wings.android.kaigonote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.websarva.wings.android.kaigonote.databinding.ZikoBinding

class ZikoActivity : AppCompatActivity() {
    private var binding: ZikoBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ZikoBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)
    }
}