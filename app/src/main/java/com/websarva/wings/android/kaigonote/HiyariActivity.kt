package com.websarva.wings.android.kaigonote;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.websarva.wings.android.kaigonote.databinding.HiyariBinding;

public class HiyariActivity extends AppCompatActivity {
    private HiyariBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = HiyariBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }
}