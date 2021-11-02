package com.websarva.wings.android.kaigonote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.websarva.wings.android.kaigonote.databinding.NyuyokukirokuBinding

class NyuyokukirokuActivity : AppCompatActivity() {
    private var binding: NyuyokukirokuBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NyuyokukirokuBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)
    }
}