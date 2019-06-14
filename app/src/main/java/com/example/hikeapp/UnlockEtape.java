package com.example.hikeapp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UnlockEtape extends AppCompatActivity {

    private TextView title;
    private EditText champ;
    private Button valider;

    private Etape etape;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unlock_etape);

        final DAO<Etape> etapeDao = DAOFactory.getEtapeDAO(this);

        etape = getIntent().getParcelableExtra("ETAPE");

        this.title = findViewById(R.id.textView);
        title.setText("Code de l'étape "+ etape.getNum());
        title.setTextSize(40);

        this.champ = findViewById(R.id.champText);

        this.valider = findViewById(R.id.button);
        valider.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String codeEnter=champ.getText().toString();
                if(codeEnter.length()>0){
                    if(etape.getCode().equals(codeEnter)){
                        etapeDao.update(etape);
                        Intent otherActivity = new Intent(getApplicationContext(), Accueil.class);
                        otherActivity.putExtra("PAT_NAME", etape.getPat());
                        startActivity(otherActivity);
                        toastMessage("Bravo tu a débloqué l'étape "+ etape.getNum());
                        finish();
                    }else{
                        toastMessage("Le code est invalide");
                    }
                }else{
                    toastMessage("Veuillez introduire le code");
                }
            }
        });


    }

    public void onBackPressed(){
        this.finish();
    }

    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
