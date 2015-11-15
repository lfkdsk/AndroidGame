package com.lfk.killit.UI;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.lfk.killit.Data.Container.BipContainer;
import com.lfk.killit.Data.Container.Constant;
import com.lfk.killit.Drawable.Button.SimpleButton;
import com.lfk.killit.R;

import java.util.Map;

/**
 * Created by liufengkai on 15/10/30.
 */
public class UIDefaultData {
    public static Resources res; // 获取Resources
    public static int f_scales;// 放缩比例
    public static float f_y_screen;//
    public static float f_x_screen;

    public static BipContainer container_bmp;                                 //存储所有位图资源
    public static Constant constant_button;
    public static Map<String,SimpleButton> list;
    public static final int DRAW_INTERVAL = 35;       // 绘图时间间隔

    public static final int SKILL_INTERVAL = 60;      // 技能时间间隔

    public static int[] logoAnim = {R.drawable.logo_1,
            R.drawable.logo_2, R.drawable.logo_3,
            R.drawable.logo_4, R.drawable.logo_5,
            R.drawable.logo_6, R.drawable.logo_7,
            R.drawable.logo_8, R.drawable.logo_9,
            R.drawable.logo_10, R.drawable.logo_11,
            R.drawable.logo_12, R.drawable.logo_13,
            R.drawable.logo_14, R.drawable.logo_15,
            R.drawable.logo_16, R.drawable.logo_17,
            R.drawable.logo_18, R.drawable.logo_19,
            R.drawable.logo_20, R.drawable.logo_21,
            R.drawable.logo_22, R.drawable.logo_23,
            R.drawable.logo_24, R.drawable.logo_25,
            R.drawable.logo_26, R.drawable.logo_27,
            R.drawable.logo_28, R.drawable.logo_29,
            R.drawable.logo_30, R.drawable.logo_31,
            R.drawable.logo_32, R.drawable.logo_33,
            R.drawable.logo_34, R.drawable.logo_35,
            R.drawable.logo_36, R.drawable.logo_37,
            R.drawable.logo_38, R.drawable.logo_39,
            R.drawable.logo_40, R.drawable.logo_41,
            R.drawable.logo_42, R.drawable.logo_43,
            R.drawable.logo_44, R.drawable.logo_45,
            R.drawable.logo_46, R.drawable.logo_47,
            R.drawable.logo_48, R.drawable.logo_49,
            R.drawable.logo_50, R.drawable.logo_51,
            R.drawable.logo_52, R.drawable.logo_53,
            R.drawable.logo_53, R.drawable.logo_54,
            R.drawable.logo_55, R.drawable.logo_56,
            R.drawable.logo_57, R.drawable.logo_58,
            R.drawable.logo_59, R.drawable.logo_60,
            R.drawable.logo_61, R.drawable.logo_62,
            R.drawable.logo_63, R.drawable.logo_64,
            R.drawable.logo_65, R.drawable.logo_66
    };

    public static void initScales() {
        Bitmap test = BitmapFactory.decodeResource(res, R.mipmap.ic_launcher);
        float temp = 1;
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
        f_scales = (int) temp;
        System.out.println("放缩比例" + f_scales);
    }

    public static void initButton() {
        list = UIDefaultData.constant_button.getSimpleButtons();
    }

}
