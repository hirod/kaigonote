package com.websarva.wings.android.kaigonote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.websarva.wings.android.kaigonote.R
import android.content.Intent
import android.view.View
import com.websarva.wings.android.kaigonote.NitizyoukirokuActivity
import com.websarva.wings.android.kaigonote.NyuyokukirokuActivity
import com.websarva.wings.android.kaigonote.MosiokuriActivity
import com.websarva.wings.android.kaigonote.databinding.KirokuBinding

class KirokuActivity : AppCompatActivity(), View.OnClickListener {
    private var binding: KirokuBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = KirokuBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)
        binding!!.nitizyoukirokuClick.setOnClickListener(this) //日常記録ボタンがタップされたときの処理
        binding!!.nyuyokukirokuClick.setOnClickListener(this) //入浴記録ボタンがタップされたときの処理
        binding!!.mosiokuriClick.setOnClickListener(this) //申し送りボタンがタップされたときの処理
    }

    override fun onClick(v: View) {
        if (v.id == R.id.nitizyoukiroku_click) {
            val intent19 = Intent(this, NitizyoukirokuActivity::class.java) //日常記録
            startActivity(intent19)
        } else if (v.id == R.id.nyuyokukiroku_click) {
            val intent20 = Intent(this, NyuyokukirokuActivity::class.java) //入浴記録
            startActivity(intent20)
        } else if (v.id == R.id.mosiokuri_click) {
            val intent21 = Intent(this, MosiokuriActivity::class.java) //申し送り
            startActivity(intent21)
        }
    }
}