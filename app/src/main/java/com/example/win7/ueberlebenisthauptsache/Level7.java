package com.example.win7.ueberlebenisthauptsache;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.ImageView;

public class Level7 extends AppCompatActivity {
    private ImageView []Weg,npc;
    private Steuerung steuerung;
    private Toolbare toolbare;
    private Gegenstand gegenstand;
    private MediaPlayer mediaPlayer;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return toolbare.ItemSelected(item);
    }

    @Override
   public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            mediaPlayer.setLooping(false); mediaPlayer.stop();
            startActivity(new Intent(this, Menue.class));
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_level7);
        mediaPlayer=new Speichern(this).Musik_Level(this);
        mediaPlayer.setLooping(true);
        if(new Speichern(this).getMusik())
        mediaPlayer.start();
        new Speichern(this).Stopuhr_starten();
        toolbare=new Toolbare(this,mediaPlayer);
        setSupportActionBar(toolbare.getToolbar());
        getSupportActionBar().setTitle(null);
        initialsieern();
        NPC[] npcs = new NPC[npc.length];
        for(int f=0;f<npc.length;f++)
            npcs[f]=new NPC(npc[f],new Weg(Weg));
        steuerung=new Steuerung(new Figur((ImageView)findViewById(R.id.Figur),new Weg(Weg),gegenstand, npcs,this,mediaPlayer),this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
              return steuerung.onTouchEvent(event);
    }

    private void initialsieern() {
ImageView[]Gegenstande=new ImageView[5];
new Speichern(this).setLaengeX(55);
new Speichern(this).setLaengeY(80);
Weg=new ImageView[26];
int [] GegIndex=new int[4];
Gegenstande[2]=(ImageView)findViewById(R.id.Door);
GegIndex[0]=2;
npc=new ImageView[4];
Weg[0]=(ImageView)findViewById(R.id.Weg0);
Weg[1]=(ImageView)findViewById(R.id.Weg1);
Weg[2]=(ImageView)findViewById(R.id.Weg2);
Weg[3]=(ImageView)findViewById(R.id.Weg3);
Weg[4]=(ImageView)findViewById(R.id.Weg4);
Weg[5]=(ImageView)findViewById(R.id.Weg5);
Weg[6]=(ImageView)findViewById(R.id.Weg6);
Weg[7]=(ImageView)findViewById(R.id.Weg7);
Weg[8]=(ImageView)findViewById(R.id.Weg8);
Weg[9]=(ImageView)findViewById(R.id.Weg9);
Weg[10]=(ImageView)findViewById(R.id.Weg10);
Weg[11]=(ImageView)findViewById(R.id.Weg11);
Weg[12]=(ImageView)findViewById(R.id.Weg12);
Weg[13]=(ImageView)findViewById(R.id.Weg13);
Weg[14]=(ImageView)findViewById(R.id.Weg14);
Weg[15]=(ImageView)findViewById(R.id.Weg15);
Weg[16]=(ImageView)findViewById(R.id.Weg16);
Weg[17]=(ImageView)findViewById(R.id.Weg17);
Weg[18]=(ImageView)findViewById(R.id.Weg18);
Weg[19]=(ImageView)findViewById(R.id.Weg19);
Weg[20]=(ImageView)findViewById(R.id.Weg20);
Weg[21]=(ImageView)findViewById(R.id.Weg21);
Weg[22]=(ImageView)findViewById(R.id.Weg22);
Weg[23]=(ImageView)findViewById(R.id.Weg23);
Weg[24]=(ImageView)findViewById(R.id.Weg24);
Weg[25]=(ImageView)findViewById(R.id.Weg25);
Gegenstande[0]=(ImageView)findViewById(R.id.Sword);
GegIndex[1]=0;
Gegenstande[1]=(ImageView)findViewById(R.id.Shild);
GegIndex[2]=1;
Gegenstande[4]=(ImageView)findViewById(R.id.Key);
GegIndex[3]=4;
npc[0]=(ImageView)findViewById(R.id.NPC0);
npc[1]=(ImageView)findViewById(R.id.NPC1);
npc[2]=(ImageView)findViewById(R.id.NPC2);
npc[3]=(ImageView)findViewById(R.id.NPC3);
gegenstand=new Gegenstand(Gegenstande,GegIndex,(ImageView)findViewById(R.id.keyanzeige),this,7,mediaPlayer);
}}
