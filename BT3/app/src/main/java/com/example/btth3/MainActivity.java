package com.example.btth3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<Country> arrayList;
    CustomArrayAdapter customArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.listView);
        arrayList = new ArrayList<>();
        arrayList.add(new Country("Albani", "1000000", R.drawable.aruba));
        arrayList.add(new Country("Brazil", "9000000", R.drawable.brazil));
        arrayList.add(new Country("United State", "2000000", R.drawable.australia));
        arrayList.add(new Country("Viet Nam", "3000000", R.drawable.vietnam));
        arrayList.add(new Country("Japan", "4000000",R.drawable.china));
        arrayList.add(new Country("Russia", "4000000", R.drawable.czech_republic));
        customArrayAdapter = new CustomArrayAdapter(MainActivity.this, R.layout.list_view, arrayList);
        listView.setAdapter(customArrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, arrayList.get(position).toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}