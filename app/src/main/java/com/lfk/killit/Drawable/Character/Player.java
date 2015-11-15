package com.lfk.killit.Drawable.Character;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.lfk.killit.Animation.MAnimation;
import com.lfk.killit.Animation.SkillAnimation;
import com.lfk.killit.Data.Loacl.Location;
import com.lfk.killit.Pic.MBitmap;
import com.lfk.killit.UI.UIDefaultData;
import com.orhanobut.logger.Logger;

import java.util.HashMap;
import java.util.Map;

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
    private boolean kill_it = false;
    private MAnimation mAnimation;
    private int direction = Character.RIGHT;
    private Map<String, SkillAnimation> skillAnimationMap;


    public Player(String mName, int mX, int mY) {
        this.mName = mName;
        this.mBitmap = UIDefaultData.container_bmp.getBitmap(mName + "right_1");
        rect = new Rect(mX - mBitmap.getWidth() / 2, mY - mBitmap.getHeight() / 2,
                mX + mBitmap.getWidth(), mY + mBitmap.getHeight());
        skillAnimationMap = new HashMap<>();
        Logger.e("player:" + "x:" + mX + "y:" + mY);
        skillAnimationMap.put("player_left_kill", new SkillAnimation("player_left_", 5,
                100,rect));
        skillAnimationMap.put("player_right_kill", new SkillAnimation("player_right_", 5,
                100,rect));
        this.mY = mY - mBitmap.getHeight() / 2;
        this.mX = mX - mBitmap.getWidth() / 2;
        Logger.e("player:"+"x:" + this.mX +"y:"+ this.mY);
        this.mLocation = new Location(mX, mY, mName);

    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public void setBitmap(MBitmap mBitmap) {
        this.mBitmap = mBitmap;
    }

    public void changeDirection(int type) {
        if (type == Character.LEFT) {
            setBitmap(UIDefaultData.container_bmp.getBitmap(mName + "left_1"));
            direction = Character.LEFT;
        } else if (type == Character.RIGHT) {
            setBitmap(UIDefaultData.container_bmp.getBitmap(mName + "right_1"));
            direction = Character.RIGHT;
        }
    }

    public void killIt() {
        kill_it = true;
        if (direction == Character.LEFT) {
            mAnimation = skillAnimationMap.get("player_left_kill");
        } else if (direction == Character.RIGHT) {
            mAnimation = skillAnimationMap.get("player_right_kill");
        }
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
    public MBitmap getBitmap() {
        return mBitmap;
    }

    @Override
    public void DrawIt() {
        if (kill_it) {
            if (mAnimation.isEnd())
                mAnimation.start();
            mAnimation.draw(canvas);
            if (mAnimation.isEnd())
                kill_it = false;
        } else {
            canvas.drawBitmap(mBitmap.getBitmap(), null, rect, null);
        }
    }
}
