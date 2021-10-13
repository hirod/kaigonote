package com.websarva.wings.android.kaigonote;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.websarva.wings.android.kaigonote.databinding.ActivityMain2Binding;

public class HaisetuActivity2 extends AppCompatActivity implements View.OnClickListener {
    private ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);//画面切り替え
        binding.btClick10.setOnClickListener(this);//排尿ボタンがタップされたときの処理
        binding.btClick11.setOnClickListener(this);//排便ボタンがタップされたときの処理
    }

    public void onClick(View v) {
        if (v.getId() == R.id.bt_click10) {
            Intent intent10 = new Intent(this, HainyouActivity.class);//排尿メニュー
            startActivity(intent10);
        } else if (v.getId() == R.id.bt_click11) {
            Intent intent11 = new Intent(this, HaibennActivity2_2.class);//排便メニュー
            startActivity(intent11);
        }
    }
}


