package com.example.rockpaperscissorsgame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    ImageView handAnimImageView;
    ImageView setHandImageView;

    AnimationDrawable animationDrawable;

    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handAnimImageView = findViewById(R.id.hand_anim_image_view);
        setHandImageView = findViewById(R.id.set_hand_image_view);
        handAnimImageView.setVisibility(View.GONE);
        setHandImageView.setVisibility(View.VISIBLE);

        animationDrawable = (AnimationDrawable) handAnimImageView.getDrawable();

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.KOREAN);
                    textToSpeech.setPitch(1.0f); // 음성의 높낮이
                    textToSpeech.setSpeechRate(1.0f); // 음성의 속도
                }
            }
        });

    }

    public void button_click(View view) {
        switch (view.getId()){
            case R.id.replay_button:
                setHandImageView.setVisibility(View.GONE);
                handAnimImageView.setVisibility(view.VISIBLE);
                animationDrawable.start();
                textToSpeech.speak("가위바위보", TextToSpeech.QUEUE_FLUSH, null, null);
                break;


            default:
                animationDrawable.stop();
                handAnimImageView.setVisibility(View.GONE);
                setHandImageView.setVisibility(View.VISIBLE);
                setHandImageView.setImageResource(R.drawable.com_scissors);
                break;

        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        textToSpeech.shutdown();
    }
}
