package com.lfk.killit.View;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.lfk.killit.Main.MainActivity;

/**
 * Created by liufengkai on 15/10/30.
 */
public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private MainActivity activity;


    public GameView(Context context) {
        super(context);
    }

    public GameView(MainActivity activity){
        super(activity.getApplicationContext());
        this.activity = activity;

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
