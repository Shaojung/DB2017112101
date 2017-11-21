package com.example.student.db2017112101;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> mylist;
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


    }
}
