package com.websarva.wings.android.kaigonote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.websarva.wings.android.kaigonote.databinding.TyusyokuBinding

class TyusyokuActivity : AppCompatActivity() {
    private var binding: TyusyokuBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TyusyokuBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)
    }
}