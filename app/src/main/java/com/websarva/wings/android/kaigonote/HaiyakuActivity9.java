package com.websarva.wings.android.kaigonote;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import androidx.appcompat.app.AppCompatActivity;

public class HaiyakuActivity9 extends AppCompatActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);
        findViewById(R.id.bt_click24).setOnClickListener(this);//朝食後薬ボタンがタップされたときの処理
        findViewById(R.id.bt_click25).setOnClickListener(this);//昼食後薬ボタンがタップされたときの処理
        findViewById(R.id.bt_click26).setOnClickListener(this);//夕食後薬ボタンがタップされたときの処理
        findViewById(R.id.bt_click27).setOnClickListener(this);//起床時薬ボタンがタップされたときの処理
        findViewById(R.id.bt_click28).setOnClickListener(this);//就寝薬ボタンがタップされたときの処理
        findViewById(R.id.bt_click29).setOnClickListener(this);//頓服ボタンがタップされたときの処理
    }

    public void onClick(View v) {
        if (v.getId() == R.id.bt_click24) {
            Intent intent24 = new Intent(this, MainActivity9_1.class);//朝食後薬
            startActivity(intent24);
        } else if (v.getId() == R.id.bt_click25) {
            Intent intent25 = new Intent(this, MainActivity9_2.class);//昼食後薬
            startActivity(intent25);
        } else if (v.getId() == R.id.bt_click26) {
            Intent intent26 = new Intent(this, MainActivity9_3.class);//夕食後薬
            startActivity(intent26);
        } else if (v.getId() == R.id.bt_click27) {
            Intent intent27 = new Intent(this, MainActivity9_4.class);//起床時薬
            startActivity(intent27);
        } else if (v.getId() == R.id.bt_click28) {
            Intent intent28 = new Intent(this, MainActivity9_5.class);//就寝薬
            startActivity(intent28);
        } else if (v.getId() == R.id.bt_click29) {
            Intent intent29 = new Intent(this, MainActivity9_6.class);//頓服
            startActivity(intent29);
        }
    }
}