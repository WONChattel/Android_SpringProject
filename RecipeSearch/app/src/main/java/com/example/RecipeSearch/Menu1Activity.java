package com.example.RecipeSearch;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class
Menu1Activity extends AppCompatActivity {
    RecyclerView recyclerView;
    EditText editText;
    RecyclerAdpter adapter = null;
    List<Recipe> list = new ArrayList<>();


    private static final String IP ="192.168.0.17";
    private static final String url ="http://"+IP+":8080/mvc08/recipesearch2?word=";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu1);
        editText = findViewById(R.id.search_word);
        recyclerView = findViewById(R.id.recyclerView);

        adapter = new RecyclerAdpter(this,list);
        //어뎁터 붙이기
        recyclerView.setAdapter(adapter);
        //리스너 지정하기
    }

    public void onclick(View view) {
        //어뎁터 만들기
        RecipeTask task = new RecipeTask();
        task.execute();
    }

    class RecipeTask extends AsyncTask<Void, Void, Void>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            list.clear();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            adapter = new RecyclerAdpter(Menu1Activity.this,list);
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();


        }

        @Override
        protected Void doInBackground(Void... voids) {
            String word = editText.getText().toString();
            // 리스트에 데이터를 채워준다.
            String addr = url+word;
            try {
                URL url = new URL(addr);
                Gson gson = new Gson();
                InputStreamReader isr = new InputStreamReader(url.openStream(),"UTF-8");
                list = gson.fromJson(isr, new TypeToken<List<Recipe>>(){}.getType());
                Log.d("list",list.toString());

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

}
