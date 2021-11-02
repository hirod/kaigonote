package com.websarva.wings.android.kaigonote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.websarva.wings.android.kaigonote.databinding.HaibennBinding

class HaibennActivity : AppCompatActivity() {
    private var binding: HaibennBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HaibennBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)
    }
}