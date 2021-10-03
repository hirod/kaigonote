package com.websarva.wings.android.kaigonote;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.websarva.wings.android.kaigonote.databinding.ActivityHaisetuBinding;


public class HaisetuActivity extends AppCompatActivity {
    private int _kaigoId = -1;
    private String _kaigoName = "";
    private ActivityHaisetuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHaisetuBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        // ListView kaigo = findViewById(R.id.kaigo);
        // kaigo.setOnItemClickListener(new ListItemClickListner());
        binding.kaigo.setOnItemClickListener(new ListItemClickListner());

    }

    public void onSaveButtonClick(View view) {
        //名前を習得。
        EditText stmo = findViewById(R.id.stmo);
        stmo.setText("");
        //備考を習得。
        EditText stmo2 = findViewById(R.id.stmo2);
        stmo2.setText("");

        Button tv_name1 = findViewById(R.id.tv_name1);
        tv_name1.setEnabled(false);
    }


    private class ListItemClickListner implements android.widget.AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            _kaigoId = position;
            _kaigoName = (String) parent.getItemAtPosition(position);
            TextView tv_name = findViewById(R.id.tv_name);
            tv_name.setText(_kaigoName);
            Button tv_name1 = findViewById(R.id.tv_name1);
            tv_name1.setEnabled(true);

        }
    }
}