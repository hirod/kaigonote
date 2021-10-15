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
        binding.btClick24.setOnClickListener(this);//朝食後薬ボタンがタップされたときの処理
        binding.btClick25.setOnClickListener(this);//昼食後薬ボタンがタップされたときの処理
        binding.btClick26.setOnClickListener(this);//夕食後薬ボタンがタップされたときの処理
        binding.btClick27.setOnClickListener(this);//起床時薬ボタンがタップされたときの処理
        binding.btClick28.setOnClickListener(this);//就寝薬ボタンがタップされたときの処理
        binding.btClick29.setOnClickListener(this);//頓服ボタンがタップされたときの処理
    }

    public void onClick(View v) {
        if (v.getId() == R.id.bt_click24) {
            Intent intent24 = new Intent(this, TyosyokugoyakuActivity9_1.class);//朝食後薬
            startActivity(intent24);
        } else if (v.getId() == R.id.bt_click25) {
            Intent intent25 = new Intent(this, TyusyokugoyakuActivity9_2.class);//昼食後薬
            startActivity(intent25);
        } else if (v.getId() == R.id.bt_click26) {
            Intent intent26 = new Intent(this, YusyokugoyakuActivity9_3.class);//夕食後薬
            startActivity(intent26);
        } else if (v.getId() == R.id.bt_click27) {
            Intent intent27 = new Intent(this, KisyouziyakuActivity9_4.class);//起床時薬
            startActivity(intent27);
        } else if (v.getId() == R.id.bt_click28) {
            Intent intent28 = new Intent(this, SyusinngoyakuActivity9_5.class);//就寝薬
            startActivity(intent28);
        } else if (v.getId() == R.id.bt_click29) {
            Intent intent29 = new Intent(this, TonpukuActivity9_6.class);//頓服
            startActivity(intent29);
        }
    }
}