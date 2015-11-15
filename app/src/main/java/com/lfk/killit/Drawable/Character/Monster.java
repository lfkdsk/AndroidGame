package com.lfk.killit.Drawable.Character;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.lfk.killit.Data.Loacl.Location;
import com.lfk.killit.Pic.MBitmap;

/**
 * Created by liufengkai on 15/11/3.
 */
public class Monster implements Character {
    private Rect rect;
    private int mX, mY;
    private Location mLocation;
    private MBitmap mBitmap;
    private Canvas canvas = null;
    private String mName;



    @Override
    public Rect getRect() {
        return rect;
    }

    @Override
    public int getmX() {
        return mX;
    }

    @Override
    public int getmY() {
        return mY;
    }

    @Override
    public Location getLocation() {
        return mLocation;
    }

    @Override
    public MBitmap getBitmap() {
        return mBitmap;
    }

    @Override
    public void DrawIt() {

    }
}
