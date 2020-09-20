package com.example.mybookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class BookDetails extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        textView=findViewById(R.id.answertext);
        String answertxt=getIntent().getStringExtra("answer");
        textView.setText(answertxt);
    }
}