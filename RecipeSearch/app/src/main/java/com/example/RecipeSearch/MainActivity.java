package com.example.RecipeSearch;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.HashSet;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager = null;
    private static final int NUM_PAGES = 5;

    HashSet<String> materialSet = new HashSet<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new ViewPagerAdapter(this));


    }

    public void clickBtn(View view) {
        switch (view.getId()) {
            case R.id.button1:
                Intent intent1 = new Intent(MainActivity.this, Menu1Activity.class);
                startActivity(intent1);
                break;
            case R.id.button2: //레시피 올리기?
                Intent intent2 = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent2);
                break;
            case R.id.button3: //가계부 - 장보기
                Intent intent3 = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(intent3);
                break;
            case R.id.button4: //로그인 - > 회원 정보 설정 변경 버튼으로 바꾸는기능 추가
                Intent intent4 = new Intent(MainActivity.this, MainActivity4.class);
                startActivity(intent4);
                break;
            case R.id.search_btn:
                Log.d("해시셋",materialSet.toString());

                    if(!materialSet.isEmpty()){
                        Intent intent5 = new Intent(MainActivity.this, MainSearchActivity.class);
                        intent5.putExtra("set", materialSet);
                        startActivity(intent5);
                    }else{
                        Toast.makeText(this,"선택하지 않았습니다. 선택 후 클릭 해주세요",Toast.LENGTH_LONG).show();
                    }
                break;


        }
    }


    public void clickCircleImage(View view) {
        switch (view.getId()) {
            case R.id.circleImageView1:
                
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final String items[] = {"소고기","돼지고기","닭고기","양고기"};
                        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                        dialog.setTitle("조리하려는 육류를 골라주세요")
                                .setMultiChoiceItems(
                                        items,
                                        new boolean[]{false, false, false, false},
                                        (dialogInterface, which, isChecked) -> {


                                            if(isChecked){
                                                Toast.makeText(MainActivity.this,items[which],Toast.LENGTH_SHORT).show();

                                                materialSet.add(items[which]);
                                            } else {

                                                materialSet.remove(items[which]);
                                            }
                                        }
                                ).setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                String selectedItem = "";
                                for (String item :materialSet){
                                    selectedItem += item+" ";
                                }
                                Toast.makeText(MainActivity.this, selectedItem ,Toast.LENGTH_SHORT).show();
                            }
                        })
                                .setNeutralButton("취소", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int which) {
                                        Toast.makeText(MainActivity.this, "선택을 취소했습니다" ,Toast.LENGTH_SHORT).show();

                                    }
                                });
                        dialog.create();
                        dialog.show();

                    }
                });
                break;
            case R.id.circleImageView2:
            case R.id.circleImageView3:

                view.setOnClickListener(view1 -> {
                    final String items[] = {"감자","양파","당근","마늘","상추","고추가루","바나나","사과"};
                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setTitle("조리하려는 채소를 골라주세요")
                            .setMultiChoiceItems(
                                    items,
                                    new boolean[]{false, false, false, false,false,false,false,false},
                                    new DialogInterface.OnMultiChoiceClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int which, boolean isChecked) {
                                            if(isChecked){
                                                Toast.makeText(MainActivity.this,items[which],Toast.LENGTH_SHORT).show();
                                                materialSet.add(items[which]);
                                            } else {
                                                materialSet.remove(items[which]);
                                            }
                                        }
                                    }
                            ).setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int which) {
                            String selectedItem = "";
                            for (String item :materialSet){
                                selectedItem += item+" ";
                            }
                            Toast.makeText(MainActivity.this, selectedItem ,Toast.LENGTH_SHORT).show();
                        }
                    })
                            .setNeutralButton("취소", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int which) {
                                    Toast.makeText(MainActivity.this, "선택을 취소했습니다" ,Toast.LENGTH_SHORT).show();

                                }
                            });
                    dialog.create();
                    dialog.show();
                });
                break;

            case R.id.circleImageView4:

                view.setOnClickListener(view2 -> {
                    final String items[] = {"백미","현미","보리","밀가루"};
                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setTitle("조리하려는 곡식류를 골라주세요")
                            .setMultiChoiceItems(
                                    items,
                                    new boolean[]{false, false, false, false},
                                    new DialogInterface.OnMultiChoiceClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int which, boolean isChecked) {
                                                if(isChecked){
                                                    Toast.makeText(MainActivity.this,items[which],Toast.LENGTH_SHORT).show();
                                                    materialSet.add(items[which]);
                                                } else {
                                                    materialSet.remove(items[which]);
                                                }
                                        }
                                    }
                            ).setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int which) {
                                String selectedItem = "";
                                for (String item :materialSet){
                                    selectedItem += item+" ";
                                }
                                Toast.makeText(MainActivity.this, selectedItem ,Toast.LENGTH_SHORT).show();
                        }
                    })
                            .setNeutralButton("취소", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int which) {
                                    Toast.makeText(MainActivity.this, "선택을 취소했습니다" ,Toast.LENGTH_SHORT).show();

                                }
                            });
                    dialog.create();
                    dialog.show();
                });
                break;
        }
    }
}