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
        binding.btClick16.setOnClickListener(this);//朝食 口腔ボタンがタップされたときの処理
        binding.btClick17.setOnClickListener(this);//昼食 口腔ボタンがタップされたときの処理
        binding.btClick18.setOnClickListener(this);//夕食 口腔ボタンがタップされたときの処理

    }

    public void onClick(View v) {
        if (v.getId() == R.id.bt_click16) {
            Intent intent16 = new Intent(this, AsakoukuActivity.class);//朝食 口腔メニュー
            startActivity(intent16);
        } else if (v.getId() == R.id.bt_click17) {
            Intent intent17 = new Intent(this, HirukoukuActivity.class);//昼食 口腔メニュー
            startActivity(intent17);
        } else if (v.getId() == R.id.bt_click18) {
            Intent intent18 = new Intent(this, YorukoukuActivity.class);//夕食 口腔メニュー
            startActivity(intent18);
        }
    }
}