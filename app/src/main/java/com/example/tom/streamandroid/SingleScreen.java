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



public class SingleScreen  extends YouTubeBaseActivity{
    YouTubePlayerView mYouTubePlayerView;
    Button bt;
    YouTubePlayer.OnInitializedListener mOnInitializedListener;
    //初始化直播名稱
    String news1 ="民視",news2 ="中視",news3 ="華視",news4 ="東森";
    String game1 ="絕地求生",game2 ="阿神",game3 ="老皮",game4 ="GTA5";
    String sport1="JrNBA",sport2="NBA",sport3="MLB",sport4="中華職棒";
    String food1="這群人_美食";
    String strhell1="叫賣哥";
    String travel="劉沛_旅遊";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single);
        bt = (Button)findViewById(R.id.button);
        mYouTubePlayerView = (YouTubePlayerView)findViewById(R.id.youtubePlay);

        //Get SelectItemsActivity Data; EX: 中視,GTA5
        final String stringSelect = getIntent().getStringExtra("oneSelect");

        //當按鈕按下時，則會觸發剛剛選擇的節目，然後撥放
        mOnInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                //新聞
                if(news1.equals(stringSelect)){
                    youTubePlayer.loadVideo("XxJKnDLYZz4"); //民視
                }else if(news2.equals(stringSelect)){
                    youTubePlayer.loadVideo("XBne4oJGEhE"); //中視
                }else if(news3.equals(stringSelect)){
                    youTubePlayer.loadVideo("TL8mmew3jb8"); //華視
                }else if(news4.equals(stringSelect)){
                    youTubePlayer.loadVideo("dxpWqjvEKaM"); //東森
                }

                else if(game1.equals(stringSelect)){
                    youTubePlayer.loadVideo("LFpz0E5IrkA"); //絕地求生
                }
                else if(game2.equals(stringSelect)){
                    youTubePlayer.loadVideo("tjAtbS0R1ew"); //阿神
                }
                else if(game3.equals(stringSelect)){
                    youTubePlayer.loadVideo("_fz6-5l0j08"); //老皮
                }
                else if(game4.equals(stringSelect)){
                    youTubePlayer.loadVideo("AAUhmV3oosY"); //gta5
                }

                else if(sport1.equals(stringSelect)){
                    youTubePlayer.loadVideo("kKjurKaIZno"); //JrNBA
                }
                else if(sport2.equals(stringSelect)){
                    youTubePlayer.loadVideo("jNaTyHqIyaI"); //NBA
                }
                else if(sport3.equals(stringSelect)){
                    youTubePlayer.loadVideo("BkAKvonEJvI"); //MLB
                }
                else if(sport4.equals(stringSelect)){
                    youTubePlayer.loadVideo("hTM9CttpF5Y"); //中華職棒
                }

                else if(food1.equals(stringSelect)){
                    youTubePlayer.loadVideo("TUqObQCbU_g"); //這群人_美食
                }

                else if(strhell1.equals(stringSelect)){
                    youTubePlayer.loadVideo("dmOx0ltH2sk"); //叫賣哥
                }

                else if(travel.equals(stringSelect)){
                    youTubePlayer.loadVideo("ow9fDEC4yI0"); //劉沛_旅遊
                }

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                String errorMessage = youTubeInitializationResult.toString();
                Toast.makeText(SingleScreen.this, errorMessage, Toast.LENGTH_LONG).show();
                Log.d("errorMessage:", errorMessage);
            }
        };
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mYouTubePlayerView.initialize("AIzaSyCs4TtyzZ6Q9YPv44g8WjAbqLkfA0XL4xk",mOnInitializedListener);
            }
        });
    }
}
