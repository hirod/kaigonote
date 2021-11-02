package com.websarva.wings.android.kaigonote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.websarva.wings.android.kaigonote.databinding.TyousyokuBinding

class TyousyokuActivity : AppCompatActivity() {
    private var binding: TyousyokuBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TyousyokuBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)
    }
}