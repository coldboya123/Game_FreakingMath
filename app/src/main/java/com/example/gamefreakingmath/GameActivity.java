package com.example.gamefreakingmath;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txt_score, txt_cal, dia_score;
    ImageButton btn_true, btn_false, btn_close;
    Random random;
    int a, b, c, score = 0;
    Dialog dialog;
    Button btn_back, btn_playagain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        init();

        random = new Random();
        GenerateRandom();

        btn_true.setOnClickListener(this);
        btn_false.setOnClickListener(this);
        btn_close.setOnClickListener(this);

        btn_back.setOnClickListener(this);
        btn_playagain.setOnClickListener(this);
    }

    private void init() {
        txt_score = findViewById(R.id.score);
        txt_cal = findViewById(R.id.calculate);
        btn_close = findViewById(R.id.btn_close);
        btn_true = findViewById(R.id.btn_true);
        btn_false = findViewById(R.id.btn_false);
        dialog = new Dialog(GameActivity.this);
        dialog.setContentView(R.layout.custom_dialog);
        dialog.setCanceledOnTouchOutside(false);
        btn_back = dialog.findViewById(R.id.btn_back);
        btn_playagain = dialog.findViewById(R.id.btn_playagain);
        dia_score = dialog.findViewById(R.id.content);
    }

    @SuppressLint("SetTextI18n")
    private void GenerateRandom() {
        a = random.nextInt(10);
        b = random.nextInt(10);
        c = random.nextInt((a + b) - (a + b - 1) + 1) + (a + b); // max = a+b, min = a+b-1
        txt_cal.setText(a + " + " + b + " = " + c);
    }

    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_close:
                finish();
                break;
            case R.id.btn_true:
                if ((a + b) == c) {
                    score++;
                    txt_score.setText(score + "");
                    GenerateRandom();
                } else {
                    dia_score.setText("Your score: " + score);
                    dialog.show();
                }
                break;
            case R.id.btn_false:
                if ((a + b) != c) {
                    score++;
                    txt_score.setText(score + "");
                    GenerateRandom();
                } else {
                    dia_score.setText("Your score: " + score);
                    dialog.show();
                }
                break;
            case R.id.btn_back:
                dialog.hide();
                finish();
                break;
            case R.id.btn_playagain:
                dialog.hide();
                txt_score.setText(0 + "");
                score = 0;
                GenerateRandom();
                break;
        }
    }
}