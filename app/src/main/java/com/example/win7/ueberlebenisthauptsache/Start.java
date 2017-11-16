package com.example.win7.ueberlebenisthauptsache;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;

public class Start extends AppCompatActivity implements View.OnClickListener {
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        mediaPlayer=new Speichern(this).Musik_Start(this);
        mediaPlayer.setLooping(true);
        if(new Speichern(this).getMusik())
            mediaPlayer.start();
        findViewById(R.id.imVStart).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        mediaPlayer.setLooping(false);
        mediaPlayer.stop();
        finish();
        startActivity(new Intent(this, Menue.class));
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0||keyCode==KeyEvent.KEYCODE_HOME&& event.getRepeatCount() == 0) {
            mediaPlayer.setLooping(false); mediaPlayer.stop();
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
