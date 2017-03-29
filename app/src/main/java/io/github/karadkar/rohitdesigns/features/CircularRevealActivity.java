package io.github.karadkar.rohitdesigns.features;

import android.animation.Animator;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.TextView;

import io.github.karadkar.rohitdesigns.R;

public class CircularRevealActivity extends AppCompatActivity {
    FloatingActionButton fab;
    Boolean isRevealed = false;
    TextView myView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circular_reveal);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        myView = (TextView) findViewById(R.id.txt_hidden_view);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CircularRevealActivity.this.onClickFab();
            }
        });
    }

    void onClickFab(){
        int[] viewLocation = new int[2];
        fab.getLocationOnScreen(viewLocation);
        if (!isRevealed){
            // get the center for the clipping circle
            int x = viewLocation[0];
            int y = viewLocation[1];

            // get the final radius for the clipping circle
            float endRadius = (float) Math.hypot(myView.getHeight(), myView.getWidth());
            float startRadius = 0;

            // create the animator for this view (the start radius is zero)
            Animator anim =
                    ViewAnimationUtils.createCircularReveal(myView, x, y, startRadius, endRadius);

            // make the view visible and start the animation
            myView.setVisibility(View.VISIBLE);
            anim.start();
            isRevealed = true;
        } else {

            int x = myView.getRight();
            int y = myView.getBottom();

            int startRadius = Math.max(myView.getWidth(),myView.getHeight());
            int endRadius = 0;

            Animator anim = ViewAnimationUtils.createCircularReveal(myView,x,y,startRadius,endRadius);
            anim.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    myView.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });

            anim.start();
            isRevealed = false;
        }
    }
}
