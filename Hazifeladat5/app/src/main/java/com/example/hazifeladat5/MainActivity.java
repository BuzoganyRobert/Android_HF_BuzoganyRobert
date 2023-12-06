package com.example.hazifeladat5;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    String[] contextus = {"fekete", "zold", "narancs", "kek", "feher", "szurke", "lila", "sarga", "rozsaszin", "alga"};
    ListView myList;
    ArrayList<String> listItems = new ArrayList<>();
    CustomListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myList = findViewById(R.id.myList);
        listItems.addAll(Arrays.asList(contextus));
        adapter = new CustomListViewAdapter(this, listItems);
        myList.setAdapter(adapter);
        registerForContextMenu(myList);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.delete) {
            if (!listItems.isEmpty()) {
                listItems.remove(listItems.size() - 1);
                adapter.notifyDataSetChanged();
                return true;
            }

        } else if (id == R.id.sort_abc) {
            adapter.sortItems();
            return true;

        }
        return super.onOptionsItemSelected(item);

    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int position = info.position;

        if (position >= 0 && position < listItems.size()) {
            int itemId = item.getItemId();

            if (itemId == R.id.red) {
                adapter.changeItemColor(position, Color.RED);

                return true;
            } else if (itemId == R.id.green) {
                adapter.changeItemColor(position, Color.GREEN);
                return true;
            } else if (itemId == R.id.yellow) {
                adapter.changeItemColor(position, Color.YELLOW);
                return true;
            }
        }

        return super.onContextItemSelected(item);
    }
}

