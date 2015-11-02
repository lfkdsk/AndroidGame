package com.lfk.killit.Drawable.Character;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.lfk.killit.Data.Loacl.Location;
import com.lfk.killit.Pic.MBitmap;
import com.lfk.killit.UI.UIDefaultData;

/**
 * Created by liufengkai on 15/11/1.
 */
public class Player implements Character {
    private Rect rect;
    private int mX, mY;
    private Location mLocation;
    private MBitmap mBitmap;
    private Canvas canvas = null;
    private String mName;

    public Player(String mName, int mX, int mY) {
        this.mName = mName;
        this.mBitmap = UIDefaultData.container_bmp.getBitmap(mName);
        this.mY = mY - mBitmap.getHeight() / 2;
        this.mX = mX - mBitmap.getWidth() / 2;
        this.mLocation = new Location(mX, mY, mName);
        rect = new Rect(mX - mBitmap.getWidth() / 2, mY - mBitmap.getHeight() / 2,
                mX + mBitmap.getWidth(), mY + mBitmap.getHeight());
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public void setmBitmap(MBitmap mBitmap) {
        this.mBitmap = mBitmap;
    }

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
    public MBitmap getmBitmap() {
        return mBitmap;
    }

    @Override
    public void DrawIt() {
        canvas.drawBitmap(mBitmap.getBitmap(), null, rect, null);
    }
}
