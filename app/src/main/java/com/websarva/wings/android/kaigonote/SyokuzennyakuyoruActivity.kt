package com.websarva.wings.android.kaigonote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.websarva.wings.android.kaigonote.databinding.SyokuzennyakuyoruBinding

class SyokuzennyakuyoruActivity : AppCompatActivity() {
    private var binding: SyokuzennyakuyoruBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SyokuzennyakuyoruBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)
    }
}