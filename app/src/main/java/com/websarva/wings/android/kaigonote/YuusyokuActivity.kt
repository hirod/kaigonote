package com.websarva.wings.android.kaigonote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.websarva.wings.android.kaigonote.databinding.YuusyokuBinding

class YuusyokuActivity : AppCompatActivity() {
    private var binding: YuusyokuBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = YuusyokuBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)
    }
}