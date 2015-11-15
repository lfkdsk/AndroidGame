package com.lfk.killit.Animation;

import android.graphics.Canvas;

import com.lfk.killit.Pic.MBitmap;
import com.lfk.killit.UI.UIDefaultData;
import com.lfk.killit.Utils.MemoryCache;

/**
 * Created by liufengkai on 15/11/2.
 */
public class DisposableAnimation implements MAnimation {
    private int i_frame;      // 一共3frame
    private int i_current_frame = 0;// 当前frame
    private int i_control = 0;    // 控制
    private int i_interval;     //每帧间隔时间（大于35ms）
    private int mX, mY;
    private MemoryCache bitmaps;
    private String name;
    private MBitmap mBitmap;

    public DisposableAnimation(String name, int number, int interval, int mX, int mY) {
        this.bitmaps = UIDefaultData.container_bmp.getLogobitmaps();
        this.i_interval = interval;
        i_current_frame = -1;
        i_control = 0;
        this.name = name;
        i_frame = number;
        this.mX = mX - bitmaps.get(name + 1).getWidth() / 2;
        this.mY = mY - bitmaps.get(name + 1).getHeight() / 2;
    }

    public DisposableAnimation(MAnimation mAnimation) {
        this.bitmaps = UIDefaultData.container_bmp.getLogobitmaps();
        this.i_interval = mAnimation.getInterval();
        i_current_frame = -1;
        i_control = 0;
        this.name = mAnimation.getName();
        i_frame = mAnimation.getFrame();
        this.mX = mX - bitmaps.get(name + 1).getWidth() / 2;
        this.mY = mY - bitmaps.get(name + 1).getHeight() / 2;
    }

    @Override
    public void start() {
        i_control = i_current_frame = 0;
    }

    @Override
    public void nextFrame() {
        // 控制播放进度
        i_control += UIDefaultData.DRAW_INTERVAL;
        if (i_control >= i_interval) {
            bitmaps.remove(name + i_current_frame);
            i_current_frame++;
            i_control -= i_interval;
        }
        // 判断是否播放完
        if (i_current_frame >= i_frame)
            i_current_frame = -1;
    }

    @Override
    public void setBitmap(MBitmap bitmap) {

    }

    @Override
    public void draw(Canvas canvas) {
        if (i_current_frame < i_frame && i_current_frame >= 0) {
            mBitmap = null;
            mBitmap = bitmaps.get(name + i_current_frame);
            mBitmap.draw(canvas, mX, mY, 255);
            bitmaps.remove(name + i_current_frame);
            nextFrame();
        } else {
            end();
        }
    }


    @Override
    public boolean isEnd() {
        if (i_current_frame == -1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isEndAnCirculation() {
        return isEnd();
    }

    @Override
    public void end() {
        i_current_frame = -1;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getFrame() {
        return i_current_frame;
    }

    @Override
    public int getInterval() {
        return i_interval;
    }
}
