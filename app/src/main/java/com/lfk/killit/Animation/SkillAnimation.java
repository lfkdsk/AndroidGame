package com.lfk.killit.Animation;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.lfk.killit.Pic.MBitmap;
import com.lfk.killit.UI.UIDefaultData;
import com.lfk.killit.Utils.MemoryCache;
import com.orhanobut.logger.Logger;

/**
 * Created by liufengkai on 15/11/3.
 */
public class SkillAnimation implements MAnimation {
    private int i_frame;
    private int i_current_frame = 0; // 当前frame
    private int i_control = 0;       // 控制
    private int i_interval;          //每帧间隔时间（大于35ms）
    private Rect rect;
    private MemoryCache bitmaps;
    private String name;
    private MBitmap mBitmap;

    public SkillAnimation(String name, int number, int interval, Rect rect) {
        this.bitmaps = UIDefaultData.container_bmp.getmBitmapMap();
        this.i_interval = interval;
        this.i_current_frame = -1;
        this.i_control = 0;
        this.name = name;
        this.i_frame = number;
        this.rect = rect;
    }

    public SkillAnimation(MAnimation mAnimation) {
        this.bitmaps = UIDefaultData.container_bmp.getLogobitmaps();
        this.i_interval = mAnimation.getInterval();
        this.i_current_frame = -1;
        this.i_control = 0;
        this.name = mAnimation.getName();
        this.i_frame = mAnimation.getFrame();
    }

    @Override
    public void start() {
        i_control = i_current_frame = 0;
    }

    @Override
    public void nextFrame() {
        // 控制播放进度
        i_control += UIDefaultData.DRAW_INTERVAL;
        Logger.e("i_control:" + i_control + "time:" +System.currentTimeMillis());
        if (i_control >= i_interval) {
            Logger.e("i_control:" + i_control + "time:" +System.currentTimeMillis());
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
            i_current_frame++;
            mBitmap = bitmaps.get(name + i_current_frame);
            if(i_current_frame <= 5)
                canvas.drawBitmap(mBitmap.getBitmap(), null, rect, null);
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
