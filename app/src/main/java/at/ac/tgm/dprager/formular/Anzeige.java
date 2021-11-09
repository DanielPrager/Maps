package at.ac.tgm.dprager.formular;

import android.content.Intent;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Anzeige extends AppCompatActivity {
    private TextView name2;
    private TextView adresse2;
    private TextView datum2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anzeige);

        Intent intent = getIntent();
        String text = intent.getStringExtra(MainActivity.EXTRA_TEXT);
        String text1 = intent.getStringExtra(MainActivity.EXTRA_TEXT1);
        int zahl = intent.getIntExtra(MainActivity.EXTRA_NUMBER, 0);

        TextView textView = (TextView) findViewById(R.id.nameText);
        TextView textView1 = (TextView) findViewById(R.id.adresseText);
        TextView textView3 = (TextView) findViewById(R.id.geburtstdatumText);

        textView.setText(text);
        textView1.setText(text1);
        textView3.setText("" + zahl);
    }
}