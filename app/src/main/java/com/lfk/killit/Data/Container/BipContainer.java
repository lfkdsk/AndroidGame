package com.lfk.killit.Data.Container;

import android.content.Context;

import com.lfk.killit.Pic.AbsoluteBitmap;
import com.lfk.killit.Pic.MBitmap;
import com.lfk.killit.R;
import com.lfk.killit.UI.UIDefaultData;
import com.lfk.killit.Utils.MemoryCache;
import com.lfk.killit.Utils.PicUtils;

/**
 * Created by liufengkai on 15/10/31.
 */
public class BipContainer {
    private MemoryCache mBitmapMap;
    private MemoryCache logobitmaps;

    public BipContainer() {
        this.mBitmapMap = new MemoryCache();
        this.logobitmaps = new MemoryCache();
    }

    public void initLogoPic() {
        mBitmapMap.put("logo", new AbsoluteBitmap(R.drawable.logo));
        mBitmapMap.put("left_button", new AbsoluteBitmap(R.drawable.iconfont_arrowleft));
        mBitmapMap.put("right_button", new AbsoluteBitmap(R.drawable.iconfont_arrowright));
        mBitmapMap.put("hit_button", new AbsoluteBitmap(R.drawable.iconfont_hit));
        // player left
        mBitmapMap.put("player_left_1", new AbsoluteBitmap(R.drawable.player_left_1));
        mBitmapMap.put("player_left_2", new AbsoluteBitmap(R.drawable.player_left_2));
        mBitmapMap.put("player_left_3", new AbsoluteBitmap(R.drawable.player_left_3));
        mBitmapMap.put("player_left_4", new AbsoluteBitmap(R.drawable.player_left_4));
        mBitmapMap.put("player_left_5", new AbsoluteBitmap(R.drawable.player_left_5));

        // player right
        mBitmapMap.put("player_right_1", new AbsoluteBitmap(R.drawable.player_right_1));
        mBitmapMap.put("player_right_2", new AbsoluteBitmap(R.drawable.player_right_2));
        mBitmapMap.put("player_right_3", new AbsoluteBitmap(R.drawable.player_right_3));
        mBitmapMap.put("player_right_4", new AbsoluteBitmap(R.drawable.player_right_4));
        mBitmapMap.put("player_right_5", new AbsoluteBitmap(R.drawable.player_right_5));

        // background
        mBitmapMap.put("background", new AbsoluteBitmap(R.drawable.bg));
    }

    public void initlogoBits(Context context) {
        for (int i = 0; i < UIDefaultData.logoAnim.length; i++) {
            logobitmaps.put("logo_" + i, new AbsoluteBitmap(
                    PicUtils.drawable2Bitmap(context.getResources()
                            .getDrawable(UIDefaultData.logoAnim[i]))));
        }
    }

    public MemoryCache getLogobitmaps() {
        return logobitmaps;
    }

    public MemoryCache getmBitmapMap(){
        return mBitmapMap;
    }

    public MBitmap getBitmap(String name) {
        return mBitmapMap.get(name);
    }

    public void deleteLogo() {
        logobitmaps.clearCache();
        logobitmaps = null;
    }

    public void removeBitmap(String name) {
        mBitmapMap.remove(name);
    }
}
