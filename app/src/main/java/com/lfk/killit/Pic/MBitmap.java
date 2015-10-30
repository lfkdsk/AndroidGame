package com.lfk.killit.Pic;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by liufengkai on 15/10/30.
 */
public interface MBitmap {
    int getWidth();

    int getHeight();

    Bitmap getBitmap();

    void draw(Canvas canvas, int cx, int cy, int alpha);
}
