package com.example.prooneaquest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.logging.Level;

public class LaungageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laungage);
        Button nextButton = (Button)findViewById(R.id.button3);
        nextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(LaungageActivity.this, LevelActivity.class);
                startActivity(intent);
            }
        });
    }
}