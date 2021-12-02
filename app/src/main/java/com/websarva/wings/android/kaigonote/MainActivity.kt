package com.websarva.wings.android.kaigonote

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.websarva.wings.android.kaigonote.databinding.MenuBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var binding: MenuBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MenuBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view)
        binding!!.haisetuClick.setOnClickListener(this) //排泄ボタンがタップされたときの処理
        binding!!.syokujinsuiClick.setOnClickListener(this) //食事ボタンがタップされたときの処理
        binding!!.koukuClick.setOnClickListener(this) //口腔ボタンがタップされたときの処理
        binding!!.nyuyokuClick.setOnClickListener(this) //入浴ボタンがタップされたときの処理
        binding!!.kirokuClick.setOnClickListener(this) //記録ボタンがタップされたときの処理
        binding!!.acsidentoClick.setOnClickListener(this) //アクシデントボタンがタップされたときの処理
        binding!!.syotiClick.setOnClickListener(this) //処置ボタンがタップされたときの処理
        binding!!.haiyakuClick.setOnClickListener(this) //配薬ボタンがタップされたときの処理
        binding!!.kirokuitirannClick.setOnClickListener(this) //記録一覧ボタンがタップされたときの処理
        binding!!.debug.setOnClickListener {
            startActivity(Intent(this, DebugActivity::class.java))
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.haisetu_click -> {
                val intent = Intent(this, HaisetuActivity::class.java) //排泄メニュー
                startActivity(intent)
            }
            R.id.syokujinsui_click -> {
                val intent2 = Intent(this, SyokujiActivity::class.java) //食事メニュー
                startActivity(intent2)
            }
            R.id.kouku_click -> {
                val intent3 = Intent(this, KoukuActivity::class.java) //口腔メニュー
                startActivity(intent3)
            }
            R.id.nyuyoku_click -> {
                val intent4 = Intent(this, NyuyokuActivity::class.java) //入浴メニュー
                startActivity(intent4)
            }
            R.id.kiroku_click -> {
                val intent5 = Intent(this, KirokuActivity::class.java) //記録メニュー
                startActivity(intent5)
            }
            R.id.acsidento_click -> {
                val intent6 = Intent(this, AcsidentoActivity::class.java) //アクシデントメニュー
                startActivity(intent6)
            }
            R.id.syoti_click -> {
                val intent7 = Intent(this, SyotiActivity::class.java) //処置メニュー
                startActivity(intent7)
            }
            R.id.haiyaku_click -> {
                val intent8 = Intent(this, HaiyakuActivity::class.java) //配薬メニュー
                startActivity(intent8)
            }
            R.id.kirokuitirann_click -> {
                val intent9 = Intent(this, KirokumainActivity::class.java) //記録一覧メニュー
                startActivity(intent9)
            }
        }
    }
}
