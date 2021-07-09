package com.example.RecipeSearch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import org.jetbrains.annotations.NotNull;

class ViewPagerAdapter extends PagerAdapter {
    Context context;
    private LayoutInflater layoutInflater = null;

    int[] Image = {R.drawable.food1,R.drawable.food2,R.drawable.food3chickensoup,R.drawable.food4kimchifriedrice,R.drawable.food5bibimbap};

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public Object instantiateItem(@NonNull @NotNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = layoutInflater.inflate(R.layout.subpage,null);
        ImageView image = v.findViewById(R.id.imageView);
        image.setImageResource(Image[position]);

        ViewPager vp = (ViewPager) container;
        vp.addView(v,0);

        return v;
    }

    @Override
    public int getCount() {
        return Image.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull @NotNull View view, @NonNull @NotNull Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(@NonNull @NotNull ViewGroup container, int position, @NonNull @NotNull Object object) {
        ViewPager vp = (ViewPager) container;
        View v = (View) object;
        vp.removeView(v);
    }
}