package com.websarva.wings.android.kaigonote;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import androidx.appcompat.app.AppCompatActivity;

import com.websarva.wings.android.kaigonote.databinding.AcsidentoBinding;


public class AcsidentoActivity extends AppCompatActivity implements OnClickListener {
    private AcsidentoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = AcsidentoBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.btClick22.setOnClickListener(this);//ヒヤリハットボタンがタップされたときの処理
        binding.btClick23.setOnClickListener(this);//事故報告ボタンがタップされたときの処理
    }

    public void onClick(View v) {
        if (v.getId() == R.id.bt_click22) {
            Intent intent22 = new Intent(this, HiyariActivity.class);//ヒヤリハット
            startActivity(intent22);
        } else if (v.getId() == R.id.bt_click23) {
            Intent intent23 = new Intent(this, ZikoActivity.class);//事故報告
            startActivity(intent23);
        }
    }
}