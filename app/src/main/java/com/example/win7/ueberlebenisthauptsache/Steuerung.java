package com.example.win7.ueberlebenisthauptsache;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class Steuerung extends AppCompatActivity implements View.OnClickListener {
private float xx;
    private float yy;
    private Figur figur;
    private Button[] Steuer;
    private ImageView up,down;
    private Activity activity;
    public Steuerung(Figur figur, Activity activity){
        this.figur=figur;
        this.activity=activity;
        ((Chronometer)activity.findViewById(R.id.chronometer)).start();
        up=activity.findViewById(R.id.imVUp);
        up.setOnClickListener(this);
        down=activity.findViewById(R.id.imVDown);
        down.setOnClickListener(this);
            Steuer=new Button[4];
            Steuer[0]= activity.findViewById(R.id.btnhoch);
            Steuer[1]= activity.findViewById(R.id.btnrunter);
            Steuer[2]= activity.findViewById(R.id.btnlinks);
            Steuer[3]= activity.findViewById(R.id.btnrechts);
        for (Button aSteuer : Steuer) aSteuer.setOnClickListener(this);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("Touch","Ja");
        if(event.getAction()==0){
            xx=event.getX();
            yy=event.getY();
        }
        if(event.getAction()==1&&xx!=0){
            float xx2 = event.getX();
            float yy2 = event.getY();
            float dxx=xx- xx2, dyy=yy- yy2;//nach unten y wird gr��er nach oben kleiner //nach rechts x gr��er nach links kleiner
            int toleranz = 60;
            if(dxx< toleranz &&dxx>-toleranz) {//Bewegung in y Richtung
                if(dyy>0){//Bewegung nach oben
                    figur.hoch();
                }
                else{//Bewegung nach unten
                    figur.runter();
                }
            }
            else{//Bewegung in x Richtung
                if(dxx>0){//Bewegung nach links
                    figur.links();
                }
                else{//Bewegung nach rechts
                   figur.rechts();
                }
            }
            // test2.setText(String.valueOf(xx)+","+String.valueOf(yy)+","+String.valueOf(xx2)+","+String.valueOf(yy2));
        }

        // test2.setText(String.valueOf(xx)+","+String.valueOf(yy)+","+String.valueOf(x));
        return true;
    }

    @Override
    public void onClick(View view) {
        if(view==up){up.setVisibility(View.GONE);activity.findViewById(R.id.Steuerung).setVisibility(View.VISIBLE);}
        else if(view==down){up.setVisibility(View.VISIBLE);activity.findViewById(R.id.Steuerung).setVisibility(View.GONE);}
        else if(view==Steuer[0]){figur.hoch();}
        else if(view==Steuer[1]){figur.runter();}
        else if(view==Steuer[2]){figur.links();}
        else if(view==Steuer[3]){figur.rechts();}
    }
}
