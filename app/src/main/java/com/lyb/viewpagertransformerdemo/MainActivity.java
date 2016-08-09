package com.lyb.viewpagertransformerdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private List<String> itemList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.page_transformer_list);

        itemList = new ArrayList<>();
        Collections.addAll(itemList, DepthActivity.class.getSimpleName(),
                RotateDownActivity.class.getSimpleName(), ZoomOutActivity.class.getSimpleName());

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemList);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, i == 0 ? DepthActivity.class
                        : (i == 1 ? RotateDownActivity.class : ZoomOutActivity.class));
                startActivity(intent);
            }
        });
    }

}
