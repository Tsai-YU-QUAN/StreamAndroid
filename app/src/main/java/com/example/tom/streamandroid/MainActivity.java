package com.example.tom.streamandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private View btnGo;
    private ArrayList<String> selectedStrings;
    private static final String[] numbers = new String[]{
            "遊戲", "美食", "旅遊", "新聞", "體育", "活動", "叫賣", "", "", "", ""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = (GridView) findViewById(R.id.grid);
        btnGo = findViewById(R.id.button);

        selectedStrings = new ArrayList<>();  //收集好，傳到第二頁面

        final GridViewAdapter adapter = new GridViewAdapter(numbers, this); //滑動時，不停監控
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                int selectedIndex = adapter.selectedPositions.indexOf(position);
                if (selectedIndex > -1) {
                    adapter.selectedPositions.remove(selectedIndex);
                    ((GridItemView) v).display(false,(String) parent.getItemAtPosition(position));
                    selectedStrings.remove((String) parent.getItemAtPosition(position));
                } else { //被選擇喜好
                    adapter.selectedPositions.add(position);
                    ((GridItemView) v).display(true,(String) parent.getItemAtPosition(position));
                    selectedStrings.add((String) parent.getItemAtPosition(position));

                }
            }
        });

        //set listener for Button event
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SelectedItemsActivity.class);
                intent.putStringArrayListExtra("SELECTED_LETTER", selectedStrings); //string陣列值給SelectedItemsActivity.java
                startActivity(intent);
            }
        });
    }
}
