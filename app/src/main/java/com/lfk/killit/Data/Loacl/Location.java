package com.lfk.killit.Data.Loacl;

/**
 * Created by liufengkai on 15/10/31.
 */
public class Location {
    private int mX;
    private int mY;
    private String name;

    public Location(int mX, int mY, String name) {
        this.mX = mX;
        this.mY = mY;
        this.name = name;
    }

    public int getmX() {
        return mX;
    }

    public int getmY() {
        return mY;
    }

    public String getName() {
        return name;
    }

    public void setmX(int mX) {
        this.mX = mX;
    }

    public void setmY(int mY) {
        this.mY = mY;
    }

    public void setName(String name) {
        this.name = name;
    }
}
