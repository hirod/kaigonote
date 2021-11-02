package com.websarva.wings.android.kaigonote;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.websarva.wings.android.kaigonote.databinding.MosiokuriBinding;

public class MosiokuriActivity extends AppCompatActivity {
    private MosiokuriBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MosiokuriBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }
}