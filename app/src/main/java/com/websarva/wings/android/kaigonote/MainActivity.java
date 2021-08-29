package com.websarva.wings.android.kaigonote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt_click).setOnClickListener(this);//排泄ボタンがタップされたときの処理
        findViewById(R.id.bt_click2).setOnClickListener(this);//食事ボタンがタップされたときの処理
        findViewById(R.id.bt_click3).setOnClickListener(this);//口腔ボタンがタップされたときの処理
        findViewById(R.id.bt_click4).setOnClickListener(this);//入浴ボタンがタップされたときの処理
        findViewById(R.id.bt_click5).setOnClickListener(this);//記録ボタンがタップされたときの処理
        findViewById(R.id.bt_click6).setOnClickListener(this);//アクシデントボタンがタップされたときの処理
        findViewById(R.id.bt_click7).setOnClickListener(this);//処置ボタンがタップされたときの処理
        findViewById(R.id.bt_click8).setOnClickListener(this);//配薬ボタンがタップされたときの処理
        findViewById(R.id.bt_click9).setOnClickListener(this);//記録一覧ボタンがタップされたときの処理

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt_click) {
            Intent intent = new Intent(this, MainActivity2.class);//排泄メニュー
            startActivity(intent);
        } else if (v.getId() == R.id.bt_click2) {
            Intent intent2 = new Intent(this, MainActivity3.class);//食事メニュー
            startActivity(intent2);
        } else if (v.getId() == R.id.bt_click3) {
            Intent intent3 = new Intent(this, MainActivity4.class);//口腔メニュー
            startActivity(intent3);
        } else if (v.getId() == R.id.bt_click4) {
            Intent intent4 = new Intent(this, MainActivity5.class);//入浴メニュー
            startActivity(intent4);
        } else if (v.getId() == R.id.bt_click5) {
            Intent intent5 = new Intent(this, MainActivity6.class);//記録メニュー
            startActivity(intent5);
        } else if (v.getId() == R.id.bt_click6) {
            Intent intent6 = new Intent(this, MainActivity7.class);//アクシデントメニュー
            startActivity(intent6);
        } else if (v.getId() == R.id.bt_click7) {
            Intent intent7 = new Intent(this, MainActivity8.class);//処置メニュー
            startActivity(intent7);
        } else if (v.getId() == R.id.bt_click8) {
            Intent intent8 = new Intent(this, MainActivity9.class);//配薬メニュー
            startActivity(intent8);
        } else if (v.getId() == R.id.bt_click9) {
            Intent intent9 = new Intent(this, MainActivity10.class);//記録一覧メニュー
            startActivity(intent9);
        }
    }
}

