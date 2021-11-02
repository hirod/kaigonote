package com.websarva.wings.android.kaigonote

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.websarva.wings.android.kaigonote.databinding.TonpukuBinding

class TonpukuActivity : AppCompatActivity() {
    private var binding: TonpukuBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TonpukuBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)
    }
}