package com.example.rockpaperscissorsgame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView handAnimImageView;
    ImageView setHandImageView;
    AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handAnimImageView = findViewById(R.id.hand_anim_image_view);
        setHandImageView = findViewById(R.id.set_hand_image_view);
        handAnimImageView.setVisibility(View.GONE);
        setHandImageView.setVisibility(View.VISIBLE);

        animationDrawable = (AnimationDrawable) handAnimImageView.getDrawable();

    }

    public void button_click(View view) {
        switch (view.getId()){
            case R.id.replay_button:
                setHandImageView.setVisibility(View.GONE);
                handAnimImageView.setVisibility(view.VISIBLE);
                animationDrawable.start();
                break;


            default:
                animationDrawable.stop();
                handAnimImageView.setVisibility(View.GONE);
                setHandImageView.setVisibility(View.VISIBLE);
                setHandImageView.setImageResource(R.drawable.com_scissors);
                break;

        }
    }
}
