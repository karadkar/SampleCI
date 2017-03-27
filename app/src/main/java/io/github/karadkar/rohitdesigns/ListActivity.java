package io.github.karadkar.rohitdesigns;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

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

    class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
        Context mContext;
        List<String> myList;

        public MyAdapter(Context mContext) {
            this.mContext = mContext;
            myList = new ArrayList<>();
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.list_item,parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 125;
        }

        class ViewHolder extends RecyclerView.ViewHolder{
            public ViewHolder(View itemView) {
                super(itemView);
            }
        }
    }
}
