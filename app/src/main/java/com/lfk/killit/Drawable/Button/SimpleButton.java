package com.lfk.killit.Drawable.Button;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.lfk.killit.Animation.EnlargeAnimation;
import com.lfk.killit.Data.Loacl.Location;
import com.lfk.killit.Pic.MBitmap;
import com.lfk.killit.UI.UIDefaultData;
import com.orhanobut.logger.Logger;

/**
 * Created by liufengkai on 15/10/31.
 */
public class SimpleButton implements BaseButton {
    private int state;
    private Rect rect;
    private int mX, mY;
    private Location mLocation;
    private EnlargeAnimation mAnimation;
    private String mName;
    private Canvas canvas = null;
    private MBitmap mBitmap;

    public SimpleButton(String mName, int mY, int mX) {
        this.mName = mName;
        this.mBitmap = UIDefaultData.container_bmp.getBitmap(mName);
        this.mY = mY - mBitmap.getHeight() / 2;
        this.mX = mX - mBitmap.getWidth() / 2;
        this.mAnimation = new EnlargeAnimation(mBitmap);
        this.mLocation = new Location(mX, mY, mName);
        rect = new Rect(mX - mBitmap.getWidth() / 2, mY - mBitmap.getHeight() / 2,
                mX + mBitmap.getWidth(), mY + mBitmap.getHeight());
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
    public Location getLocation() {
        return mLocation;
    }

    @Override
    public Rect getRect() {
        return rect;
    }

    @Override
    public String getName() {
        return mName;
    }

    public Location getmLocation() {
        return mLocation;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }


    @Override
    public void drawIt() {
        if (canvas == null) {
            Logger.d("canvas = null");
            return;
        }
        switch (state) {
            case NORMAL:
                if (!mAnimation.isEnd()) {
                    if (mAnimation.isEndAnCirculation())
                        mAnimation.restore();
                    mAnimation.draw(canvas, mX, mY);
                } else
                    mAnimation.getBitmap().draw(canvas, mX, mY, 255);
                break;
            case CLICKED:
                if (mAnimation.isEnd())
                    mAnimation.start();
                mAnimation.draw(canvas, mX, mY);
                break;
        }
    }


}
