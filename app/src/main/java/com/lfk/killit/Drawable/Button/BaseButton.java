package com.lfk.killit.Drawable.Button;

import android.graphics.Rect;

/**
 * Created by liufengkai on 15/10/31.
 */
public interface BaseButton {
    int NORMAL = 0;                    //正常状态
    int CLICKED = 1;                   //点击状态
    int DRAGGED = 2;                   //拖曳状态
    int COLDING = 3;                   //冷却状态
    int LOCKED = 4;                    //封锁状态

    int getState();

    void setState(int state);

    Rect getRect();

    void drawIt();
}
