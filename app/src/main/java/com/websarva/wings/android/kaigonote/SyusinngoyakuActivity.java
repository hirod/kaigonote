package com.websarva.wings.android.kaigonote;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.websarva.wings.android.kaigonote.databinding.SyusinngoyakuBinding;

public class SyusinngoyakuActivity extends AppCompatActivity {
    private SyusinngoyakuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = SyusinngoyakuBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }
}