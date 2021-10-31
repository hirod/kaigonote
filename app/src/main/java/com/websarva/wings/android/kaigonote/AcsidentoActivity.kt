package com.websarva.wings.android.kaigonote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.websarva.wings.android.kaigonote.R
import android.content.Intent
import android.view.View
import com.websarva.wings.android.kaigonote.HiyariActivity
import com.websarva.wings.android.kaigonote.ZikoActivity
import com.websarva.wings.android.kaigonote.databinding.AcsidentoBinding

class AcsidentoActivity : AppCompatActivity(), View.OnClickListener {
    private var binding: AcsidentoBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AcsidentoBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)
        binding!!.hiyariClick.setOnClickListener(this) //ヒヤリハットボタンがタップされたときの処理
        binding!!.zikoClick.setOnClickListener(this) //事故報告ボタンがタップされたときの処理
    }

    override fun onClick(v: View) {
        if (v.id == R.id.hiyari_click) {
            val intent22 = Intent(this, HiyariActivity::class.java) //ヒヤリハット
            startActivity(intent22)
        } else if (v.id == R.id.ziko_click) {
            val intent23 = Intent(this, ZikoActivity::class.java) //事故報告
            startActivity(intent23)
        }
    }
}