package com.example.tom.streamandroid;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;


public class MultiScreen extends YouTubeBaseActivity {

    YouTubePlayerView mYouTubePlayerView,mYouTubePlayerView2;
    Button bt,bt2;
    YouTubePlayer.OnInitializedListener mOnInitializedListener;
    YouTubePlayer.OnInitializedListener mOnInitializedListener2;

    private YouTubePlayer youTubePlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multiscreen);
        bt = (Button)findViewById(R.id.button);
        mYouTubePlayerView = (YouTubePlayerView)findViewById(R.id.youtubePlay);
        bt2 = (Button)findViewById(R.id.button2);
        mYouTubePlayerView2 = (YouTubePlayerView)findViewById(R.id.youtubePlay2);

        //Get SelectItemsActivity Data; EX: 中視,GTA5
        final String stringSelect = getIntent().getStringExtra("oneSelect");

        //當按鈕按下時，則會觸發剛剛選擇的節目，然後撥放
        mOnInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                //新聞
                if(stringSelect.substring(0,stringSelect.indexOf(",")).equals("民視")){
                    youTubePlayer.loadVideo("XxJKnDLYZz4"); //民視
                }else if(stringSelect.substring(0,stringSelect.indexOf(",")).equals("中視")){
                    youTubePlayer.loadVideo("XBne4oJGEhE"); //中視
                }else if(stringSelect.substring(0,stringSelect.indexOf(",")).equals("華視")){
                    youTubePlayer.loadVideo("TL8mmew3jb8"); //華視
                }else if(stringSelect.substring(0,stringSelect.indexOf(",")).equals("東森")){
                    youTubePlayer.loadVideo("dxpWqjvEKaM"); //東森
                }
                else if(stringSelect.substring(0,stringSelect.indexOf(",")).equals("絕地求生")){
                    youTubePlayer.loadVideo("LFpz0E5IrkA"); //絕地求生
                }
                else if(stringSelect.substring(0,stringSelect.indexOf(",")).equals("阿神")){
                    youTubePlayer.loadVideo("tjAtbS0R1ew"); //阿神
                }
                else if(stringSelect.substring(0,stringSelect.indexOf(",")).equals("老皮")){
                    youTubePlayer.loadVideo("_fz6-5l0j08"); //老皮
                }
                else if(stringSelect.substring(0,stringSelect.indexOf(",")).equals("gta5")){
                    youTubePlayer.loadVideo("AAUhmV3oosY"); //gta5
                }
                else if(stringSelect.substring(0,stringSelect.indexOf(",")).equals("JrNBA")){
                    youTubePlayer.loadVideo("kKjurKaIZno"); //JrNBA
                }
                else if(stringSelect.substring(0,stringSelect.indexOf(",")).equals("NBA")){
                    youTubePlayer.loadVideo("jNaTyHqIyaI"); //NBA
                }
                else if(stringSelect.substring(0,stringSelect.indexOf(",")).equals("MLB")){
                    youTubePlayer.loadVideo("BkAKvonEJvI"); //MLB
                }
                else if(stringSelect.substring(0,stringSelect.indexOf(",")).equals("中華職棒")){
                    youTubePlayer.loadVideo("hTM9CttpF5Y"); //中華職棒
                }
                else if(stringSelect.substring(0,stringSelect.indexOf(",")).equals("這群人_美食")){
                    youTubePlayer.loadVideo("TUqObQCbU_g"); //這群人_美食
                }
                else if(stringSelect.substring(0,stringSelect.indexOf(",")).equals("叫賣哥")){
                    youTubePlayer.loadVideo("dmOx0ltH2sk"); //叫賣哥
                }
                else if(stringSelect.substring(0,stringSelect.indexOf(",")).equals("劉沛_旅遊")){
                    youTubePlayer.loadVideo("ow9fDEC4yI0"); //劉沛_旅遊
                }

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                String errorMessage = youTubeInitializationResult.toString();
                Toast.makeText(MultiScreen.this, errorMessage, Toast.LENGTH_LONG).show();
                Log.d("errorMessage:", errorMessage);
            }
        };

        //當按鈕按下時，則會觸發剛剛選擇的節目，然後撥放
        mOnInitializedListener2 = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                //新聞
                if(stringSelect.substring(stringSelect.indexOf(",")+1).equals("民視")){
                    youTubePlayer.loadVideo("XxJKnDLYZz4"); //民視
                }else if(stringSelect.substring(stringSelect.indexOf(",")+1).equals("中視")){
                    youTubePlayer.loadVideo("XBne4oJGEhE"); //中視
                }else if(stringSelect.substring(stringSelect.indexOf(",")+1).equals("華視")){
                    youTubePlayer.loadVideo("TL8mmew3jb8"); //華視
                }else if(stringSelect.substring(stringSelect.indexOf(",")+1).equals("東森")){
                    youTubePlayer.loadVideo("dxpWqjvEKaM"); //東森
                }

                else if(stringSelect.substring(stringSelect.indexOf(",")+1).equals("絕地求生")){
                    youTubePlayer.loadVideo("LFpz0E5IrkA"); //絕地求生
                }
                else if(stringSelect.substring(stringSelect.indexOf(",")+1).equals("阿神")){
                    youTubePlayer.loadVideo("tjAtbS0R1ew"); //阿神
                }
                else if(stringSelect.substring(stringSelect.indexOf(",")+1).equals("老皮")){
                    youTubePlayer.loadVideo("_fz6-5l0j08"); //老皮
                }
                else if(stringSelect.substring(stringSelect.indexOf(",")+1).equals("gta5")){
                    youTubePlayer.loadVideo("AAUhmV3oosY"); //gta5
                }

                else if(stringSelect.substring(stringSelect.indexOf(",")+1).equals("JrNBA")){
                    youTubePlayer.loadVideo("kKjurKaIZno"); //JrNBA
                }
                else if(stringSelect.substring(stringSelect.indexOf(",")+1).equals("NBA")){
                    youTubePlayer.loadVideo("jNaTyHqIyaI"); //NBA
                }
                else if(stringSelect.substring(stringSelect.indexOf(",")+1).equals("MLB")){
                    youTubePlayer.loadVideo("BkAKvonEJvI"); //MLB
                }
                else if(stringSelect.substring(stringSelect.indexOf(",")+1).equals("中華職棒")){
                    youTubePlayer.loadVideo("hTM9CttpF5Y"); //中華職棒
                }

                else if(stringSelect.substring(stringSelect.indexOf(",")+1).equals("這群人_美食")){
                    youTubePlayer.loadVideo("TUqObQCbU_g"); //這群人_美食
                }

                else if(stringSelect.substring(stringSelect.indexOf(",")+1).equals("叫賣哥")){
                    youTubePlayer.loadVideo("dmOx0ltH2sk"); //叫賣哥
                }

                else if(stringSelect.substring(stringSelect.indexOf(",")+1).equals("劉沛_旅遊")){
                    youTubePlayer.loadVideo("ow9fDEC4yI0"); //劉沛_旅遊
                }


            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                String errorMessage = youTubeInitializationResult.toString();
                Toast.makeText(MultiScreen.this, errorMessage, Toast.LENGTH_LONG).show();
                Log.d("errorMessage:", errorMessage);
            }
        };
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mYouTubePlayerView.initialize("AIzaSyCs4TtyzZ6Q9YPv44g8WjAbqLkfA0XL4xk",mOnInitializedListener);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mYouTubePlayerView2.initialize("AIzaSyD9sOQENwudTzKk1orTwi2MN0LbKPDNXrc",mOnInitializedListener2);
            }
        });
    }
}
