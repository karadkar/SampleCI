package io.github.karadkar.rohitdesigns;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ViewGroup.OnClickListener{
    Context mContext;
    Button mBtnBottomSheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();
        findViewById(R.id.btn_bottom_sheet).setOnClickListener(this);
        findViewById(R.id.btn_list_sample).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_bottom_sheet:
                startActivity(new Intent(mContext,BottomSheetActivity.class));
                break;
            case R.id.btn_list_sample:
                startActivity(new Intent(mContext,ListActivity.class));
                break;
        }
    }
}
