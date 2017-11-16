package com.example.win7.ueberlebenisthauptsache;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Menue extends AppCompatActivity implements View.OnClickListener {
    private MediaPlayer mediaPlayer;
    private Button[]btn;
    private Toolbare toolbare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menue);
        mediaPlayer=new Speichern(this).Musik_Menue(this);
        mediaPlayer.setLooping(true);
        if(new Speichern(this).getMusik())
            mediaPlayer.start();
        toolbare= new Toolbare(this,mediaPlayer);
        setSupportActionBar(toolbare.getToolbar());
        try {
            getSupportActionBar().setTitle(null);
        }
        catch (RuntimeException e){e.printStackTrace();}

        initialisiern();
        //startActivity(new Intent(this,Level1.class));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            mediaPlayer.setLooping(false); mediaPlayer.stop();
            startActivity(new Intent(this,Start.class));
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return toolbare.ItemSelected(item);
    }

    private void initialisiern() {
        btn=new Button[16];
        btn[0]=(Button)findViewById(R.id.btnLevel1);
        btn[1]=(Button)findViewById(R.id.btnLevel2);
        btn[2]=(Button)findViewById(R.id.btnLevel3);
        btn[3]=(Button)findViewById(R.id.btnLevel4);
        btn[4]=(Button)findViewById(R.id.btnLevel5);
        btn[5]=(Button)findViewById(R.id.btnLevel6);
        btn[6]=(Button)findViewById(R.id.btnLevel7);
        btn[7]=(Button)findViewById(R.id.btnLevel8);
        btn[8]=(Button)findViewById(R.id.btnLevel9);
        btn[9]=(Button)findViewById(R.id.btnLevel10);
        btn[10]=(Button)findViewById(R.id.btnLevel11);
        btn[11]=(Button)findViewById(R.id.btnLevel12);
        btn[12]=(Button)findViewById(R.id.btnLevel13);
        btn[13]=(Button)findViewById(R.id.btnLevel14);
        btn[14]=(Button)findViewById(R.id.btnLevel15);
        btn[15]=(Button)findViewById(R.id.btnLevel16);
        for(int f = new Speichern(this).getFortschritt(); f<16; f++){
            btn[f].setEnabled(false);
        }
        for (Button aBtn : btn) {
            aBtn.setOnClickListener(this);
        }
        switch (new Speichern(this).getFortschritt()){
            case 16:((TextView)findViewById(R.id.txVLevel15)).setText(new Speichern(this).getHighscore(15));
            case 15:((TextView)findViewById(R.id.txVLevel14)).setText(new Speichern(this).getHighscore(14));
            case 14:((TextView)findViewById(R.id.txVLevel13)).setText(new Speichern(this).getHighscore(13));
            case 13:((TextView)findViewById(R.id.txVLevel12)).setText(new Speichern(this).getHighscore(12));
            case 12:((TextView)findViewById(R.id.txVLevel11)).setText(new Speichern(this).getHighscore(11));
            case 11:((TextView)findViewById(R.id.txVLevel10)).setText(new Speichern(this).getHighscore(10));
            case 10:((TextView)findViewById(R.id.txVLevel9)).setText(new Speichern(this).getHighscore(9));
            case 9:((TextView)findViewById(R.id.txVLevel8)).setText(new Speichern(this).getHighscore(8));
            case 8:((TextView)findViewById(R.id.txVLevel7)).setText(new Speichern(this).getHighscore(7));
            case 7:((TextView)findViewById(R.id.txVLevel6)).setText(new Speichern(this).getHighscore(6));
            case 6:((TextView)findViewById(R.id.txVLevel5)).setText(new Speichern(this).getHighscore(5));
            case 5:((TextView)findViewById(R.id.txVLevel4)).setText(new Speichern(this).getHighscore(4));
            case 4:((TextView)findViewById(R.id.txVLevel3)).setText(new Speichern(this).getHighscore(3));
            case 3:((TextView)findViewById(R.id.txVLevel2)).setText(new Speichern(this).getHighscore(2));
            case 2:((TextView)findViewById(R.id.txVLevel1)).setText(new Speichern(this).getHighscore(1));

            
           
           
        }
    }

    @Override
    public void onClick(View view) {
        for (int f=0;f<btn.length;f++)
            if(view==btn[f]){
                mediaPlayer.setLooping(false);
                mediaPlayer.stop();
                switch (f){
                    case 0: startActivity(new Intent(this, Level1.class));  break;
                    case 1: startActivity(new Intent(this, Level2.class));  break;
                    case 2: startActivity(new Intent(this, Level3.class));  break;
                    case 3: startActivity(new Intent(this, Level4.class));  break;
                    case 4: startActivity(new Intent(this, Level5.class));  break;
                    case 5: startActivity(new Intent(this, Level6.class));  break;
                    case 6: startActivity(new Intent(this, Level7.class));  break;
                    case 7: startActivity(new Intent(this, Level8.class));  break;
                    case 8: startActivity(new Intent(this, Level9.class));  break;
                    case 9: startActivity(new Intent(this, Level10.class)); break;
                    case 10: startActivity(new Intent(this, Level11.class));break;
                    case 11: startActivity(new Intent(this, Level12.class));break;
                    case 12: startActivity(new Intent(this, Level13.class));break;
                    case 13: startActivity(new Intent(this, Level14.class));break;
                    case 14: startActivity(new Intent(this, Level15.class));break;
                    case 15: startActivity(new Intent(this, Level16.class));break;
                }
            }
    }
}
