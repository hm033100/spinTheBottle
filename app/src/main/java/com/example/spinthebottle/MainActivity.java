package com.example.spinthebottle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnSpin;
    ImageView iv_bottle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSpin = (Button) findViewById(R.id.btnSpin);
        iv_bottle = (ImageView) findViewById(R.id.iv_bottle);

        btnSpin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final int theSpinDegrees;
                Random r = new Random();

                theSpinDegrees = r.nextInt(3600);

                RotateAnimation rotateBottle = new RotateAnimation(0,
                        theSpinDegrees, Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f);


                rotateBottle.setDuration(2000);
                rotateBottle.setFillAfter(true);
                rotateBottle.setInterpolator(new AccelerateDecelerateInterpolator());

                rotateBottle.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                        if (theSpinDegrees % 360 >  180) {
                            //left has been chosen
                            Toast.makeText(MainActivity.this, "Left person has been chosen "
                                    , Toast.LENGTH_SHORT).show();
                        } else {
                            //right has been chosen
                            Toast.makeText(MainActivity.this, "Right person has been chosen "
                                    , Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                iv_bottle.startAnimation(rotateBottle);



            }
        });
    }
}
