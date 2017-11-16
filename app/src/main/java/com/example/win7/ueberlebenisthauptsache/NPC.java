package com.example.win7.ueberlebenisthauptsache;

import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class NPC extends Figur {

    private boolean An=true;
    public NPC(ImageView NPC, Weg weg) {
        super();
        figure=NPC;
        view=figure.animate();
        this.weg=weg;
    }
    @Override
    public void rechts(){
        float x=figure.getX()+speichern.getLaengeX(), y=figure.getY();
        if(weg.wegDa(x,y)) {
            view.translationXBy(speichern.getLaengeX()).start();

        } StatusAktualisieren('r');
    }
    @Override
    public void links(){
        float X=figure.getX()-speichern.getLaengeX(), Y=figure.getY();
        if(weg.wegDa(X,Y)) {
            view.translationXBy(-speichern.getLaengeX()).start();

        }StatusAktualisieren('l');
    }
    @Override
    public void hoch(){
        float X=figure.getX(), Y=figure.getY()-speichern.getLaengeY();
        if(weg.wegDa(X,Y)){
            view.translationYBy(-speichern.getLaengeY()).start();

        }StatusAktualisieren('h');
    }
    @Override
    public void runter(){
        float X=figure.getX(), Y=figure.getY()+speichern.getLaengeY();
        if(weg.wegDa(X,Y)){
            view.translationYBy(speichern.getLaengeY()).start();

        } StatusAktualisieren('d');
    }

    public boolean bewegen(float x, float y){
        if(An){
            float Xn=figure.getX(), Yn=figure.getY();
        switch ((new Random().nextInt(4))){
            case 0: rechts(); if((x==Xn+speichern.getLaengeX()||x==Xn)&&y==Yn){
                An=false;
                figure.setVisibility(View.GONE);
                return true;
            }break;
            case 1: links(); if((x==Xn-speichern.getLaengeX()||x==Xn)&&y==Yn){
                An=false;
                figure.setVisibility(View.GONE);
                return true;
            } break;
            case 2: hoch(); if(x==Xn&&(y==Yn-speichern.getLaengeY()||y==Yn)){
                An=false;
                figure.setVisibility(View.GONE);
                return true;
            }break;
            case 3: runter(); if(x==Xn&&(y==Yn+speichern.getLaengeY()||y==Yn)){
                An=false;
                figure.setVisibility(View.GONE);
                return true;
            } break;
        }
       }
        return false;
    }

    @Override
    protected void StatusAktualisieren(char Bewegung){
        switch (Bewegung){
            case 'h':figure.setImageResource(speichern.Npchoch()); break;
            case 'd':figure.setImageResource(speichern.Npcrunter());break;
            case 'l':figure.setImageResource(speichern.Npclinks());break;
            case 'r':figure.setImageResource(speichern.Npcrechts());break;
        }
    }
}
