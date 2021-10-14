package at.ac.tgm.dprager.list_view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List<Cocktail> image_details = getListData();
        final ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new CustomListAdapter(this, image_details));

        // When the user clicks on the ListItem
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = listView.getItemAtPosition(position);
                Cocktail country = (Cocktail) o;
                Toast.makeText(MainActivity.this, "Selected :" + " " + country, Toast.LENGTH_LONG).show();
            }
        });
    }

    private  List<Cocktail> getListData() {
        List<Cocktail> list = new ArrayList<Cocktail>();
        Cocktail mojito = new Cocktail("mojito", "Mojito", 15, 7);
        Cocktail pinaColada = new Cocktail("pinacolada", "Pina Cola", 20, 4);
        Cocktail sexOnTheBeach = new Cocktail("sexonthebeach", "Sex on the Beach", 17, 1);


        list.add(mojito);
        list.add(pinaColada);
        list.add(sexOnTheBeach);

        return list;
    }

}