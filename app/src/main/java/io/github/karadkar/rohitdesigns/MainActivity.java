package io.github.karadkar.rohitdesigns;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements ViewGroup.OnClickListener{
    Context mContext;
    Switch mSelectSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();
        findViewById(R.id.btn_bottom_sheet).setOnClickListener(this);
        findViewById(R.id.btn_anim_explode).setOnClickListener(this);
        findViewById(R.id.btn_anim_fade).setOnClickListener(this);
        findViewById(R.id.btn_anim_default).setOnClickListener(this);

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
                startAnimActivity(Constants.ANIM_DEFAULT);
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
