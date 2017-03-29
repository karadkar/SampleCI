package io.github.karadkar.rohitdesigns.features;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import io.github.karadkar.rohitdesigns.R;

public class BottomSheetActivity extends AppCompatActivity {
    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet);
        mContext = getApplicationContext();

        // get the bottom sheet view
        LinearLayout llBottomSheet = (LinearLayout) findViewById(R.id.bottom_sheet);

        // init behaviour
        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(llBottomSheet);

        // change state
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

        // add peek height
//        bottomSheetBehavior.setPeekHeight(80);

        // hideAble or not !
        bottomSheetBehavior.setHideable(true);

        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState){
                    case BottomSheetBehavior.STATE_EXPANDED:
                        showToast("Expanded");
                        break;
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        showToast("Collapsed");
                        break;
                    /*case BottomSheetBehavior.STATE_DRAGGING:
                        showToast("Dragging");
                        break;*/
                    case BottomSheetBehavior.STATE_HIDDEN:
                        showToast("Closed");
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
    }
    void showToast(String message){
        Toast.makeText(mContext,message,Toast.LENGTH_SHORT).show();
    }
}
