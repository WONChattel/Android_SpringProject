package com.example.RecipeSearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

// 메인엑티비티에서 재료를 인텐트로 받은 셋을 포스트방식으로 전달해서 데이터베이스 검색 후 json받아서 list로
// 일단 검색결과를 이미지 리사이클뷰로 .. 선택시 itemactivity로 이동(재활용) < - 프레그먼트화?
public class MainSearchActivity extends AppCompatActivity {
    HashSet<String> set1;

    List<Recipe> list = new ArrayList<>();;
    RecyclerView recyclerView;
    RecyclerAdpter3 adapter;
    String postBody;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        recyclerView = findViewById(R.id.recyclerView2);

        Intent intent = getIntent();
        set1 = (HashSet<String>) intent.getSerializableExtra("set");
        Gson gson = new Gson();
        postBody= gson.toJson(set1);
        postAsyncUserInfo(postBody);
        Log.d("postBody",postBody);

        postAsyncUserInfo(postBody);




         //받은 set으로 request response로 json 응답결과를 반환한다. <- 따로 클래스 만들자.
         //받은 내용을 프레그먼트 아이템에 넣어야하는데..... 넣는 메서드에 데이터를 넣어보자
    }
    public void postAsyncUserInfo(String postBody) {

        try {
            String url = "http://192.168.0.17:8080//mvc08/recipesearch1";

            OkHttpClient client = new OkHttpClient();
            RequestBody requestBody = RequestBody.create(
                    MediaType.parse("application/json; charset=utf-8"), postBody);



            Request.Builder builder = new Request.Builder().url(url).post(requestBody);
            Request request = builder.build();

            client.newCall(request).enqueue(new Callback() {

                @Override
                public void onResponse(okhttp3.@NotNull Call call, @NotNull Response response) throws IOException {
                    try (ResponseBody body = response.body()) {
                        Gson gson1 = new Gson();
                        list = gson1.fromJson(body.string(),new TypeToken<List<Recipe>>(){}.getType());
                        Log.d("list",list.toString());
                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                        response.close();
                       Log.d("accept",list.toString());
                       runOnUiThread(new Runnable() {
                           @Override
                           public void run() {
                               adapter = new RecyclerAdpter3(MainSearchActivity.this,list);
                               recyclerView.setAdapter(adapter);
                               adapter.notifyDataSetChanged();
                           }
                       });

                    }
                }

                @Override
                public void onFailure(okhttp3.@NotNull Call call, @NotNull IOException e) {
                    Log.d("error","error occurred");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }
}