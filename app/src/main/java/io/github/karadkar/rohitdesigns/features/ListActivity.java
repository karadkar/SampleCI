package io.github.karadkar.rohitdesigns.features;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import io.github.karadkar.rohitdesigns.BaseActivity;
import io.github.karadkar.rohitdesigns.Constants;
import io.github.karadkar.rohitdesigns.R;

public class ListActivity extends BaseActivity {
    RecyclerView mRecyclerView;
    private int mLastAnimatedItemPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view_sample);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        setupWindowAnimations(getIntent().getStringExtra(Constants.KEY_TRANSITION));
    }

    @Override
    protected void onResume() {
        super.onResume();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mRecyclerView.setAdapter(new MyAdapter(getApplicationContext()));
            }
        },400);
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
        Context mContext;
        List<String> myList;

        public MyAdapter(Context mContext) {
            this.mContext = mContext;
            myList = new ArrayList<>();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.list_item,parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
            animateView(holder.itemView,position);
            holder.textView.setText(String.valueOf((position+1)*2));
        }

        @Override
        public void onViewDetachedFromWindow(ViewHolder holder) {
            holder.itemView.clearAnimation();
            super.onViewDetachedFromWindow(holder);
        }

        void animateView(View view, int position){
            if (position > mLastAnimatedItemPosition){
                Animation animation = AnimationUtils.loadAnimation(mContext,R.anim.bottom_slide_in);
                animation.setDuration(Constants.TRANSITION_SPEED);
                view.startAnimation(animation);
                mLastAnimatedItemPosition = position;
            }
        }
        @Override
        public int getItemCount() {
            return 125;
        }

        class ViewHolder extends RecyclerView.ViewHolder{
            public TextView textView;
            public CheckBox checkBox;

            public ViewHolder(View itemView) {
                super(itemView);
                textView = (TextView) itemView.findViewById(R.id.textView);
                checkBox = (CheckBox) itemView.findViewById(R.id.checkBox);
            }
        }
    }
}
