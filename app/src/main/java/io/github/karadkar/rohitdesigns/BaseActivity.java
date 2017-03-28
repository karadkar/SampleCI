package io.github.karadkar.rohitdesigns;

import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;

/**
 * Created by rnztx on 28/3/17.
 */

public class BaseActivity extends AppCompatActivity {
    protected void setupWindowAnimations(String animationType){
        switch (animationType){
            case Constants.ANIM_EXPLODE:
                startEnterTransition(new Explode());
                break;
            case Constants.ANIM_FADE:
                startEnterTransition(new Fade());
                break;
            case Constants.ANIM_DEFAULT:
                startEnterTransition(new Slide());
                break;
        }
    }

    protected void startEnterTransition(Transition transition){
        transition.setDuration(Constants.ANIM_TIME);
        getWindow().setEnterTransition(transition);
    }
}
