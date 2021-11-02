package com.websarva.wings.android.kaigonote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.websarva.wings.android.kaigonote.databinding.NyuyokuBinding

class NyuyokuActivity : AppCompatActivity() {
    private var binding: NyuyokuBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NyuyokuBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)
    }
}