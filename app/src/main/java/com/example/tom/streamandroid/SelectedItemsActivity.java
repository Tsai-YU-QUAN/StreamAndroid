package com.example.tom.streamandroid;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;



public class SelectedItemsActivity extends AppCompatActivity {

    private TextView textView;
    public List<String> stringArrayVideo = new ArrayList<String>();
    public List<String> strnews = new ArrayList<String>();
    public List<String> strgame = new ArrayList<String>();
    public List<String> strsport = new ArrayList<String>();
    public List<String> strtravel = new ArrayList<String>();
    public List<String> strstrhell = new ArrayList<String>();
    public List<String> strstract = new ArrayList<String>();
    public List<String> strfood = new ArrayList<String>();
    private Button btsure;
    private List<Integer> checked = new ArrayList<Integer>();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectitems);

        //第一步: 預設直播台
        strnews.add("民視");strnews.add("中視");strnews.add("華視");strnews.add("東森");
        strgame.add("絕地求生");strgame.add("阿神");strgame.add("老皮");strgame.add("GTA5");
        strsport.add("JrNBA");strsport.add("NBA");strsport.add("MLB");strsport.add("中華職棒");
        strfood.add("這群人_美食");;strstrhell.add("叫賣哥");strtravel.add("劉沛_旅遊");


        //第二步: 從MainActivity(探索直播)得到值，並且利用strnews,strgame,strsport組合stringArrayVideo
        getIntentData();

        //第三步: 呈現在ListView
        ListView listview = (ListView) findViewById(R.id.listview);
        //android.R.layout.simple_list_item_multiple_choice 使用多選
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_multiple_choice,
                stringArrayVideo.toArray());
        listview.setAdapter(adapter);
        listview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE); //可多選
        listview.setOnItemClickListener(onClickListView);       //指定事件 Method

        btsure =(Button)findViewById(R.id.btsure);
        btsure.setOnClickListener(new View.OnClickListener() { //按鈕會等待使用按下才會觸發
            @Override
            public void onClick(View view) {
                if(checked.size()>2){ //一個螢幕不能超過兩個直播
                    Toast.makeText(SelectedItemsActivity.this,"不能一個螢幕超過兩個直播畫面", Toast.LENGTH_SHORT).show();

                }else if(checked.size() == 2){ //雙畫面
                    String oneScreen = stringArrayVideo.get(checked.get(0))+","+stringArrayVideo.get(checked.get(1));
                    Intent intent = new Intent(SelectedItemsActivity.this, MultiScreen.class); //跳到SingleScreen
                    intent.putExtra("oneSelect", oneScreen); //EX: oneScreen值是 中視
                    startActivity(intent);
                    //Toast.makeText(SelectedItemsActivity.this,stringArrayVideo.get(checked.get(0))+" "+stringArrayVideo.get(checked.get(1)), Toast.LENGTH_SHORT).show();

                }else if(checked.size() == 1){ //只有一個畫面
                    String oneScreen = stringArrayVideo.get(checked.get(0));
                    Intent intent = new Intent(SelectedItemsActivity.this, SingleScreen.class); //跳到SingleScreen
                    intent.putExtra("oneSelect", oneScreen); //EX: oneScreen值是 中視
                    startActivity(intent);
                    //Toast.makeText(SelectedItemsActivity.this,stringArrayVideo.get(checked.get(0)), Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private AdapterView.OnItemClickListener onClickListView = new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //讀取多選Data，例如: GTA5,台視,中視
            AbsListView list = (AbsListView)parent;
            Adapter adapter = list.getAdapter();
            checked = new ArrayList<Integer>();

            SparseBooleanArray array = list.getCheckedItemPositions();
            for (int i = 0; i < array.size(); i++) {
                int key = array.keyAt(i);
                if (array.get(key)) {

                    checked.add(key);
                }
            }

        }
    };

    @SuppressLint("SetTextI18n")
    public void getIntentData() {
        ArrayList<String> stringArrayList = getIntent().getStringArrayListExtra("SELECTED_LETTER"); //從MainActivity得到值

        assert stringArrayList != null;
        if (stringArrayList.size() > 0) {
            for (int i = 0; i < stringArrayList.size(); i++) {
                if(stringArrayList.get(i).toString().equals("新聞")){
                    stringArrayVideo.addAll(strnews);   //add 所有的strnews
                }else  if(stringArrayList.get(i).toString().equals("遊戲")){
                    stringArrayVideo.addAll(strgame);   //add 所有的strgame
                }else  if(stringArrayList.get(i).toString().equals("體育")){
                    stringArrayVideo.addAll(strsport);  //add 所有的strsport
                }else  if(stringArrayList.get(i).toString().equals("美食")) {
                    stringArrayVideo.addAll(strfood);  //add 所有的strfood
                }else  if(stringArrayList.get(i).toString().equals("旅遊")){
                    stringArrayVideo.addAll(strtravel);  //add 所有的strtravel
                }else  if(stringArrayList.get(i).toString().equals("叫賣")){
                    stringArrayVideo.addAll(strstrhell);  //add 所有的strstrhel
                }
            }
        }
    }
}
