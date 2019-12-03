package com.example.rockpaperscissorsgame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView handAnimImageView;
    ImageView setHandImageView;

    ImageButton scissorsButton;
    ImageButton rockButton;
    ImageButton paperButton;
    ImageButton replayButton;

    AnimationDrawable animationDrawable;

    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handAnimImageView = findViewById(R.id.hand_anim_image_view);
        setHandImageView = findViewById(R.id.set_hand_image_view);

        scissorsButton = findViewById(R.id.scissors_button);
        rockButton = findViewById(R.id.rock_button);
        paperButton = findViewById(R.id.paper_button);
        replayButton = findViewById(R.id.replay_button);


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
        switch (view.getId()) {
            case R.id.replay_button:
                setHandImageView.setVisibility(View.GONE);
                handAnimImageView.setVisibility(view.VISIBLE);
                animationDrawable.start();
                voicePlay("가위바위보");
                replayButton.setEnabled(false);
                scissorsButton.setEnabled(true);
                rockButton.setEnabled(true);
                paperButton.setEnabled(true);
                break;

            case R.id.scissors_button:
            case R.id.rock_button:
            case R.id.paper_button:
                replayButton.setEnabled(true);
                scissorsButton.setEnabled(false);
                rockButton.setEnabled(false);
                paperButton.setEnabled(false);
                animationDrawable.stop();
                setHandImageView.setVisibility(View.VISIBLE);
                handAnimImageView.setVisibility(View.GONE);

                int userHand = Integer.parseInt(view.getTag().toString());
                int comHand = setComHand();
                winCheck(userHand, comHand);
                break;

            default:
                break;

        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        textToSpeech.shutdown();
    }

    public void voicePlay(String voiceText) {
        textToSpeech.speak(voiceText, TextToSpeech.QUEUE_FLUSH, null, null);
    }

    public int setComHand() {
        int getComHand = new Random().nextInt(3) + 1;
        switch (getComHand) {
            case 1:
                setHandImageView.setImageResource(R.drawable.com_scissors);
                break;
            case 2:
                setHandImageView.setImageResource(R.drawable.com_rock);
                break;
            case 3:
                setHandImageView.setImageResource(R.drawable.com_paper);
                break;
        }
        return getComHand;
    }

    public void winCheck(int userHand, int comHand) {
        int result = (3 + userHand - comHand) % 3;
        switch (result) {
            case 0:
                voicePlay("비겼어요. 다시 시작하세요.");
                break;
            case 1:
                voicePlay("당신이 이겼어요. 축하축하");
                break;
            case 2:
                voicePlay("제가 이겼어요. 크크크");
                break;
            default:
                break;
        }
    }
}
