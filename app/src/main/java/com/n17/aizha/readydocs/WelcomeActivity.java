package com.n17.aizha.readydocs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {
    TextView ru_tv;
    TextView kz_tv;
    TextView welcome_tv;
    TextView welcome_title;
    Button startButton;
    String extra_ln = "ru";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ru_tv = (TextView) findViewById(R.id.ru_tv);
        kz_tv = (TextView) findViewById(R.id.kz_tv);
        welcome_title = (TextView) findViewById(R.id.welcome_title);
        welcome_tv = (TextView) findViewById(R.id.welcome_tv);
        startButton = (Button) findViewById(R.id.button_start);


        ru_tv.setBackgroundResource(R.drawable.rectangle);
    }
    public void ToKz(View view){
        ru_tv.setBackgroundResource(R.drawable.invisible);
        kz_tv.setBackgroundResource(R.drawable.rectangle);
        welcome_title.setText("ReadyDocs-қа қош келдіңіз!");
        welcome_tv.setText("Кез-келген мемлекеттік қызметке жүгінерде құжаттарыңызды алдын-ала түгендеуде нағыз таптырмас көмекші! Іздеуде мекемелерге байланысты жіктелген топтарға басыңыз немесе іздеу өрісіне қажетті сөзді жазып бастаңыз");
        startButton.setText("Іздейік!");
        extra_ln = "kz";


    }
    public void ToRu(View view){
        kz_tv.setBackgroundResource(R.drawable.invisible);
        ru_tv.setBackgroundResource(R.drawable.rectangle);
        welcome_title.setText(R.string.welcom_title);
        welcome_tv.setText(R.string.welcome_tv);
        startButton.setText(R.string.start_tv);
        extra_ln = "ru";
    }
    public void StartNewPage(View view){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("language", extra_ln);
        startActivity(intent);

    }

}
