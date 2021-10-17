package com.websarva.wings.android.kaigonote;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.websarva.wings.android.kaigonote.databinding.ZikoBinding;

public class ZikoActivity extends AppCompatActivity {
    private ZikoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ZikoBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }
}