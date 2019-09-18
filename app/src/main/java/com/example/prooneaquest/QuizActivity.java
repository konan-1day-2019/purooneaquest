package com.example.prooneaquest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener{
    int prob = 1;
    int all_prob=5;
    int ans_number=0;
    int button_number=0;
    int i=1;
    String senten = "問題文";

    public TextView Sentence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //選択肢の変数宣言
        Button[] ansButton = new Button[4];
        ansButton[0] = (Button) findViewById(R.id.button1);
        ansButton[1] = (Button) findViewById(R.id.button2);
        ansButton[2] = (Button) findViewById(R.id.button3);
        ansButton[3] = (Button) findViewById(R.id.button4);

        ansButton[0].setOnClickListener(this);
        ansButton[1].setOnClickListener(this);
        ansButton[2].setOnClickListener(this);
        ansButton[3].setOnClickListener(this);

        //左上の問題数の表記
        TextView prob_number = (TextView) findViewById(R.id.Prob_number);
        prob_number.setText(prob + "/" + all_prob);

        //問題文
        Sentence = (TextView) findViewById(R.id.Problem);
        Sentence.setText(senten);
    }
        //選択肢の操作
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                button_number=0;
                break;

            case R.id.button2:
                button_number=1;
                break;

            case R.id.button3:
                button_number=2;
                break;

            case R.id.button4:
                button_number=3;
                break;
        }
        if(button_number==ans_number) {
            Sentence.setText("正解！！");
            if(i>=5){
                Intent intent = new Intent(QuizActivity.this, LevelActivity.class);
                startActivity(intent);
            } else {
                senten = "問題" + (i + 1);
                Sentence.setText(senten);
                i++;
            }



        }else {
            Sentence.setText("不正解！！");


        }

    }



    //}
}