package com.websarva.wings.android.kaigonote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.websarva.wings.android.kaigonote.R
import android.content.Intent
import android.view.View
import com.websarva.wings.android.kaigonote.TyousyokuActivity
import com.websarva.wings.android.kaigonote.TyusyokuActivity
import com.websarva.wings.android.kaigonote.YuusyokuActivity
import com.websarva.wings.android.kaigonote.KansyokuActivity
import com.websarva.wings.android.kaigonote.databinding.SyokujiBinding

class SyokujiActivity : AppCompatActivity(), View.OnClickListener {
    private var binding: SyokujiBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SyokujiBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)
        binding!!.tyousyokuClick.setOnClickListener(this) //朝食ボタンタップされたときの処理
        binding!!.tyusyokuClick.setOnClickListener(this) //昼食ボタンタップされたときの処理
        binding!!.yuusyokuClick.setOnClickListener(this) //夕食ボタンタップされたときの処理
        binding!!.kansyokuClick.setOnClickListener(this) //間食ボタンタップされたときの処理
    }

    override fun onClick(v: View) {
        if (v.id == R.id.tyousyoku_click) {
            val intent12 = Intent(this, TyousyokuActivity::class.java) //朝食記録
            startActivity(intent12)
        } else if (v.id == R.id.tyusyoku_click) {
            val intent13 = Intent(this, TyusyokuActivity::class.java) //昼食記録
            startActivity(intent13)
        } else if (v.id == R.id.yuusyoku_click) {
            val intent14 = Intent(this, YuusyokuActivity::class.java) //夕食記録
            startActivity(intent14)
        } else if (v.id == R.id.kansyoku_click) {
            val intent15 = Intent(this, KansyokuActivity::class.java) //間食記録
            startActivity(intent15)
        }
    }
}