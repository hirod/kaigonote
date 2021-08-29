package com.websarva.wings.android.kaigonote;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.os.Bundle;

public class MainActivity7 extends AppCompatActivity implements OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        findViewById(R.id.bt_click22).setOnClickListener(this);//ヒヤリハットボタンがタップされたときの処理
        findViewById(R.id.bt_click23).setOnClickListener(this);//事故報告ボタンがタップされたときの処理
    }
    public void onClick(View v) {
        if (v.getId() == R.id.bt_click22) {
            Intent intent22 = new Intent(this, MainActivity7_1.class);//ヒヤリハット
            startActivity(intent22);
        } else if (v.getId() == R.id.bt_click23) {
            Intent intent23 = new Intent(this, MainActivity7_2.class);//事故報告
            startActivity(intent23);
        }
    }
}