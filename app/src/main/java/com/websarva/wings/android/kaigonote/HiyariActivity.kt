package com.websarva.wings.android.kaigonote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.websarva.wings.android.kaigonote.databinding.HiyariBinding

class HiyariActivity : AppCompatActivity() {
    private var binding: HiyariBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HiyariBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)
    }
}