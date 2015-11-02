package com.lfk.killit.Pic;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.lfk.killit.Animation.MAnimation;

/**
 * Created by liufengkai on 15/11/2.
 */
public class LocalBitmaps implements MBitmap {
    private Bitmap bitmap;
    private MBitmapFactory mBitmapFactory;
    private MAnimation animation;
    private int mX, mY;
    private Canvas canvas;

    public LocalBitmaps(int id, int mX, int mY) {
        mBitmapFactory = new DefaultBitmapFactory();
        bitmap = mBitmapFactory.createBitmap(id);
        this.mX = mX - bitmap.getWidth() / 2;
        this.mY = mY - bitmap.getHeight() / 2;
    }

    @Override
    public int getWidth() {
        return bitmap.getWidth();
    }

    @Override
    public int getHeight() {
        return bitmap.getHeight();
    }

    @Override
    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public void DrawIt() {
        canvas.drawBitmap(bitmap, mX, mY, null);
    }

    @Override
    public void draw(Canvas canvas, int cx, int cy, int alpha) {

    }
}
