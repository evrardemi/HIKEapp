package com.example.hikeapp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Accueil extends AppCompatActivity {

    private String PatName;
    private TextView Title;

    private TextView count;
    int compte = 0;
    private Button bout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        PatName = getIntent().getStringExtra("PAT_NAME");

        this.Title = findViewById(R.id.textView1);
        Title.setText(PatName);
        Title.setTextSize(40);
        Title.setGravity(Gravity.CENTER_HORIZONTAL);

        //Liste déroulante
        DAO<Etape> etapeDao = DAOFactory.getEtapeDAO(this);

        LinearLayout boiteEtape = (LinearLayout) findViewById(R.id.LinearLayoutView);

        Etape etape = etapeDao.find(PatName,1);
        for(int i=2; etape !=null; i++) {
            LinearLayout ligne = new LinearLayout(this);
            ligne.setLayoutParams(new LinearLayout.LayoutParams
                    (LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            ligne.setHorizontalGravity(Gravity.CENTER_VERTICAL);
            ligne.setPadding(10,10,10,10);
            ligne.setHorizontalGravity(Gravity.CENTER_HORIZONTAL);

            DisplayMetrics dm = new DisplayMetrics();
            this.getWindow().getWindowManager().getDefaultDisplay().getMetrics(dm);

            final Etape eta = etape;


            Button boutonEtape = new Button(this);
            boutonEtape.setText("Etape "+etape.getNum());
            boutonEtape.setWidth(1000);
            boutonEtape.setHeight(200);
            boutonEtape.setTextSize(18);
            if(eta.getStatus()==1){
                boutonEtape.setBackgroundColor(0xFF007000);
            }
            boutonEtape.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Intent otherActivity;
                    if(eta.getStatus()==0){
                        otherActivity = new Intent(getApplicationContext(), UnlockEtape.class);
                    }else{
                        otherActivity = new Intent(getApplicationContext(), Carte.class);
                    }
                    otherActivity.putExtra("ETAPE", eta);
                    startActivity(otherActivity);
                }
            });
            ligne.addView(boutonEtape);

            boiteEtape.addView(ligne);
            etape = etapeDao.find(PatName,i);
        }


    }

    @Override
    public void onBackPressed(){
//        Intent otherActivity = new Intent(getApplicationContext(), MainActivity.class);
//        startActivity(otherActivity);
        this.finish();
    }
}
