package com.websarva.wings.android.kaigonote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.websarva.wings.android.kaigonote.databinding.KisyouziyakuBinding

class KisyouziyakuActivity : AppCompatActivity() {
    private var binding: KisyouziyakuBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = KisyouziyakuBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)
    }
}