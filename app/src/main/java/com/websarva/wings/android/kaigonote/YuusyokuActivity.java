package com.websarva.wings.android.kaigonote;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.websarva.wings.android.kaigonote.databinding.YuusyokuBinding;

public class YuusyokuActivity extends AppCompatActivity {
    private YuusyokuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = YuusyokuBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }
}