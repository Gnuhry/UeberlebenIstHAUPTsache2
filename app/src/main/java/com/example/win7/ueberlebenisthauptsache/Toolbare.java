package com.example.win7.ueberlebenisthauptsache;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;


public class Toolbare {

    private Toolbar toolbar;
    private MediaPlayer mediaPlayer;
    private Activity activity;
    private AlertDialog dialog;
    private AlertDialog.Builder mBuilder;
    public Toolbare(final Activity activity, MediaPlayer mediaPlayer){
        this.mediaPlayer=mediaPlayer;
        this.activity=activity;
        mBuilder= new AlertDialog.Builder(activity);
       toolbar=activity.findViewById(R.id.appbar);
       activity.findViewById(R.id.raus).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               activity.findViewById(R.id.raus).setVisibility(View.GONE);
               toolbar.setVisibility(View.VISIBLE);
               toolbar.getMenu().findItem(R.id.SettingMuisk).setChecked(new Speichern(activity).getMusik());
               toolbar.getMenu().findItem(R.id.SettingSound).setChecked(new Speichern(activity).getSound());
           }
       });
   }
   public Toolbar getToolbar(){return toolbar;}

    public boolean ItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.SettingMuisk:new Speichern(activity).setMusik(!item.isChecked()); item.setChecked(new Speichern(activity).getMusik()); if(new Speichern(activity).getMusik()){mediaPlayer.setLooping(true);mediaPlayer.start();}else {mediaPlayer.setLooping(false);mediaPlayer.stop();}break;
            case R.id.SettingSound:new Speichern(activity).setSound(!item.isChecked()); item.setChecked(new Speichern(activity).getSound());break;
            case R.id.back: mediaPlayer.setLooping(false);mediaPlayer.stop();activity.startActivity(new Intent(activity,Menue.class));break;
            case R.id.credithint:
                if(activity.getClass().equals(Menue.class)){mediaPlayer.setLooping(false);mediaPlayer.stop();activity.startActivity(new Intent(activity,Credits.class));}
                else {
                    View mView = activity.getLayoutInflater().inflate(R.layout.erklaerung, null);
                    mView.findViewById(R.id.RLErk).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.cancel();
                        }
                    });
                    dialog=mBuilder.setView(mView).show();
                    dialog.show();
                }break;
            case R.id.rein: toolbar.setVisibility(View.GONE); activity.findViewById(R.id.raus).setVisibility(View.VISIBLE);break;
            case R.id.Reset:
                if(activity.getClass().equals(Menue.class)){
                    View mView = activity.getLayoutInflater().inflate(R.layout.reset, null);
                    mView.findViewById(R.id.btnReset).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {new Speichern(activity).Reset();mediaPlayer.setLooping(false);mediaPlayer.stop();dialog.cancel(); activity.recreate();}
                    });
                    dialog=mBuilder.setView(mView).show();
                    dialog.show();
                   }
                else{mediaPlayer.setLooping(false);mediaPlayer.stop();activity.recreate();} break;
        }
        return true;
    }
}
