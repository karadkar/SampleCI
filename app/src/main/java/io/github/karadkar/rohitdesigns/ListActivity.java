package io.github.karadkar.rohitdesigns;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ListActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view_sample);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        mRecyclerView.setAdapter(new MyAdapter(getApplicationContext()));
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
            holder.textView.setText(String.valueOf((position+1)*2));
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
