package com.example.student.db2017112101;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.io.DataOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> mylist;
    ListView lv;
    MyAdapter adapter;
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
        adapter = new MyAdapter(this, mylist);
        lv.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("SHOW");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getTitle().equals("SHOW"))
        {
            StringBuilder sb = new StringBuilder();
            for (int i=0;i<mylist.size();i++)
            {
                if (adapter.chkArray[i])
                {
                    sb.append(mylist.get(i));
                    sb.append(",");
                }
            }
            Toast.makeText(MainActivity.this, sb.toString(), Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
