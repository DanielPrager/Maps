package at.ac.tgm.dprager.formular;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_TEXT = "at.ac.tgm.dprager.formular.EXTRA_TEXT";
    public static final String EXTRA_TEXT1 = "at.ac.tgm.dprager.formular.EXTRA_TEXT1";
    public static final String EXTRA_NUMBER = "at.ac.tgm.dprager.formular.EXTRA_NUMBER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button anmelden = (Button) findViewById(R.id.anmelden);
        Button abbrechen = (Button) findViewById(R.id.abbrechen);

        TextInputLayout name = findViewById(R.id.Name);
        TextInputLayout adresse = findViewById(R.id.Adresse);
        TextInputLayout geburtstag = findViewById(R.id.Geburtstag);

        geburtstag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String datum=geburtstag.getEditText().getText().toString();
                if ( datum.length() != 10 || datum.charAt(2) != '.' || datum.charAt(5) != '.') {
                    geburtstag.setError("Falsches Format");

                } else {
                    geburtstag.setError(null);
                }
            }
        });



        anmelden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String datum=geburtstag.getEditText().getText().toString();
                if ( datum.length() != 10 || datum.charAt(2) != '.' || datum.charAt(5) != '.') {
                    geburtstag.setError("Falsches Format");

                } else {
                    geburtstag.setError(null);
                    switchScreen();
                }

            }
        });


        abbrechen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.getEditText().setText("");
                adresse.getEditText().setText("");
                geburtstag.getEditText().setText("");

            }
        });

    }


    public void switchScreen() {
        TextInputLayout name = (TextInputLayout) findViewById(R.id.Name);
        String text = name.getEditText().getText().toString();

        TextInputLayout adresse = (TextInputLayout) findViewById(R.id.Adresse);
        String text2 = adresse.getEditText().getText().toString();

        TextInputLayout datum = (TextInputLayout) findViewById(R.id.Geburtstag);

        String geburtsdatum=datum.getEditText().getText().toString();

        int zahl = Integer.parseInt(geburtsdatum.substring(0,2)+geburtsdatum.substring(3,5)+geburtsdatum.substring(6));

        Intent intent = new Intent(this, Anzeige.class);
        intent.putExtra(EXTRA_TEXT, text);
        intent.putExtra(EXTRA_TEXT1, text2);
        intent.putExtra(EXTRA_NUMBER, zahl);

        startActivity(intent);
    }


    public boolean fehlerSuche() {

        TextInputLayout geburtstag =(TextInputLayout) findViewById(R.id.Geburtstag);
        String datum=geburtstag.getEditText().getText().toString();
        if(datum.length()==9 && datum.charAt(2)=='.' && datum.charAt(5)=='.') {
            return true;
        }else {
            return false;
        }


    }



















}