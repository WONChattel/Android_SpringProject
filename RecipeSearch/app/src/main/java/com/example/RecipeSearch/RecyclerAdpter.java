package com.example.RecipeSearch;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdpter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Recipe> itemList;
    private Context mContext;
    Recipe recipe;
    public RecyclerAdpter(Context context,List<Recipe> itemList) {
        this.mContext = context;
        this.itemList = itemList;
    }
    //내부 클래스로 뷰홀더 클래스를 만든다.
    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView item1;
        public ViewHolder(View itemView){
            super(itemView);
            item1=itemView.findViewById(R.id.item1);

        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       //1개의 데이터를 저장할 XML파일을 읽어서 뷰 홀더를 만들어서 리턴
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //데이터를 넣어준다
        ViewHolder viewHolder=(ViewHolder)holder;
        viewHolder.item1.setText(itemList.get(position).getRCP_NM()+":"+itemList.get(position).getRCP_PARTS_DTLS());

        //어뎁터 내부에서 리스너를 지정한다. --위젯별로 다르게 이벤트를 지정이 가능하다.
        viewHolder.item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (position != RecyclerView.NO_POSITION){
                    Intent intent = new Intent(mContext, ItemActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    recipe = itemList.get(position);
                    intent.putExtra("recipe",recipe);
                    mContext.startActivity(intent);
                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
