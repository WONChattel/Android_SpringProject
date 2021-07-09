package com.example.RecipeSearch;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

//ItemActivity 에 대한 리사이클러뷰 어뎁터 Recipe를 받는데
//하나의 텍스트뷰를 재활용위해서는 list로 다시 변환해야한다. 블록으로 정의. vo는 i로 낱개화가 불가능하므로 하나씩 저장
public class RecyclerAdpter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Recipe recipe;
    private List<String> list = new ArrayList();

    public RecyclerAdpter2(Recipe recipe) {
        this.recipe = recipe;
        list.add(recipe.getMANUAL01());
        list.add(recipe.getMANUAL02());
        list.add(recipe.getMANUAL03());
        list.add(recipe.getMANUAL04());
        list.add(recipe.getMANUAL05());
        list.add(recipe.getMANUAL06());
        list.add(recipe.getMANUAL07());
        list.add(recipe.getMANUAL08());
        list.add(recipe.getMANUAL09());
        list.add(recipe.getMANUAL10());
        list.add(recipe.getMANUAL11());
        list.add(recipe.getMANUAL12());
        list.add(recipe.getMANUAL13());
        list.add(recipe.getMANUAL14());
        list.add(recipe.getMANUAL15());
        list.add(recipe.getMANUAL16());
        list.add(recipe.getMANUAL17());
        list.add(recipe.getMANUAL18());
        list.add(recipe.getMANUAL19());
        list.add(recipe.getMANUAL20());
    }
    //내부 클래스로 뷰홀더 클래스를 만든다.
    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView item1;

        public ViewHolder(View itemView){
            super(itemView);
            item1=itemView.findViewById(R.id.item3);

        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       //1개의 데이터를 저장할 XML파일을 읽어서 뷰 홀더를 만들어서 리턴
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler_view2,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //데이터를 넣어준다

        ViewHolder viewHolder=(ViewHolder)holder;
        viewHolder.item1.setText(list.get(position));

        //어뎁터 내부에서 리스너를 지정한다. --위젯별로 다르게 이벤트를 지정이 가능하다.
        viewHolder.item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = (TextView)v;
                String itemText = tv.getText().toString();
                Snackbar.make(v,itemText,Snackbar.LENGTH_LONG).show();
            }
        });
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
}
