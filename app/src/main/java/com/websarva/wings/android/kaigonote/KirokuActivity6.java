package com.websarva.wings.android.kaigonote;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import androidx.appcompat.app.AppCompatActivity;

import com.websarva.wings.android.kaigonote.databinding.ActivityMain7Binding;

public class KirokuActivity6 extends AppCompatActivity implements OnClickListener {
    private ActivityMain7Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain7Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.btClick19.setOnClickListener(this);//日常記録ボタンがタップされたときの処理
        binding.btClick20.setOnClickListener(this);//入浴記録ボタンがタップされたときの処理
        binding.btClick21.setOnClickListener(this);//申し送りボタンがタップされたときの処理

    }

    public void onClick(View v) {
        if (v.getId() == R.id.bt_click19) {
            Intent intent19 = new Intent(this, NitizyoukirokuActivity6_1.class);//日常記録
            startActivity(intent19);
        } else if (v.getId() == R.id.bt_click20) {
            Intent intent20 = new Intent(this, NyuyokukirokuActivity6_2.class);//入浴記録
            startActivity(intent20);
        } else if (v.getId() == R.id.bt_click21) {
            Intent intent21 = new Intent(this, MosiokuriActivity6_3.class);//申し送り
            startActivity(intent21);
        }
    }
}