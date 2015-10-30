package com.lfk.killit.Pic;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.lfk.killit.UI.UIDefaultData;
import com.orhanobut.logger.Logger;

/**
 * Created by liufengkai on 15/10/30.
 */
public class AbsoluteBitmap implements MBitmap {
    private Bitmap bitmap;
    private MBitmapFactory mBitmapFactory;

    public AbsoluteBitmap(int id) {
        mBitmapFactory = new DefaultBitmapFactory();
        bitmap = mBitmapFactory.createBitmap(id);
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

    @Override
    public void draw(Canvas canvas, int cx, int cy, int alpha) {
        if (cx + bitmap.getWidth() >= 0 &&
                cx < UIDefaultData.f_x_screen &&
                cy >= 0 &&
                cy < UIDefaultData.f_y_screen) {
            canvas.drawBitmap(bitmap, cx, cy, null);
        } else {
            Logger.d("绘图越界");
        }
    }
}
