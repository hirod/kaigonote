package com.websarva.wings.android.kaigonote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.websarva.wings.android.kaigonote.databinding.SyokuzennyakuasaBinding

class SyokuzennyakuasaActivity : AppCompatActivity() {
    private var binding: SyokuzennyakuasaBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SyokuzennyakuasaBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)
    }
}