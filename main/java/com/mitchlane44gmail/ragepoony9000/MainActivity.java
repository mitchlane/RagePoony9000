package com.mitchlane44gmail.ragepoony9000;

import android.content.res.AssetFileDescriptor;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private FrameLayout fl;
    private final MediaPlayer mp = new MediaPlayer();

    protected @BindView(R.id.sound_one) Button s1;
    protected @BindView(R.id.sound_two) Button s2;
    protected @BindView(R.id.sound_three) Button s3;
    protected @BindView(R.id.sound_four) Button s4;
    protected @BindView(R.id.sound_five) Button s5;
    protected @BindView(R.id.sound_six) Button s6;
    protected @BindView(R.id.sound_seven) Button s7;
    protected @BindView(R.id.sound_eight) Button s8;
    protected @BindView(R.id.sound_nine) Button s9;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test2_layout);
        ButterKnife.setDebug(true);
        ButterKnife.bind(this);

        createImageButton(s1, "shmerg.mp3");
        createImageButton(s2, "laugh.mp3");
        createImageButton(s3, "gank.mp3");
        createImageButton(s4, "How.mp3");
        createImageButton(s5, "calm_down.mp3");
        createImageButton(s6, "on_high.mp3");
        createImageButton(s7, "geeh.mp3");
        createImageButton(s8, "suut.mp3");
        createImageButton(s9, "shmerg2.mp3");

    }

    private void createImageButton(Button button, final String soundName) {

        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        v.setAlpha(0.5f);
                        if(mp.isPlaying()) {
                            mp.stop();
                        }

                        try {
                            mp.reset();
                            AssetFileDescriptor afd = getAssets().openFd(soundName);
                            mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                            mp.prepare();
                            mp.start();
                        }
                        catch(IllegalStateException e) {
                            e.printStackTrace();
                        }
                        catch(IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        v.setAlpha(1.0f);
                        break;
                    default:
//                        v.setBackgroundColor(getResources().getColor(R.color.halfColorPrimary));
                        break;
                }
                return false;
            }
        });
    }
}
