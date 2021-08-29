package com.websarva.wings.android.kaigonote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        findViewById(R.id.bt_click12).setOnClickListener(this);//朝食ボタンタップされたときの処理
        findViewById(R.id.bt_click13).setOnClickListener(this);//昼食ボタンタップされたときの処理
        findViewById(R.id.bt_click14).setOnClickListener(this);//夕食ボタンタップされたときの処理
        findViewById(R.id.bt_click15).setOnClickListener(this);//間食ボタンタップされたときの処理

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt_click12) {
            Intent intent12 = new Intent(this, MainActivity3_1.class);//朝食記録
            startActivity(intent12);
        } else if (v.getId() == R.id.bt_click13) {
            Intent intent13 = new Intent(this, MainActivity3_2.class);//昼食記録
            startActivity(intent13);
        } else if (v.getId() == R.id.bt_click14) {
            Intent intent14 = new Intent(this, MainActivity3_3.class);//夕食記録
            startActivity(intent14);
        } else if (v.getId() == R.id.bt_click15) {
            Intent intent15 = new Intent(this, MainActivity3_4.class);//夕食記録
            startActivity(intent15);
        }

    }
}

