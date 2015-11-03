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
        mBitmapMap.put("hit_it", new AbsoluteBitmap(R.drawable.iconfont_hit));
        mBitmapMap.put("left_player", new AbsoluteBitmap(R.drawable.left_1));
        mBitmapMap.put("right_player", new AbsoluteBitmap(R.drawable.right_1));
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

    public MBitmap getBitmap(String name) {
        return mBitmapMap.get(name);
    }

    public void deleteLogo() {
        logobitmaps.clearCache();
        logobitmaps = null;
    }

    public void removeBitmap(String name){
        mBitmapMap.remove(name);
    }
}
