package com.websarva.wings.android.kaigonote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.websarva.wings.android.kaigonote.databinding.TyusyokugoyakuBinding

class TyusyokugoyakuActivity : AppCompatActivity() {
    private var binding: TyusyokugoyakuBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TyusyokugoyakuBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)
    }
}