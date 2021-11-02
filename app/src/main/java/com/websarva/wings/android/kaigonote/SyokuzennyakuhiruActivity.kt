package com.websarva.wings.android.kaigonote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.websarva.wings.android.kaigonote.databinding.SyokuzennyakuhiruBinding

class SyokuzennyakuhiruActivity : AppCompatActivity() {
    private var binding: SyokuzennyakuhiruBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SyokuzennyakuhiruBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)
    }
}