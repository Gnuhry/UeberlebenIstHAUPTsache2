package com.example.win7.ueberlebenisthauptsache;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;

import java.util.Random;

public class Speichern  {
    private SharedPreferences Allgemein;
    private SharedPreferences.Editor editor;
    private float LaengeY=80,LaengeX=55;
    private final String key1="StuppuhrStart",key2="Highscore",key3="Musik",key4="Sound",key5="LevelFortschritt";

   public Speichern(Activity activity){
       Allgemein=activity.getSharedPreferences("Allgemein", Context.MODE_PRIVATE);
       editor=Allgemein.edit();
   }
   public Speichern(){Allgemein=null;}

    public void setLaengeX(float x){LaengeX=x;}
    public void setLaengeY(float y){LaengeY=y;}
    public float getLaengeX(){return LaengeX;}
    public float getLaengeY(){return LaengeY;}

    public int Figurlinks() {return R.drawable.figur_left;}
    public int Figurrechts(){return R.drawable.figur_right;}
    public int Figurhoch(){return R.drawable.figur_back;}
    public int Figurrunter(){return R.drawable.figur_front;}

    public int Figurlinks_sword() {return R.drawable.figur_left_sword;}
    public int Figurrechts_sword(){return R.drawable.figur_right_sword;}
    public int Figurhoch_sword(){return R.drawable.figur_back_sword;}
    public int Figurrunter_sword(){return R.drawable.figur_front_sword;}

    public int Figurlinks_shild() {return R.drawable.figur_left_shild;}
    public int Figurrechts_shild(){return R.drawable.figur_right_shild;}
    public int Figurhoch_shild(){return R.drawable.figur_back_shild;}
    public int Figurrunter_shild(){return R.drawable.figur_front_shild;}

    public int Figurlinks_swordshild() {return R.drawable.figur_left_swordshild;}
    public int Figurrechts_swordshild(){return R.drawable.figur_right_swordshild;}
    public int Figurhoch_swordshild(){return R.drawable.figur_back_swordshild;}
    public int Figurrunter_swordshild(){return R.drawable.figur_front_swordshild;}

    public int Npclinks() {return R.drawable.npc_left;}
    public int Npcrechts(){return R.drawable.npc_right;}
    public int Npchoch(){return R.drawable.npc_back;}
    public int Npcrunter(){return R.drawable.npc_front;}

    public int dooropen(){return R.drawable.door_open;}
    public int key(){return R.drawable.key_anzeige;}

    public void Stopuhr_starten(){editor.putInt(key1,(int)System.currentTimeMillis() ).commit();}
    public void Stopuhr_stoppen(int LevelNr){editor.putInt(key2+LevelNr,((((int)System.currentTimeMillis())-Allgemein.getInt(key1,0))/1000)).commit();}
    public String getHighscore(int LevelNr){return ("min: "+Allgemein.getInt(key2+LevelNr,0)/60+", sek"+Allgemein.getInt(key2+LevelNr,0)%60);}

    public void setMusik(boolean An){editor.putBoolean(key3,An).commit();}
    public boolean getMusik(){return Allgemein.getBoolean(key3,true);}

    public void setSound(boolean An){editor.putBoolean(key4,An).commit();}
    public boolean getSound(){return Allgemein.getBoolean(key4,true);}

    public void Sound_Door(Activity activity){if(getSound())MediaPlayer.create(activity,R.raw.door).start();}
    public void Sound_Coin(Activity activity){if(getSound())MediaPlayer.create(activity,R.raw.coin).start();}
    public void Sound_Finish(Activity activity){if(getSound())MediaPlayer.create(activity,R.raw.finish).start();}
    public void Sound_Shild(Activity activity){if(getSound())MediaPlayer.create(activity,R.raw.shield).start();}
    public void Sound_Shild_Crash(Activity activity){if(getSound())MediaPlayer.create(activity,R.raw.shieldcrash).start();}
    public void Sound_Sword_Crash(Activity activity){if(getSound())MediaPlayer.create(activity,R.raw.swordattack).start();}
    public void Sound_Sword(Activity activity){if(getSound())MediaPlayer.create(activity,R.raw.sword).start();}

    public MediaPlayer Musik_Level(Activity activity){switch (new Random().nextInt(10)){
        case 0: return MediaPlayer.create(activity, R.raw.level1);
        case 1: return MediaPlayer.create(activity,  R.raw.level2);
        case 2: return MediaPlayer.create(activity,  R.raw.level3);
        case 3: return MediaPlayer.create(activity,  R.raw.level4);
        case 4: return MediaPlayer.create(activity,  R.raw.level5);
        case 5: return MediaPlayer.create(activity,  R.raw.level6);
        case 6: return MediaPlayer.create(activity,  R.raw.level7);
        case 7: return MediaPlayer.create(activity,  R.raw.level8);
        case 8: return MediaPlayer.create(activity,  R.raw.level9);
        default: return MediaPlayer.create(activity,  R.raw.level10);}
    }
    public MediaPlayer Musik_Menue(Activity activity){switch (new Random().nextInt(3)){
        case 0: return MediaPlayer.create(activity,  R.raw.menue1);
        case 1: return MediaPlayer.create(activity,  R.raw.menue2);
        case 2: return MediaPlayer.create(activity,  R.raw.menue3);
        default: return MediaPlayer.create(activity,  R.raw.menue4);
    }}
    public MediaPlayer Musik_Start(Activity activity){ return MediaPlayer.create(activity, R.raw.start);}
    public MediaPlayer Musik_Credit(Activity activity){return MediaPlayer.create(activity,  R.raw.credits);}

    public void Reset() {editor.clear().commit();}
    public void setFortschritt(int Level){
        if(!(++Level<getFortschritt())) editor.putInt(key5,Level).commit();
    }
    public int getFortschritt() {return Allgemein.getInt(key5,1);}
}
