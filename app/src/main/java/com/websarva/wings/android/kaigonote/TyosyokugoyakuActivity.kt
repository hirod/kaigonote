package com.websarva.wings.android.kaigonote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.websarva.wings.android.kaigonote.databinding.TyosyokugoyakuBinding

class TyosyokugoyakuActivity : AppCompatActivity() {
    private var binding: TyosyokugoyakuBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TyosyokugoyakuBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)
    }
}