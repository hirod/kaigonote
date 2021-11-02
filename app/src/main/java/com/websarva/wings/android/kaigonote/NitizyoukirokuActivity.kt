package com.websarva.wings.android.kaigonote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.websarva.wings.android.kaigonote.databinding.NitizyoukirokuBinding

class NitizyoukirokuActivity : AppCompatActivity() {
    private var binding: NitizyoukirokuBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NitizyoukirokuBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)
    }
}