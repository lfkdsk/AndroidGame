package com.lfk.killit.Data.Container;

import android.content.Context;
import android.graphics.Bitmap;

import com.lfk.killit.Pic.AbsoluteBitmap;
import com.lfk.killit.Pic.MBitmap;
import com.lfk.killit.R;
import com.lfk.killit.UI.UIDefaultData;
import com.lfk.killit.Utils.PicUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liufengkai on 15/10/31.
 */
public class BipContainer {
    private Map<String, MBitmap> mBitmapMap;
    private List<Bitmap> logobitmaps;

    public BipContainer() {
        this.mBitmapMap = new HashMap<>();
        this.logobitmaps = new ArrayList<>();
    }

    public void initLogoPic() {
        mBitmapMap.put("logo", new AbsoluteBitmap(R.drawable.logo));
        mBitmapMap.put("left_button", new AbsoluteBitmap(R.drawable.iconfont_arrowleft));
        mBitmapMap.put("right_button", new AbsoluteBitmap(R.drawable.iconfont_arrowright));
        mBitmapMap.put("hit_it", new AbsoluteBitmap(R.drawable.iconfont_hit));
        mBitmapMap.put("left_player", new AbsoluteBitmap(R.drawable.left_1));
        mBitmapMap.put("right_player", new AbsoluteBitmap(R.drawable.right_1));
        mBitmapMap.put("background", new AbsoluteBitmap(R.drawable.bg));
    }

    public void initlogoBits(Context context) {
        for (int i = 0; i < UIDefaultData.logoAnim.length; i++){
            logobitmaps.add(PicUtils.drawable2Bitmap(context.getResources().getDrawable(UIDefaultData.logoAnim[i])));
        }
    }

    public List<Bitmap> getLogobitmaps() {
        return logobitmaps;
    }

    public MBitmap getBitmap(String name) {
        return mBitmapMap.get(name);
    }

}
