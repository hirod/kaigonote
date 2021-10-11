package com.websarva.wings.android.kaigonote;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class HaisetuActivity2 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);//画面切り替え
        findViewById(R.id.bt_click10).setOnClickListener(this);//排尿ボタンがタップされたときの処理
        findViewById(R.id.bt_click11).setOnClickListener(this);//排便ボタンがタップされたときの処理
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


