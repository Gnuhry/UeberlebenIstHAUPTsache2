package com.example.win7.ueberlebenisthauptsache;

import android.util.Log;
import android.widget.ImageView;

public class Weg {

    private ImageView[]Wege;
    public Weg(ImageView[]Wege){this.Wege=Wege;}
    public boolean wegDa(float x, float y){
        for (ImageView aWege : Wege) {
            Log.i("Weg",""+aWege.getX()+", "+x+"|"+aWege.getY()+", "+y);
            if (aWege.getX() == x && aWege.getY() == y)
                return true;
        }
        return false;
    }
}
