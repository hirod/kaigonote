package com.websarva.wings.android.kaigonote;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.websarva.wings.android.kaigonote.databinding.KirokuitirannBinding;

public class KirokuitirannActivity extends AppCompatActivity {
    private KirokuitirannBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = KirokuitirannBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }
}