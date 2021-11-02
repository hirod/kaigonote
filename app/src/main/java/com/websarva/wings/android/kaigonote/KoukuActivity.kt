package com.websarva.wings.android.kaigonote

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.websarva.wings.android.kaigonote.databinding.KoukuBinding

class KoukuActivity : AppCompatActivity(), View.OnClickListener {
    private var binding: KoukuBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = KoukuBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)
        binding!!.asakoukuClick.setOnClickListener(this) //朝食 口腔ボタンがタップされたときの処理
        binding!!.hirukoukuClick.setOnClickListener(this) //昼食 口腔ボタンがタップされたときの処理
        binding!!.yorukoukuClick.setOnClickListener(this) //夕食 口腔ボタンがタップされたときの処理
    }

    override fun onClick(v: View) {
        if (v.id == R.id.asakouku_click) {
            val intent16 = Intent(this, AsakoukuActivity::class.java) //朝食 口腔メニュー
            startActivity(intent16)
        } else if (v.id == R.id.hirukouku_click) {
            val intent17 = Intent(this, HirukoukuActivity::class.java) //昼食 口腔メニュー
            startActivity(intent17)
        } else if (v.id == R.id.yorukouku_click) {
            val intent18 = Intent(this, YorukoukuActivity::class.java) //夕食 口腔メニュー
            startActivity(intent18)
        }
    }
}