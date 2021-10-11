package com.websarva.wings.android.kaigonote;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import androidx.appcompat.app.AppCompatActivity;

import com.websarva.wings.android.kaigonote.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        binding.btClick.setOnClickListener(this);//排泄ボタンがタップされたときの処理
        binding.btClick2.setOnClickListener(this);//食事ボタンがタップされたときの処理
        binding.btClick3.setOnClickListener(this);//口腔ボタンがタップされたときの処理
        binding.btClick4.setOnClickListener(this);//入浴ボタンがタップされたときの処理
        binding.btClick5.setOnClickListener(this);//記録ボタンがタップされたときの処理
        binding.btClick6.setOnClickListener(this);//アクシデントボタンがタップされたときの処理
        binding.btClick7.setOnClickListener(this);//処置ボタンがタップされたときの処理
        binding.btClick8.setOnClickListener(this);//配薬ボタンがタップされたときの処理
        binding.btClick9.setOnClickListener(this);//記録一覧ボタンがタップされたときの処理

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt_click) {
            Intent intent = new Intent(this, HaisetuActivity2.class);//排泄メニュー
            startActivity(intent);
        } else if (v.getId() == R.id.bt_click2) {
            Intent intent2 = new Intent(this, SyokujiActivity3.class);//食事メニュー
            startActivity(intent2);
        } else if (v.getId() == R.id.bt_click3) {
            Intent intent3 = new Intent(this, KoukuActivity4.class);//口腔メニュー
            startActivity(intent3);
        } else if (v.getId() == R.id.bt_click4) {
            Intent intent4 = new Intent(this, NyuyokuActivity5.class);//入浴メニュー
            startActivity(intent4);
        } else if (v.getId() == R.id.bt_click5) {
            Intent intent5 = new Intent(this, KirokuActivity6.class);//記録メニュー
            startActivity(intent5);
        } else if (v.getId() == R.id.bt_click6) {
            Intent intent6 = new Intent(this, AcsidentoActivity7.class);//アクシデントメニュー
            startActivity(intent6);
        } else if (v.getId() == R.id.bt_click7) {
            Intent intent7 = new Intent(this, SyotiActivity8.class);//処置メニュー
            startActivity(intent7);
        } else if (v.getId() == R.id.bt_click8) {
            Intent intent8 = new Intent(this, HaiyakuActivity9.class);//配薬メニュー
            startActivity(intent8);
        } else if (v.getId() == R.id.bt_click9) {
            Intent intent9 = new Intent(this, KirokuitirannActivity10.class);//記録一覧メニュー
            startActivity(intent9);
        }
    }
}

