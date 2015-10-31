package com.lfk.killit.Animation;

import android.graphics.Canvas;

import com.lfk.killit.Pic.MBitmap;

/**
 * Created by liufengkai on 15/10/30.
 */
public interface MAnimation {
    void start();
    void nextFrame();
    void setBitmap(MBitmap bitmap);
    void draw(Canvas canvas,int x,int y);
    boolean isEnd();
    boolean isEndAnCirculation();
    void end();
}
