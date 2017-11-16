package com.example.win7.ueberlebenisthauptsache;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;

public class Credits extends AppCompatActivity implements View.OnClickListener {
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
        mediaPlayer=new Speichern(this).Musik_Credit(this);
        mediaPlayer.setLooping(true);
        if(new Speichern(this).getMusik())
            mediaPlayer.start();
        findViewById(R.id.LLCredits).setOnClickListener(this);
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            mediaPlayer.setLooping(false); mediaPlayer.stop();
            startActivity(new Intent(this, Menue.class));
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onClick(View view) {
        mediaPlayer.setLooping(false); mediaPlayer.stop();
        startActivity(new Intent(this, Menue.class));
    }
}
