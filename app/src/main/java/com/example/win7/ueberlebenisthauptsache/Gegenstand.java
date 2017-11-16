package com.example.win7.ueberlebenisthauptsache;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.Toast;

public class Gegenstand {

    private ImageView [] Gegenstande;
    private int [] GegenstandIndex;
    private Activity activity;
    private int LevelNr;
    private ImageView Keyanzeige;
    private MediaPlayer mediaPlayer;
    public Gegenstand(ImageView[]Gegenstande, int[]GegenstandIndex, ImageView Keyanzeige, Activity activity, int LevelNr, MediaPlayer mediaPlayer)
    {this.Gegenstande=Gegenstande;this.GegenstandIndex=GegenstandIndex;this.Keyanzeige=Keyanzeige;this.activity=activity;this.LevelNr=LevelNr; this.mediaPlayer=mediaPlayer;}
    public int GegenstandDa(float x, float y, ViewPropertyAnimator viewPropertyAnimator){ boolean aa=true;
        for (int aGegenstandIndex : GegenstandIndex)
            if (Gegenstande[aGegenstandIndex].getX() == x && Gegenstande[aGegenstandIndex].getY() == y&&Gegenstande[aGegenstandIndex].getVisibility()==View.VISIBLE) {
                Log.e("Gegenstand","gefunden, Gegenstandindex: "+aGegenstandIndex);
                Gegenstande[aGegenstandIndex].setVisibility(View.GONE);
                if(aGegenstandIndex==0)
                        new Speichern(activity).Sound_Sword(activity);
                if(aGegenstandIndex==1)
                        new Speichern(activity).Sound_Shild(activity);
                if (aGegenstandIndex == 2) {
                    Gegenstande[2].setVisibility(View.VISIBLE);
                    viewPropertyAnimator.cancel();
                        new Speichern(activity).Sound_Door(activity);
                    for (int bGegenstandIndex : GegenstandIndex){
                        if(bGegenstandIndex==4) aa=false;
                            if (Gegenstande[4].getVisibility() != View.VISIBLE) {
                                Finish();
                             }

                    }
                    if(aa)
                        Finish();
                    return 0;
                }
                if (aGegenstandIndex == 4) {
                        new Speichern(activity).Sound_Coin(activity);
                    Gegenstande[2].setImageResource(new Speichern().dooropen());
                    Keyanzeige.setImageResource(new Speichern().key());
                    return 0;
                }
                return aGegenstandIndex+1;
            }
            Log.e("Gegenstand", "Nicht gefunden");
        return 0;
    }

    private void Finish() {
        mediaPlayer.setLooping(false);
        mediaPlayer.stop();
            new Speichern(activity).Sound_Finish(activity);
        ((Chronometer)activity.findViewById(R.id.chronometer)).stop();
        new Speichern(activity).Stopuhr_stoppen(LevelNr);
        new Speichern(activity).setFortschritt(LevelNr);
        Toast.makeText(activity,"Finish",Toast.LENGTH_SHORT).show();
        activity.startActivity(new Intent(activity, Menue.class));
    }

}
