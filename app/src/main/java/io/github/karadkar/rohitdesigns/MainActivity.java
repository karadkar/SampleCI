package io.github.karadkar.rohitdesigns;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ViewGroup.OnClickListener{
    Context mContext;
    Switch mSelectSwitch;
    SeekBar mSeekBar;
    TextView mTxtAnimSpeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();
        findViewById(R.id.btn_bottom_sheet).setOnClickListener(this);
        findViewById(R.id.btn_anim_explode).setOnClickListener(this);
        findViewById(R.id.btn_anim_fade).setOnClickListener(this);
        findViewById(R.id.btn_anim_slide).setOnClickListener(this);
        mTxtAnimSpeed = (TextView) findViewById(R.id.txtAnimSpeed);

        mSeekBar = (SeekBar) findViewById(R.id.seekBar);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                long animSpeed = progress * 10;
                mTxtAnimSpeed.setText(String.valueOf(animSpeed+" Milliseconds"));
                Constants.TRANSITION_SPEED = animSpeed;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mSeekBar.setProgress(30);
        mSelectSwitch = (Switch) findViewById(R.id.switch1);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_bottom_sheet:
                startActivity(new Intent(mContext,BottomSheetActivity.class));
                break;
            case R.id.btn_anim_explode:
                startAnimActivity(Constants.ANIM_EXPLODE);
                break;
            case R.id.btn_anim_fade:
                startAnimActivity(Constants.ANIM_FADE);
                break;
            default:
                startAnimActivity(Constants.ANIM_SLIDE);
                break;
        }
    }

    void startAnimActivity(String anim_name){
        Intent listActIntent = new Intent(mContext,
                mSelectSwitch.isChecked()?ListActivity.class:DetailActivity.class);
        listActIntent.putExtra(Constants.KEY_TRANSITION,anim_name);
        //TODO: Note that, Activity Options bundle needs to be passed for Transition animations
        startActivity(listActIntent,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }
}
