package com.example.hikeapp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button BTN1;
    private Button BTN2;
    private Button BTN3;
    private Button BTN4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.BTN1 = findViewById(R.id.button1);
        BTN1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent otherActivity = new Intent(getApplicationContext(), Accueil.class);
                otherActivity.putExtra("PAT_NAME", BTN1.getText());

                startActivity(otherActivity);

            }
        });

        this.BTN2 = findViewById(R.id.button2);
        BTN2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent otherActivity = new Intent(getApplicationContext(), Accueil.class);
                otherActivity.putExtra("PAT_NAME", BTN2.getText());
                startActivity(otherActivity);
            }
        });

        this.BTN3 = findViewById(R.id.button3);
        BTN3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent otherActivity = new Intent(getApplicationContext(), Accueil.class);
                otherActivity.putExtra("PAT_NAME", BTN3.getText());
                startActivity(otherActivity);
            }
        });

        this.BTN4 = findViewById(R.id.button4);
        BTN4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent otherActivity = new Intent(getApplicationContext(), Accueil.class);
                otherActivity.putExtra("PAT_NAME", BTN4.getText());
                startActivity(otherActivity);
            }
        });



    }

    @Override
    public void onBackPressed(){
        this.finish();
    }


}
