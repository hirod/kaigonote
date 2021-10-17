package com.websarva.wings.android.kaigonote;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import androidx.appcompat.app.AppCompatActivity;

import com.websarva.wings.android.kaigonote.databinding.KoukuBinding;

public class KoukuActivity extends AppCompatActivity implements OnClickListener {
    private KoukuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = KoukuBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.asakoukuClick.setOnClickListener(this);//朝食 口腔ボタンがタップされたときの処理
        binding.hirukoukuClick.setOnClickListener(this);//昼食 口腔ボタンがタップされたときの処理
        binding.yorukoukuClick.setOnClickListener(this);//夕食 口腔ボタンがタップされたときの処理

    }

    public void onClick(View v) {
        if (v.getId() == R.id.asakouku_click) {
            Intent intent16 = new Intent(this, AsakoukuActivity.class);//朝食 口腔メニュー
            startActivity(intent16);
        } else if (v.getId() == R.id.hirukouku_click) {
            Intent intent17 = new Intent(this, HirukoukuActivity.class);//昼食 口腔メニュー
            startActivity(intent17);
        } else if (v.getId() == R.id.yorukouku_click) {
            Intent intent18 = new Intent(this, YorukoukuActivity.class);//夕食 口腔メニュー
            startActivity(intent18);
        }
    }
}