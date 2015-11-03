package com.lfk.killit.Utils;

import android.util.Log;
import android.util.LruCache;

import com.lfk.killit.Pic.MBitmap;

/**
 * Created by liufengkai on 15/11/2.
 */
public class MemoryCache {
    private LruCache<String, MBitmap> mMemoryCache;

    /**
     * LruCache初始化
     */
    public MemoryCache() {
        int maxMemory = (int) Runtime.getRuntime().maxMemory();
        int cacheSize = maxMemory / 8;
        mMemoryCache = new LruCache<String, MBitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, MBitmap value) {
                return super.sizeOf(key, value);
            }
        };
    }

    /**
     * 添加照片进入LruCache
     * @param key
     * @param bitmap
     */
    public void put(String key, MBitmap bitmap) {
        if (get(key) == null) {
            mMemoryCache.put(key, bitmap);
        }
    }

    /**
     * 取出照片
     * @param key
     * @return
     */
    public MBitmap get(String key) {
        return mMemoryCache.get(key);
    }

    public int size(){
        return mMemoryCache.size();
    }

    public void clearCache() {
        if (mMemoryCache != null) {
            if (mMemoryCache.size() > 0) {
                Log.d("CacheUtils",
                        "mMemoryCache.size() " + mMemoryCache.size());
                mMemoryCache.evictAll();
                Log.d("CacheUtils", "mMemoryCache.size()" + mMemoryCache.size());
            }
            mMemoryCache = null;
        }
    }

    public void remove(String name){
        mMemoryCache.remove(name);
    }
}
