package com.example.juet.finalproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class DetailActivity extends AppCompatActivity {
    private TextView tvDate = null;
    private ListView lvDetail = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        tvDate = (TextView)findViewById(R.id.tvDate);
        lvDetail = (ListView)findViewById(R.id.lvToDo);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            String date = extras.getString("Date");
            tvDate.setText("TODO list for " + date);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_layout_item, R.id.tvItem);
        adapter.add("SAT prep");
        adapter.add("AP Physics prep");
        adapter.add("Spanish practice");
        adapter.add("Run 30min");

        lvDetail.setAdapter(adapter);
    }
}
