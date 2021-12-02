package com.websarva.wings.android.kaigonote

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.websarva.wings.android.kaigonote.databinding.KirokuMainBinding

class KirokumainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: KirokuMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = KirokuMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)
        binding.haisetuKiroku.setOnClickListener(this)
        binding.syokuziKiroku.setOnClickListener(this)
        binding.fukuyakuKiroku.setOnClickListener(this)
        binding.nyuuyokuKiroku.setOnClickListener(this)
        binding.nitizyouKiroku.setOnClickListener(this)
        binding.koukuKiroku.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.haisetu_kiroku -> {
                val intent = Intent(this, Haisetu_kirokuActivity::class.java)
                startActivity(intent)
            }
            R.id.syokuzi_kiroku -> {
                val intent10 = Intent(this, Syokuji_kirokuActivity::class.java)
                startActivity(intent10)
            }
            R.id.fukuyaku_kiroku -> {
                val intent11 = Intent(this, Fukuyaku_kirokuActivity::class.java)
                startActivity(intent11)
            }
            R.id.nyuuyoku_kiroku -> {
                val intent12 = Intent(this, Nyuyoku_kirokuActivity::class.java)
                startActivity(intent12)
            }
            R.id.nitizyou_kiroku -> {
                val intent13 = Intent(this, Nitizyou_kirokuActivity::class.java)
                startActivity(intent13)
            }
            R.id.kouku_kiroku -> {
                val intent14 = Intent(this, Kouku_kirokuActivity::class.java)
                startActivity(intent14)
            }
        }
    }

}