package com.websarva.wings.android.kaigonote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.websarva.wings.android.kaigonote.databinding.MosiokuriBinding

class MosiokuriActivity : AppCompatActivity() {
    private var binding: MosiokuriBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MosiokuriBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)
    }
}