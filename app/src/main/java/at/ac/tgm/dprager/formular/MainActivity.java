package at.ac.tgm.dprager.formular;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_TEXT = "at.ac.tgm.dprager.formular.EXTRS_TEXT";
    public static final String EXTRA_TEXT1 = "at.ac.tgm.dprager.formular.EXTRS_TEXT1";
    public static final String EXTRA_NUMBER = "at.ac.tgm.dprager.formular.EXTRS_NUMBER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button anmelden = (Button) findViewById(R.id.anmelden);
        Button abbrechen = (Button) findViewById(R.id.abbrechen);

        TextInputEditText name = findViewById(R.id.Name);
        TextInputEditText adresse = findViewById(R.id.Adresse);
        TextInputEditText geburtstag = findViewById(R.id.Geburtstag);


        anmelden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchScreen();
            }
        });

        abbrechen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.getText().clear();
                adresse.getText().clear();
                geburtstag.getText().clear();
            }
        });
    }


    public void switchScreen() {
        EditText name = (EditText) findViewById(R.id.Name);
        String text = name.getText().toString();

        EditText adresse = (EditText) findViewById(R.id.Adresse);
        String text2 = adresse.getText().toString();

        EditText datum = (EditText) findViewById(R.id.Geburtstag);
        int zahl = Integer.parseInt(datum.getText().toString());

        Intent intent = new Intent(this, Anzeige.class);
        intent.putExtra(EXTRA_TEXT, text);
        intent.putExtra(EXTRA_TEXT1, text2);
        intent.putExtra(EXTRA_NUMBER, zahl);

        startActivity(intent);
    }
}