package com.websarva.wings.android.kaigonote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.websarva.wings.android.kaigonote.databinding.KirokuitirannBinding

class KirokuitirannActivity : AppCompatActivity() {
    private var binding: KirokuitirannBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = KirokuitirannBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)
    }
}