package com.lfk.killit.Animation;

import android.graphics.Canvas;

import com.lfk.killit.Pic.MBitmap;

/**
 * Created by liufengkai on 15/10/30.
 */
public class enlargeAnimation implements MAnimation {
    private MBitmap bitmap;
    private int enlarge_state;      // 获取当前状态
    private int enlarge_frame;
    public enlargeAnimation(MBitmap bitmap) {
        this.bitmap = bitmap;
    }

    @Override
    public void start() {

    }

    @Override
    public void nextFrame() {

    }

    @Override
    public void draw(Canvas canvas, int x, int y) {

    }
}
