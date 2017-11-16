package com.example.win7.ueberlebenisthauptsache;


import android.app.Activity;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;

public class Figur {

    protected static Speichern speichern=new Speichern();
    protected ViewPropertyAnimator view;
    protected ImageView figure;
    protected Weg weg;
    private Gegenstand gegenstand;
    private int Status;
    private NPC[]npcs;
    private Activity activity;
    private MediaPlayer mediaPlayer;

    public Figur(){}
    public Figur(ImageView Figur, Weg weg, Gegenstand gegenstand, NPC[]npcs, Activity activity, MediaPlayer mediaPlayer)
    {   view=Figur.animate();
        this.activity=activity;
        figure=Figur;
        this.npcs=npcs;
        Status=0;
        this.weg=weg;
        this.mediaPlayer=mediaPlayer;
        this.gegenstand=gegenstand;
    }

    public void links(){
        float x=figure.getX()+-speichern.getLaengeX(), y=figure.getY();
        Log.e("Links",""+weg.wegDa(x,y));
        if(weg.wegDa(x,y)){
            view.translationXBy(-speichern.getLaengeX()).start();
            Status+=gegenstand.GegenstandDa(x,y,view);
        }
        StatusAktualisieren('l');
        NPCbewegen(x,y);
    }
    public void rechts(){
        float x=figure.getX()+speichern.getLaengeX(), y=figure.getY();
        Log.e("Rechts",""+weg.wegDa(x,y));
        if(weg.wegDa(x,y)){
            view.translationXBy(speichern.getLaengeX()).start();
            Status+=gegenstand.GegenstandDa(x,y,view);
        }
        StatusAktualisieren('r');
        NPCbewegen(x,y);
    }
    public void hoch(){
        float x=figure.getX(), y=figure.getY()-speichern.getLaengeY();
        Log.e("Hoch",""+weg.wegDa(x,y));
        if(weg.wegDa(x,y)){
            view.translationYBy(-speichern.getLaengeY()).start();
            Status+=gegenstand.GegenstandDa(x,y,view);
        }
        StatusAktualisieren('h');

        NPCbewegen(x,y);
        }
    public void runter(){
        float x=figure.getX(), y=figure.getY()+speichern.getLaengeY();
        Log.e("Runter",""+weg.wegDa(x,y));
        if(weg.wegDa(x,y)){
            view.translationYBy(speichern.getLaengeY()).start();
            Status+=gegenstand.GegenstandDa(x,y,view);
        }
        StatusAktualisieren('d');

        NPCbewegen(x,y);
    }

    private void NPCbewegen(float x, float y) {
        for (NPC npc : npcs) {
            if (npc.bewegen(x, y)) Getroffen();
        }
    }
    protected void StatusAktualisieren(char Bewegung) {
        Log.e("StatusAktualisieren", ""+Status);
        switch (Status){
            case 0: switch (Bewegung){
                case 'h':figure.setImageResource(speichern.Figurhoch()); break;
                case 'd':figure.setImageResource(speichern.Figurrunter());break;
                case 'l':figure.setImageResource(speichern.Figurlinks());break;
                case 'r':figure.setImageResource(speichern.Figurrechts());break;
            }break;
            case 1:switch (Bewegung){
                case 'h':figure.setImageResource(speichern.Figurhoch_sword());break;
                case 'd':figure.setImageResource(speichern.Figurrunter_sword());break;
                case 'l':figure.setImageResource(speichern.Figurlinks_sword());break;
                case 'r':figure.setImageResource(speichern.Figurrechts_sword());break;
            }break;
            case 2:switch (Bewegung){
                case 'h':figure.setImageResource(speichern.Figurhoch_shild());break;
                case 'd':figure.setImageResource(speichern.Figurrunter_shild());break;
                case 'l':figure.setImageResource(speichern.Figurlinks_shild());break;
                case 'r':figure.setImageResource(speichern.Figurrechts_shild());break;
            }break;
            case 3:switch (Bewegung){
                case 'h':figure.setImageResource(speichern.Figurhoch_swordshild());break;
                case 'd':figure.setImageResource(speichern.Figurrunter_swordshild());break;
                case 'l':figure.setImageResource(speichern.Figurlinks_swordshild());break;
                case 'r':figure.setImageResource(speichern.Figurrechts_swordshild());break;
            }break;
        }
    }

    private void Getroffen() {
        switch (Status){
            case 0:  mediaPlayer.setLooping(false); mediaPlayer.stop();activity.recreate();break;
            case 1:  new Speichern(activity).Sound_Sword_Crash(activity);Status=0; StatusAktualisieren('r');break;
            case 2:  new Speichern(activity).Sound_Shild_Crash(activity);Status=0; StatusAktualisieren('r');break;
            case 3:  new Speichern(activity).Sound_Shild_Crash(activity);Status=1; StatusAktualisieren('r'); break;
        }
    }


}
