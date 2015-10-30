package com.lfk.killit.Animation;

import android.graphics.Canvas;

/**
 * Created by liufengkai on 15/10/30.
 */
public interface MAnimation {
    void start();
    void nextFrame();
    void draw(Canvas canvas,int x,int y);
}
