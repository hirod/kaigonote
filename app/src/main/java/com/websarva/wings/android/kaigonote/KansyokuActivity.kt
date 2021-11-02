package com.websarva.wings.android.kaigonote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.websarva.wings.android.kaigonote.databinding.KansyokuBinding

class KansyokuActivity : AppCompatActivity() {
    private var binding: KansyokuBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = KansyokuBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)
    }
}