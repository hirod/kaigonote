package com.websarva.wings.android.kaigonote;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.websarva.wings.android.kaigonote.databinding.HirukoukuBinding;

public class HirukoukuActivity extends AppCompatActivity {
    private HirukoukuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = HirukoukuBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }
}