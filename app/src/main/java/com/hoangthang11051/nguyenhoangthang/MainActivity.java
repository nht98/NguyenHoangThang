package com.hoangthang11051.nguyenhoangthang;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    Button btn_add, btn_view;
    EditText et_tenquocgia, et_nhietdo;
    adapter adapter;
    List<ItemThoitiet> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getViews();
        addListener();
        setUpList();
    }

    void getViews() {
        listView = findViewById(R.id.listiew);
        btn_add = findViewById(R.id.btn_add);
        btn_view = findViewById(R.id.btn_view);
        et_tenquocgia = findViewById(R.id.et_tenquocgia);
        et_nhietdo = findViewById(R.id.et_nhietdo);
    }

    void addListener() {
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_tenquocgia.getText().toString().isEmpty()) {
                    et_tenquocgia.setError("empty");
                    return;
                }
                if (et_nhietdo.getText().toString().isEmpty()) {
                    et_nhietdo.setError("empty");
                    return;
                }
                ItemThoitiet tt = new ItemThoitiet(et_tenquocgia.getText().toString(), Integer.parseInt(et_nhietdo.getText().toString()));
                items.add(tt);
                adapter.notifyDataSetChanged();
            }
        });

        btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String min = MinQuocgia();
                Intent it = new Intent(MainActivity.this, MainActivityLow.class);
                it.putExtra("min", min);
                startActivity(it);
            }
        });
    }

    void setUpList() {
        items = new ArrayList<>();
        items.add(new ItemThoitiet("Viet Nam", 15));
        items.add(new ItemThoitiet("Thai Lan", 31));
        items.add(new ItemThoitiet("Nhat ban", 22));
        items.add(new ItemThoitiet("Han quoc", 5));
        adapter = new adapter(this, R.layout.item_thoitiet, items);
        listView.setAdapter(adapter);
    }

    private String MinQuocgia() {
        ItemThoitiet itemThoitiet = items.get(0);
        for (int i = 1; i < items.size(); i++) {
            if (itemThoitiet.nhietdo > items.get(i).nhietdo) {
                itemThoitiet = items.get(i);
            }
        }
        return itemThoitiet.tenquocgia;
    }
}
