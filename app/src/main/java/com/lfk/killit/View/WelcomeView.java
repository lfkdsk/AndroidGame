package com.lfk.killit.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.lfk.killit.Drawable.Button.BaseButton;
import com.lfk.killit.Drawable.Button.SimpleButton;
import com.lfk.killit.Main.MainActivity;
import com.lfk.killit.Pic.LocalBitmaps;
import com.lfk.killit.R;
import com.lfk.killit.UI.UIDefaultData;
import com.orhanobut.logger.Logger;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by liufengkai on 15/10/30.
 */
public class WelcomeView extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceHolder holder;
    private MainActivity activity;
    //    private AbsoluteBitmap logo;
    private boolean flag = true;
    private DrawBG drawBG;
    private LoadBitmap loadBitmap;
    private SimpleButton simpleButton;
    private BaseButton button = null;
    private boolean hitbutton = false;
    private LocalBitmaps mBitmap;

    public WelcomeView(Context context) {
        super(context);
    }

    public WelcomeView(MainActivity activity) {
        super(activity.getApplicationContext());
        this.activity = activity;

        this.holder = this.getHolder();
        holder.addCallback(this);

        this.mBitmap = new LocalBitmaps(R.drawable.logo_10,
                (int) UIDefaultData.f_x_screen / 2,
                (int) UIDefaultData.f_y_screen / 2);

        initPic();
    }

    private void initPic() {
        simpleButton = UIDefaultData.constant_button.getSimpleButtons().get("logo");
        Rect rect = simpleButton.getRect();
        Logger.d(rect.top + " " + rect.right + " "
                + rect.bottom + " " + rect.left);
//        logo = new AbsoluteBitmap(R.drawable.logo);
//        mAnimation = new EnlargeAnimation(logo);
    }

    public void DrawIt(Canvas canvas) {
//        if (logo == null) return;

        canvas.drawColor(Color.WHITE);
        simpleButton.setCanvas(canvas);
//        simpleButton.setState(BaseButton.NORMAL);
        simpleButton.drawIt();
//        logo.draw(canvas,
//                (int) (UIDefaultData.f_x_screen  logo.getWidth()) / 2,
//                (int) (UIDefaultData.f_y_screen  logo.getHeight()) / 2,
//                255);
//        mAnimation.start();
//
//        mAnimation.draw(canvas, (int) (UIDefaultData.f_x_screen  logo.getWidth()) / 2,
//                (int) (UIDefaultData.f_y_screen  logo.getHeight()) / 2);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
//        drawBG = new DrawBG();
//        drawBG.setWork(false);
        loadBitmap = new LoadBitmap();
        loadBitmap.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    private class DrawBG extends Thread {
        private boolean flag = true;
        private boolean work = false;

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

        public void setWork(boolean work) {
            this.work = work;
        }

        private void draw() {
            //获取画布
            Canvas canvas = holder.lockCanvas();
            try {
                synchronized (holder) {
                    WelcomeView.this.DrawIt(canvas);                        //绘制
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (canvas != null)
                    holder.unlockCanvasAndPost(canvas);
            }
        }

        @Override
        public void run() {
            super.run();
            while (flag) {
                if (work) {
                    long begin_time = System.currentTimeMillis();
                    draw();
                    long end_time = System.currentTimeMillis();
                    //控制帧数
                    if (end_time - begin_time < 60)
                        try {
                            Thread.sleep(60 - (end_time - begin_time));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                }
            }
        }
    }


    private class LoadBitmap extends Thread {
        private void draw(Canvas canvas) {

        }

        public void run() {
            // load something
            Canvas canvas = holder.lockCanvas();
            mBitmap.setCanvas(canvas);
            try {
                canvas.drawColor(Color.WHITE);
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    int i = 0;
                    @Override
                    public void run() {
                        if (i < 65) {
                            mBitmap.setBitmap(UIDefaultData.container_bmp.getLogobitmaps().get(i));
                            mBitmap.DrawIt();
                            i++;
                            Log.e("i:",i+"");
                        }
                    }
                }, 100, 100);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (canvas != null)
                    holder.unlockCanvasAndPost(canvas);
            }
            Logger.d("load over");
//            drawBG.setWork(true);
//            mBitmap = null;
//            try {
//                Thread.sleep(1000);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Set set = UIDefaultData.list.entrySet();
                Iterator iterator = set.iterator();
                for (int i = 0; i < UIDefaultData.list.size(); i++) {
                    Map.Entry mapEntry = (Map.Entry) iterator.next();
                    if (mapEntry.getKey().equals("logo") &&
                            ((SimpleButton) mapEntry.getValue()).
                                    getRect().contains((int) event.getX(),
                                    (int) event.getY())) {
                        ((SimpleButton) mapEntry.getValue()).setState(BaseButton.CLICKED);
                        button = (SimpleButton) mapEntry.getValue();
                        hitbutton = true;
                    } else {
                        Logger.e(event.getX() + " " + event.getY());
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                if (hitbutton && button.getRect().contains((int) event.getX(), (int) event.getY())) {
                    button.setState(BaseButton.NORMAL);
                    onClicked(button.getName());
                    button = null;
                } else if (hitbutton) {
                    button.setState(BaseButton.NORMAL);
                    button = null;
                }
                hitbutton = false;
                break;
        }
        return true;
    }

    private void onClicked(String name) {
        if (name.equals("logo")) {
            activity.sendMessage(1);

            drawBG.setFlag(false);
            drawBG.setWork(false);
        }
    }

    public void startIt() {
//        drawBG.setFlag(true);
//        drawBG.setWork(true);
    }

}
