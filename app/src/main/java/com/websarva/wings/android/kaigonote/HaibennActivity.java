package com.websarva.wings.android.kaigonote;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.websarva.wings.android.kaigonote.databinding.HaibennBinding;

public class HaibennActivity extends AppCompatActivity {

    private HaibennBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = HaibennBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }
}