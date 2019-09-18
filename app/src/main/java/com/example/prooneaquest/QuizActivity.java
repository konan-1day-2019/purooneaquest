package com.example.prooneaquest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {
    int prob = 1;
    int all_prob=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //選択肢の変数宣言
        Button ansButton1 = (Button) findViewById(R. id. button1);
        Button ansButton2 = (Button) findViewById(R. id.button2);
        Button ansButton3 = (Button) findViewById(R. id.button3);
        Button ansButton4 = (Button) findViewById(R. id. button4);
        //左上の問題数の表記
        TextView prob_number = (TextView) findViewById(R. id. Prob_number);
        prob_number.setText(prob + "/" + all_prob);

    }
}