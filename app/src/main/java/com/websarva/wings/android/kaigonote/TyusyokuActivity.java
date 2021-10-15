package com.websarva.wings.android.kaigonote;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.websarva.wings.android.kaigonote.databinding.TyusyokuBinding;

public class TyusyokuActivity extends AppCompatActivity {
    private TyusyokuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = TyusyokuBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }
}