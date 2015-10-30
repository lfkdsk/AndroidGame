package com.lfk.killit.Pic;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;

import com.lfk.killit.UI.UIDefaultData;

/**
 * Created by liufengkai on 15/10/30.
 */
public class DefaultBitmapFactory implements MBitmapFactory {
    @Override
    public Bitmap createBitmap(int id) {
        Bitmap bmp_org = BitmapFactory.decodeResource(UIDefaultData.res, id);
        int width = bmp_org.getWidth();
        int height = bmp_org.getHeight();
        return ThumbnailUtils.extractThumbnail(
                bmp_org,
                width * UIDefaultData.f_scales,
                height * UIDefaultData.f_scales,
                ThumbnailUtils.OPTIONS_RECYCLE_INPUT);
    }
}
