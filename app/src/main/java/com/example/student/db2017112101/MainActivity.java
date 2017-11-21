package com.example.student.db2017112101;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> mylist;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mylist = new ArrayList<>();
        String data[] = getResources().getStringArray(R.array.mydata);
        for (String s: data)
        {
            mylist.add(s);
        }
        lv = (ListView) findViewById(R.id.listView);
        MyAdapter adapter = new MyAdapter(this, mylist);
        lv.setAdapter(adapter);
    }
}
