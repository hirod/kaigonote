package com.websarva.wings.android.kaigonote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.websarva.wings.android.kaigonote.R
import android.content.Intent
import android.view.View
import com.websarva.wings.android.kaigonote.HainyouActivity
import com.websarva.wings.android.kaigonote.HaibennActivity
import com.websarva.wings.android.kaigonote.databinding.HaisetuBinding

class HaisetuActivity : AppCompatActivity(), View.OnClickListener {
    private var binding: HaisetuBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HaisetuBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view) //画面切り替え
        binding!!.hainyouClick.setOnClickListener(this) //排尿ボタンがタップされたときの処理
        binding!!.haibennClick.setOnClickListener(this) //排便ボタンがタップされたときの処理
    }

    override fun onClick(v: View) {
        if (v.id == R.id.hainyou_click) {
            val intent10 = Intent(this, HainyouActivity::class.java) //排尿メニュー
            startActivity(intent10)
        } else if (v.id == R.id.haibenn_click) {
            val intent11 = Intent(this, HaibennActivity::class.java) //排便メニュー
            startActivity(intent11)
        }
    }
}