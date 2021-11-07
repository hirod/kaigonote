package com.websarva.wings.android.kaigonote;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import androidx.appcompat.app.AppCompatActivity;

import com.websarva.wings.android.kaigonote.databinding.MenuBinding;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private MenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MenuBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        binding.haisetuClick.setOnClickListener(this);//排泄ボタンがタップされたときの処理
        binding.syokujinsuiClick.setOnClickListener(this);//食事ボタンがタップされたときの処理
        binding.koukuClick.setOnClickListener(this);//口腔ボタンがタップされたときの処理
        binding.nyuyokuClick.setOnClickListener(this);//入浴ボタンがタップされたときの処理
        binding.kirokuClick.setOnClickListener(this);//記録ボタンがタップされたときの処理
        binding.acsidentoClick.setOnClickListener(this);//アクシデントボタンがタップされたときの処理
        binding.syotiClick.setOnClickListener(this);//処置ボタンがタップされたときの処理
        binding.haiyakuClick.setOnClickListener(this);//配薬ボタンがタップされたときの処理
        binding.kirokuitirannClick.setOnClickListener(this);//記録一覧ボタンがタップされたときの処理
        
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.haisetu_click) {
            Intent intent = new Intent(this, HaisetuActivity.class);//排泄メニュー
            startActivity(intent);
        } else if (v.getId() == R.id.syokujinsui_click) {
            Intent intent2 = new Intent(this, SyokujiActivity.class);//食事メニュー
            startActivity(intent2);
        } else if (v.getId() == R.id.kouku_click) {
            Intent intent3 = new Intent(this, KoukuActivity.class);//口腔メニュー
            startActivity(intent3);
        } else if (v.getId() == R.id.nyuyoku_click) {
            Intent intent4 = new Intent(this, NyuyokuActivity.class);//入浴メニュー
            startActivity(intent4);
        } else if (v.getId() == R.id.kiroku_click) {
            Intent intent5 = new Intent(this, KirokuActivity.class);//記録メニュー
            startActivity(intent5);
        } else if (v.getId() == R.id.acsidento_click) {
            Intent intent6 = new Intent(this, AcsidentoActivity.class);//アクシデントメニュー
            startActivity(intent6);
        } else if (v.getId() == R.id.syoti_click) {
            Intent intent7 = new Intent(this, SyotiActivity.class);//処置メニュー
            startActivity(intent7);
        } else if (v.getId() == R.id.haiyaku_click) {
            Intent intent8 = new Intent(this, HaiyakuActivity.class);//配薬メニュー
            startActivity(intent8);
        } else if (v.getId() == R.id.kirokuitirann_click) {
            Intent intent9 = new Intent(this, KirokuitirannActivity.class);//記録一覧メニュー
            startActivity(intent9);
        }
    }
}

