package com.websarva.wings.android.kaigonote;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.websarva.wings.android.kaigonote.databinding.ActivityMain4Binding;

public class SyokujiActivity3 extends AppCompatActivity implements View.OnClickListener {
    private ActivityMain4Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain4Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.btClick12.setOnClickListener(this);//朝食ボタンタップされたときの処理
        binding.btClick13.setOnClickListener(this);//昼食ボタンタップされたときの処理
        binding.btClick14.setOnClickListener(this);//夕食ボタンタップされたときの処理
        binding.btClick15.setOnClickListener(this);//間食ボタンタップされたときの処理

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt_click12) {
            Intent intent12 = new Intent(this, TyousyokuActivity3_1.class);//朝食記録
            startActivity(intent12);
        } else if (v.getId() == R.id.bt_click13) {
            Intent intent13 = new Intent(this, TyusyokuActivity3_2.class);//昼食記録
            startActivity(intent13);
        } else if (v.getId() == R.id.bt_click14) {
            Intent intent14 = new Intent(this, YuusyokuActivity3_3.class);//夕食記録
            startActivity(intent14);
        } else if (v.getId() == R.id.bt_click15) {
            Intent intent15 = new Intent(this, KansyokuActivity3_4.class);//間食記録
            startActivity(intent15);
        }

    }
}

