package com.websarva.wings.android.kaigonote;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.os.Bundle;

public class MainActivity6 extends AppCompatActivity  implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        findViewById(R.id.bt_click19).setOnClickListener(this);//日常記録ボタンがタップされたときの処理
        findViewById(R.id.bt_click20).setOnClickListener(this);//入浴記録ボタンがタップされたときの処理
        findViewById(R.id.bt_click21).setOnClickListener(this);//申し送りボタンがタップされたときの処理

    }

    public void onClick(View v) {
        if (v.getId() == R.id.bt_click19) {
            Intent intent19 = new Intent(this, MainActivity6_1.class);//日常記録
            startActivity(intent19);
        } else if (v.getId() == R.id.bt_click20) {
            Intent intent20 = new Intent(this, MainActivity6_2.class);//入浴記録
            startActivity(intent20);
        } else if (v.getId() == R.id.bt_click21) {
            Intent intent21 = new Intent(this, MainActivity6_3.class);//申し送り
            startActivity(intent21);
        }
    }
}