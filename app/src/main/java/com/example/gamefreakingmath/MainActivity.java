package com.example.gamefreakingmath;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_play, btn_close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btn_play.setOnClickListener(this);
        btn_close.setOnClickListener(this);
    }

    private void init() {
        btn_play = findViewById(R.id.btn_play);
        btn_close = findViewById(R.id.btn_close);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_play:
                startActivity(new Intent(MainActivity.this, GameActivity.class));
                break;
            case R.id.btn_close:
                finish();
                break;
        }
    }
}