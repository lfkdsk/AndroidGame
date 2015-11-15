package com.lfk.killit.Drawable.Character;

import android.graphics.Rect;

import com.lfk.killit.Data.Loacl.Location;
import com.lfk.killit.Pic.MBitmap;

/**
 * Created by liufengkai on 15/11/1.
 */
public interface Character {
    int LEFT = 0;
    int RIGHT = 1;

    Rect getRect();

    int getmX();

    int getmY();

    Location getLocation();

    MBitmap getBitmap();

    void DrawIt();
}
