package com.example.hikeapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.github.chrisbanes.photoview.PhotoView;


public class Carte extends AppCompatActivity {

    private Etape etape;

    private PhotoView image ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carte);

        etape = getIntent().getParcelableExtra("ETAPE");

        this.image = findViewById(R.id.photo_view);

        System.out.println("----------------------------------------------------------------------------------");
        System.out.println(etape.getImage());
        System.out.println("----------------------------------------------------------------------------------");

        int id = this.getResources().getIdentifier(etape.getImage(), "drawable", this.getPackageName());
        image.setImageResource(id);

    }
}
