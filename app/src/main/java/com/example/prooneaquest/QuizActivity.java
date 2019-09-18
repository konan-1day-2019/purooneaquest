package com.example.prooneaquest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.CaseMap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener{
    int prob = 1;
    int all_prob=5;
    int ans_number[]=new int [5];
    int button_number=0;
    int i=0;
    String[] senten = new String[5];
    String[][] choise = new String[5][4];

    TextView Sentence;
    Button[] ansButton = new Button[4];
    TextView prob_number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //選択肢の変数宣言
        ansButton[0] = (Button) findViewById(R.id.button1);
        ansButton[1] = (Button) findViewById(R.id.button2);
        ansButton[2] = (Button) findViewById(R.id.button3);
        ansButton[3] = (Button) findViewById(R.id.button4);

        ansButton[0].setOnClickListener(this);
        ansButton[1].setOnClickListener(this);
        ansButton[2].setOnClickListener(this);
        ansButton[3].setOnClickListener(this);

        //左上の問題数の表記
        prob_number = (TextView) findViewById(R.id.Prob_number);
        prob_number.setText(prob + "/" + all_prob);

        try {
            InputStream is = this.getAssets().open("Level1.txt");
            InputStreamReader isr = new InputStreamReader(is);

            BufferedReader bufferedReader = new BufferedReader(isr);
            String data;
            int j=0;
            while ((data = bufferedReader.readLine()) != null) {
                StringBuilder sb = new StringBuilder();
                while(!(data = bufferedReader.readLine()).equals("x")) {
                    sb.append(data);
                    sb.append(System.getProperty("line.separator"));
                }
                senten[j] = sb.toString();
                choise[j][0]=bufferedReader.readLine();
                choise[j][1]=bufferedReader.readLine();
                choise[j][2]=bufferedReader.readLine();
                choise[j][3]=bufferedReader.readLine();
                String temp = bufferedReader.readLine();
                System.out.println(temp);
                ans_number[j] = Integer.parseInt(temp.substring(0, 1));
                System.out.println(ans_number[i]);
                j++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //問題文
        Sentence = (TextView) findViewById(R.id.Problem);
        Sentence.setTextSize(20);
        Sentence.setText(senten[i]);
        ansButton[0].setText("1." + choise[i][0]);
        ansButton[1].setText("2." + choise[i][1]);
        ansButton[2].setText("3." + choise[i][2]);
        ansButton[3].setText("4." + choise[i][3]);
    }
        //選択肢の操作
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                button_number=1;
                break;

            case R.id.button2:
                button_number=2;
                break;

            case R.id.button3:
                button_number=3;
                break;

            case R.id.button4:
                button_number=4;
                break;
        }
        if(button_number==ans_number[i]) {
            Sentence.setText("正解！！");
            if(i>=4){
                Intent intent = new Intent(QuizActivity.this, LevelActivity.class);
                startActivity(intent);
            } else {
                Sentence.setText(senten[i]);
                i++;
                Sentence.setTextSize(20);
                Sentence.setText(senten[i]);
                ansButton[0].setText("1." + choise[i][0]);
                ansButton[1].setText("2." + choise[i][1]);
                ansButton[2].setText("3." + choise[i][2]);
                ansButton[3].setText("4." + choise[i][3]);
            }
            prob += 1;
            prob_number.setText(prob + "/" + all_prob);


        }else {
            Sentence.setText("不正解！！" + ans_number[i]);
            Intent intent = new Intent(QuizActivity.this, TitleActivity.class);
            startActivity(intent);

        }

    }



    //}
}