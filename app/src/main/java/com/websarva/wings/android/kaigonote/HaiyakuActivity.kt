package com.websarva.wings.android.kaigonote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.websarva.wings.android.kaigonote.R
import android.content.Intent
import android.view.View
import com.websarva.wings.android.kaigonote.TyosyokugoyakuActivity
import com.websarva.wings.android.kaigonote.TyusyokugoyakuActivity
import com.websarva.wings.android.kaigonote.YusyokugoyakuActivity
import com.websarva.wings.android.kaigonote.KisyouziyakuActivity
import com.websarva.wings.android.kaigonote.SyusinngoyakuActivity
import com.websarva.wings.android.kaigonote.TonpukuActivity
import com.websarva.wings.android.kaigonote.SyokuzennyakuasaActivity
import com.websarva.wings.android.kaigonote.SyokuzennyakuhiruActivity
import com.websarva.wings.android.kaigonote.SyokuzennyakuyoruActivity
import com.websarva.wings.android.kaigonote.databinding.HaiyakuBinding

class HaiyakuActivity : AppCompatActivity(), View.OnClickListener {
    private var binding: HaiyakuBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HaiyakuBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)
        binding!!.tyosyokugoyakuClick.setOnClickListener(this) //朝食後薬ボタンがタップされたときの処理
        binding!!.tyusyokugoyakuClick.setOnClickListener(this) //昼食後薬ボタンがタップされたときの処理
        binding!!.yusyokugoyakuClick.setOnClickListener(this) //夕食後薬ボタンがタップされたときの処理
        binding!!.kisyouziyakuClick.setOnClickListener(this) //起床時薬ボタンがタップされたときの処理
        binding!!.syusinngoyakuClick.setOnClickListener(this) //就寝薬ボタンがタップされたときの処理
        binding!!.tonpukuClick.setOnClickListener(this) //頓服ボタンがタップされたときの処理
        binding!!.syokuzennyakuasaClick.setOnClickListener(this) //朝食前薬ボタンがタップされたときの処理
        binding!!.syokuzennyakuhiruClick.setOnClickListener(this) //昼食前薬ボタンがタップされたときの処理
        binding!!.syokuzennyakuyoruClick.setOnClickListener(this) //夜食前薬ボタンがタップされたときの処理
    }

    override fun onClick(v: View) {
        if (v.id == R.id.tyosyokugoyaku_click) {
            val intent24 = Intent(this, TyosyokugoyakuActivity::class.java) //朝食後薬
            startActivity(intent24)
        } else if (v.id == R.id.tyusyokugoyaku_click) {
            val intent25 = Intent(this, TyusyokugoyakuActivity::class.java) //昼食後薬
            startActivity(intent25)
        } else if (v.id == R.id.yusyokugoyaku_click) {
            val intent26 = Intent(this, YusyokugoyakuActivity::class.java) //夕食後薬
            startActivity(intent26)
        } else if (v.id == R.id.kisyouziyaku_click) {
            val intent27 = Intent(this, KisyouziyakuActivity::class.java) //起床時薬
            startActivity(intent27)
        } else if (v.id == R.id.syusinngoyaku_click) {
            val intent28 = Intent(this, SyusinngoyakuActivity::class.java) //就寝薬
            startActivity(intent28)
        } else if (v.id == R.id.tonpuku_click) {
            val intent29 = Intent(this, TonpukuActivity::class.java) //頓服
            startActivity(intent29)
        } else if (v.id == R.id.syokuzennyakuasa_click) {
            val intent30 = Intent(this, SyokuzennyakuasaActivity::class.java) //朝食前薬
            startActivity(intent30)
        } else if (v.id == R.id.syokuzennyakuhiru_click) {
            val intent31 = Intent(this, SyokuzennyakuhiruActivity::class.java) //昼食前薬
            startActivity(intent31)
        } else if (v.id == R.id.syokuzennyakuyoru_click) {
            val intent32 = Intent(this, SyokuzennyakuyoruActivity::class.java) //夜食前薬
            startActivity(intent32)
        }
    }
}