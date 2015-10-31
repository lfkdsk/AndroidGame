package com.lfk.killit.Drawable.Button;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.lfk.killit.Animation.MAnimation;
import com.lfk.killit.Data.Loacl.Location;

/**
 * Created by liufengkai on 15/10/31.
 */
public class SimpleButton implements BaseButton {
    private int state;
    private Rect rect;
    private int mX, mY;
    private Location mLocation;
    private MAnimation mAnimation;
    private String mName;
    private Canvas canvas;

    public SimpleButton(Canvas canvas,String mName, int mY, int mX) {
        this.mName = mName;
        this.canvas = canvas;
        this.mY = mY;
        this.mX = mX;
        this.mLocation = new Location(mX, mY, mName);
    }

    @Override
    public int getState() {
        return state;
    }

    @Override
    public void setState(int state) {
        this.state = state;
    }

    @Override
    public Rect getRect() {
        return rect;
    }

    @Override
    public void drawIt() {
        switch (state){
            case NORMAL:
                mAnimation.draw(canvas,mX,mY);
                break;
            case CLICKED:

                break;
        }
    }


}
