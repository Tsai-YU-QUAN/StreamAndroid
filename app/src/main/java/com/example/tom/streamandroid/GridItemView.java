package com.example.tom.streamandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;


public class GridItemView extends FrameLayout {

    private TextView textView;

    public GridItemView(Context context) {  //編排照片程式
        super(context);
        LayoutInflater.from(context).inflate(R.layout.item_grid, this);
        textView = (TextView) getRootView().findViewById(R.id.text);
    }

    public void display(String text, boolean isSelected) { //編排照片程式-呈現文字與照片
        textView.setText(text);
        display(isSelected,text);
    }

    public void display(boolean isSelected,String mypictureName) { //彩色與黑白之間切換程式
        if(mypictureName.equals("遊戲")){ //EX: game(彩色); game_gray(黑白)
            textView.setBackgroundResource(isSelected ? R.drawable.game : R.drawable.game_gray);
        }
        else if (mypictureName.equals("美食"))
        {
            textView.setBackgroundResource(isSelected ? R.drawable.food : R.drawable.food_gray);
        }
        else if (mypictureName.equals("旅遊"))
        {
            textView.setBackgroundResource(isSelected ? R.drawable.m : R.drawable.m_gray);
        }
        else if (mypictureName.equals("新聞"))
        {
            textView.setBackgroundResource(isSelected ? R.drawable.news : R.drawable.news_gray);
        }
        else if (mypictureName.equals("體育"))
        {
            textView.setBackgroundResource(isSelected ? R.drawable.g : R.drawable.g_gray);
        }
        else if (mypictureName.equals("活動"))
        {
            textView.setBackgroundResource(isSelected ? R.drawable.c : R.drawable.c_gray);
        }
        else if (mypictureName.equals("叫賣"))
        {
            textView.setBackgroundResource(isSelected ? R.drawable.l : R.drawable.l_gray);
        }
        else{
            textView.setBackgroundResource(isSelected ? R.drawable.green_square : R.drawable.gray_square);
        }
    }


}