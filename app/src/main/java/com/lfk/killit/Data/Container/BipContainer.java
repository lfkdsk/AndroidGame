package com.lfk.killit.Data.Container;

import com.lfk.killit.Pic.AbsoluteBitmap;
import com.lfk.killit.Pic.MBitmap;
import com.lfk.killit.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liufengkai on 15/10/31.
 */
public class BipContainer {
    private Map<String, MBitmap> mBitmapMap;

    public BipContainer() {
        this.mBitmapMap = new HashMap<>();
    }

    public void initPic() {
        mBitmapMap.put("logo", new AbsoluteBitmap(R.drawable.logo));
    }

    public MBitmap getBitmap(String name) {
        return mBitmapMap.get(name);
    }

}
