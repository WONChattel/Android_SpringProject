package com.example.RecipeSearch;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;


//Menu1Activity 의 검색결과로 만들어진 아이템 클릭시 ItemActivity로  이동하는데 여기서 Recipe 인텐트로 받는데
//Recipe의 이름, 재료는 바로 받아서 텍스트뷰에 보여주고 나머지 메뉴얼은 리사이클러뷰로 화면 구현

public class ItemActivity extends AppCompatActivity {
    VideoView videoView;


    static final String VIDEO_URL = "https://www.youtube.com/embed/CS2s_N37qjM";

    Recipe recipe;
    TextView textView1;
    TextView textView2;
    RecyclerView recyclerView;
    RecyclerAdpter2 adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        Intent intent = getIntent();
        recipe = intent.getParcelableExtra("recipe");

        Log.d("받았나",recipe.toString());
        videoView = findViewById(R.id.videoView);
        MediaController mc = new MediaController(this);
        videoView.setMediaController(mc);
        videoView.setVideoURI(Uri.parse(VIDEO_URL));

        recyclerView= findViewById(R.id.recyclerView3);
       // adapter2.
        textView1 =findViewById(R.id.item1_act3);
        textView2 =findViewById(R.id.item2_act3);

        textView1.setText(recipe.getRCP_NM());


        adapter2 = new RecyclerAdpter2(recipe);

        recyclerView.setAdapter(adapter2);
        adapter2.notifyDataSetChanged();


    }
    public void setVolume(View view) {
        AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, maxVolume, AudioManager.FLAG_SHOW_UI);


    }


    public void magnify(View view) {


        AlertDialog.Builder adb = new AlertDialog.Builder(ItemActivity.this);
        adb.setTitle("재료").setMessage(recipe.getRCP_PARTS_DTLS());

        Dialog dialog = adb.create();

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = 1500;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;

        dialog.show();
        Window window = dialog.getWindow();
        window.setAttributes(lp);
    }
}