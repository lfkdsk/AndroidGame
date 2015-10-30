package com.lfk.killit.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.lfk.killit.MainActivity;
import com.lfk.killit.Pic.AbsoluteBitmap;
import com.lfk.killit.R;
import com.lfk.killit.UI.UIDefaultData;
import com.orhanobut.logger.Logger;

/**
 * Created by liufengkai on 15/10/30.
 */
public class WelcomeView extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceHolder holder;
    private MainActivity activity;
    private AbsoluteBitmap logo;
    private boolean flag = true;
    private DrawBG drawBG;
    private LoadBitmap loadBitmap;

    public WelcomeView(Context context) {
        super(context);
    }

    public WelcomeView(MainActivity activity) {
        super(activity.getApplicationContext());
        this.activity = activity;

        this.holder = this.getHolder();
        holder.addCallback(this);

        drawBG = new DrawBG();
        loadBitmap = new LoadBitmap();

        initPic();
    }

    private void initPic(){
        logo = new AbsoluteBitmap(R.drawable.logo);
    }

    public void onDraw(Canvas canvas){
        if (logo == null) return;

        canvas.drawColor(Color.WHITE);
        logo.draw(canvas,
                (int)(UIDefaultData.f_x_screen - logo.getWidth()) / 2,
                (int)(UIDefaultData.f_y_screen - logo.getHeight()) / 2,
                255);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        drawBG.start();
        loadBitmap.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    private class DrawBG extends Thread{
        @Override
        public void run() {
            super.run();
            SurfaceHolder myHolder = WelcomeView.this.getHolder();
            Canvas canvas = myHolder.lockCanvas();                        //获取画布
            try {
                synchronized (myHolder) {
                    WelcomeView.this.onDraw(canvas);                        //绘制
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (canvas != null)
                    myHolder.unlockCanvasAndPost(canvas);
            }
            while (flag){}

        }
    }


    private class LoadBitmap extends Thread {
        public void run() {
            // load something
            Logger.d("load over");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            flag = false;
        }
    }
}
