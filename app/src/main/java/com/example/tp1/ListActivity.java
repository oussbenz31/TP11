package com.example.tp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {

    ListView myList ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        myList = (ListView) findViewById(R.id.listView);

        String names[]= {"amin","omar","adel","risk","ahmed","belyali"} ;

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);
        myList.setAdapter(myAdapter);
    }
}
