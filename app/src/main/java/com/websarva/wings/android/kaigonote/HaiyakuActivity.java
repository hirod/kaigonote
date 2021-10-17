package com.websarva.wings.android.kaigonote;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import androidx.appcompat.app.AppCompatActivity;

import com.websarva.wings.android.kaigonote.databinding.HaiyakuBinding;

public class HaiyakuActivity extends AppCompatActivity implements OnClickListener {

    private HaiyakuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = HaiyakuBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.tyosyokugoyakuClick.setOnClickListener(this);//朝食後薬ボタンがタップされたときの処理
        binding.tyusyokugoyakuClick.setOnClickListener(this);//昼食後薬ボタンがタップされたときの処理
        binding.yusyokugoyakuClick.setOnClickListener(this);//夕食後薬ボタンがタップされたときの処理
        binding.kisyouziyakuClick.setOnClickListener(this);//起床時薬ボタンがタップされたときの処理
        binding.syusinngoyakuClick.setOnClickListener(this);//就寝薬ボタンがタップされたときの処理
        binding.tonpukuClick.setOnClickListener(this);//頓服ボタンがタップされたときの処理
    }

    public void onClick(View v) {
        if (v.getId() == R.id.tyosyokugoyaku_click) {
            Intent intent24 = new Intent(this, TyosyokugoyakuActivity.class);//朝食後薬
            startActivity(intent24);
        } else if (v.getId() == R.id.tyusyokugoyaku_click) {
            Intent intent25 = new Intent(this, TyusyokugoyakuActivity.class);//昼食後薬
            startActivity(intent25);
        } else if (v.getId() == R.id.yusyokugoyaku_click) {
            Intent intent26 = new Intent(this, YusyokugoyakuActivity.class);//夕食後薬
            startActivity(intent26);
        } else if (v.getId() == R.id.kisyouziyaku_click) {
            Intent intent27 = new Intent(this, KisyouziyakuActivity.class);//起床時薬
            startActivity(intent27);
        } else if (v.getId() == R.id.syusinngoyaku_click) {
            Intent intent28 = new Intent(this, SyusinngoyakuActivity.class);//就寝薬
            startActivity(intent28);
        } else if (v.getId() == R.id.tonpuku_click) {
            Intent intent29 = new Intent(this, TonpukuActivity.class);//頓服
            startActivity(intent29);
        }
    }
}