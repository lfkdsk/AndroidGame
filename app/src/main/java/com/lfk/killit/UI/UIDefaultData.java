package com.lfk.killit.UI;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.lfk.killit.R;

/**
 * Created by liufengkai on 15/10/30.
 */
public class UIDefaultData {
    public static Resources res; // 获取Resources
    public static int f_scales;// 放缩比例
    public static float f_y_screen;//
    public static float f_x_screen;


    public static void initScales() {
        Bitmap test = BitmapFactory.decodeResource(res, R.mipmap.ic_launcher);
        float temp = 0;
        switch (test.getHeight()) {
            case 48:
            case 32:
                temp = f_y_screen / 320;
                break;
            case 72:
                temp = f_y_screen / 480;
                break;
            case 96:
                temp = f_y_screen / 640;
                break;
        }
        f_scales = (int)temp;
        System.out.println("放缩比例" + f_scales);
    }
}
