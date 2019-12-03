package com.example.rockpaperscissorsgame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView handAnimImageView;
    AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handAnimImageView = findViewById(R.id.hand_anim_image_view);
        animationDrawable = (AnimationDrawable) handAnimImageView.getDrawable();
        animationDrawable.start();

    }

    public void button_click(View view) {
    }
}
