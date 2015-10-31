package com.lfk.killit.Animation;

import android.graphics.Canvas;
import android.graphics.Rect;

import com.lfk.killit.Pic.MBitmap;
import com.orhanobut.logger.Logger;

/**
 * Created by liufengkai on 15/10/30.
 */
public class smallToenlargeAnimation implements MAnimation {
    private MBitmap bitmap;
    private int enlarge_state = 0;      // 获取当前状态
    private int enlarge_frame = 3;      // 一共3frame
    private int enlarge_scale = 0;
    private int enlarge_current_frame = 0;
    private int i_control = 0;
    private Rect rect;

    public smallToenlargeAnimation(MBitmap bitmap) {
        this.bitmap = bitmap;
        rect = new Rect();
    }

    public smallToenlargeAnimation() {

    }

    public boolean isEndAnCirculation() {
        if (enlarge_state == 1)
            return true;
        return false;
    }

    public boolean isEnd() {
        if (enlarge_state == -1)
            return true;
        return false;
    }

    public void restore() {
        enlarge_current_frame = 0;
        enlarge_state = 2;
    }

    public void end() {
        enlarge_current_frame = 4;
        enlarge_state = -1;
    }

    @Override
    public void start() {
        enlarge_state = 2;
        enlarge_scale = 0;
        enlarge_current_frame = 0;
    }

    @Override
    public void nextFrame() {

        //控制播放进度
        i_control += 35;
        if (i_control >= 35) {
            i_control -= 35;
            enlarge_current_frame++;
            if (enlarge_state == 2) {
                enlarge();
            } else if (enlarge_state == 0 || enlarge_state == 1) {
                shrink();
            }
        }
    }

    public void enlarge() {
        //放大过程结束，则整个动画结束
        if (enlarge_current_frame >= enlarge_frame || enlarge_scale == 0) {
            enlarge_current_frame = 0;
            enlarge_state = -1;
            enlarge_scale = 0;
            return;
        }
        //减小要缩小的数值
        int temp = (int) (bitmap.getWidth() * 0.03);
        if (temp == 0)
            temp = 1;
        enlarge_scale -= temp;
        if (enlarge_scale < 0)
            enlarge_scale = 0;
    }

    public void shrink() {
        if (enlarge_state == 0)
            enlarge_state = 1;
        //缩小动画结束，则保持最小图片状态
        if (enlarge_current_frame >= enlarge_frame) {
            enlarge_current_frame = enlarge_frame - 1;
            return;
        }
        //增大要缩小的数值
        else {
            int temp = (int) (bitmap.getWidth() * 0.03);
            if (temp == 0)
                temp = 1;
            enlarge_scale += temp;
        }
    }

    @Override
    public void setBitmap(MBitmap bitmap) {
        this.bitmap = bitmap;
    }

    @Override
    public void draw(Canvas canvas, int x, int y) {
        while (enlarge_current_frame < enlarge_frame) {
            rect.top = y + enlarge_scale;
            rect.bottom = y + bitmap.getHeight() - enlarge_scale;
            rect.left = x + enlarge_scale;
            rect.right = x + bitmap.getWidth() - enlarge_scale;
            canvas.drawBitmap(bitmap.getBitmap(), null, rect, null);
            Logger.d("进入动画");
            nextFrame();
        }
    }


}
