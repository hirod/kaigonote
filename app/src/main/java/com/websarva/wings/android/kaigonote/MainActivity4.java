package com.websarva.wings.android.kaigonote;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity4 extends AppCompatActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        findViewById(R.id.bt_click16).setOnClickListener(this);//朝食 口腔ボタンがタップされたときの処理
        findViewById(R.id.bt_click17).setOnClickListener(this);//昼食 口腔ボタンがタップされたときの処理
        findViewById(R.id.bt_click18).setOnClickListener(this);//夕食 口腔ボタンがタップされたときの処理

    }

    public void onClick(View v) {
        if (v.getId() == R.id.bt_click16) {
            Intent intent16 = new Intent(this, MainActivity4_1.class);//朝食 口腔メニュー
            startActivity(intent16);
        } else if (v.getId() == R.id.bt_click17) {
            Intent intent17 = new Intent(this, MainActivity4_2.class);//昼食 口腔メニュー
            startActivity(intent17);
        } else if (v.getId() == R.id.bt_click18) {
            Intent intent18 = new Intent(this, MainActivity4_3.class);//夕食 口腔メニュー
            startActivity(intent18);
        }
    }
}