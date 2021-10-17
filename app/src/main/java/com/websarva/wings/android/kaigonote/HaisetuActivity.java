package com.websarva.wings.android.kaigonote;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.websarva.wings.android.kaigonote.databinding.HaisetuBinding;

public class HaisetuActivity extends AppCompatActivity implements View.OnClickListener {
    private HaisetuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = HaisetuBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);//画面切り替え
        binding.hainyouClick.setOnClickListener(this);//排尿ボタンがタップされたときの処理
        binding.haibennClick.setOnClickListener(this);//排便ボタンがタップされたときの処理
    }

    public void onClick(View v) {
        if (v.getId() == R.id.hainyou_click) {
            Intent intent10 = new Intent(this, HainyouActivity.class);//排尿メニュー
            startActivity(intent10);
        } else if (v.getId() == R.id.haibenn_click) {
            Intent intent11 = new Intent(this, HaibennActivity.class);//排便メニュー
            startActivity(intent11);
        }
    }
}


