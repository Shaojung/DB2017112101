package com.example.student.db2017112101;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.DataOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> mylist;
    ArrayList<String> mypics;
    ListView lv;
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mylist = new ArrayList<>();
        mypics = new ArrayList<>();
        String data[] = getResources().getStringArray(R.array.mydata);
        String pics[] = getResources().getStringArray(R.array.pics);
        for (String s: data)
        {
            mylist.add(s);
        }
        for (String s : pics)
        {
            mypics.add(s);
        }

        lv = (ListView) findViewById(R.id.listView);
        adapter = new MyAdapter(this, mylist, mypics);
        lv.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("SHOW");
        menu.add("ADD");
        menu.add("DELETE");
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
        if (item.getTitle().equals("ADD"))
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("新增資料");
            final EditText ed = new EditText(MainActivity.this);
            builder.setView(ed);
            builder.setPositiveButton("確定新增", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    mylist.add(ed.getText().toString());
                    adapter.chkArray = new boolean[mylist.size()];
                }
            });
            builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });

            builder.show();
        }
        if (item.getTitle().equals("DELETE"))
        {
            for (int i=mylist.size()-1;i>=0;i--)
            {
                Log.d("DEL", "i=" + i);
                if (adapter.chkArray[i])
                {
                    mylist.remove(i);
                }
                Log.d("DEL", "after i=" + i);
                Log.d("DEL", "after size=" + mylist.size());
            }
            adapter.chkArray = new boolean[mylist.size()];
            adapter.notifyDataSetChanged();
        }
        return super.onOptionsItemSelected(item);
    }
}
