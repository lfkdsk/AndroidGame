package com.lfk.killit.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.lfk.killit.Data.Loacl.Location;
import com.lfk.killit.Drawable.Button.BaseButton;
import com.lfk.killit.Drawable.Button.SimpleButton;
import com.lfk.killit.Main.MainActivity;
import com.lfk.killit.UI.UIDefaultData;
import com.orhanobut.logger.Logger;

import java.util.List;

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
    private Location location = null;
    List list = UIDefaultData.constant_button.getSimpleButtons();

    public WelcomeView(Context context) {
        super(context);
    }

    public WelcomeView(MainActivity activity) {
        super(activity.getApplicationContext());
        this.activity = activity;

        this.holder = this.getHolder();
        holder.addCallback(this);

        drawBG = new DrawBG();
        drawBG.setWork(true);
        loadBitmap = new LoadBitmap();

        initPic();
    }

    private void initPic() {
        simpleButton = UIDefaultData.constant_button.getSimpleButtons().get(0);

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
        drawBG.start();
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
            Canvas canvas = holder.lockCanvas(simpleButton.getRect());
            //获取画布
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

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        if (activity.currentView == ) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                for (int i = 0; i < list.size(); i++) {
//                    BaseButton button = (SimpleButton) list.get(i);
                    Rect rect = ((SimpleButton) list.get(i)).getRect();
                    Logger.d(rect.top + " " + rect.right + " "
                            + rect.bottom + " " + rect.left);
                    if (((SimpleButton) list.get(i)).getRect().
                            contains((int) event.getX(),
                                    (int) event.getY())) {
                        Logger.d("button 按下");
                        ((SimpleButton) list.get(i)).setState(BaseButton.CLICKED);
                        button = (SimpleButton) list.get(i);
                        hitbutton = true;
                    } else {
                        Logger.e(event.getX() + " " + event.getY());
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                if (hitbutton && button.getRect().contains((int) event.getX(), (int) event.getY())) {
                    System.out.println("set NORMAL");
                    button.setState(BaseButton.NORMAL);
                    button = null;
//                    onClicked(name);
                } else if (hitbutton) {
                    button.setState(BaseButton.NORMAL);
                    button = null;
                }
                hitbutton = false;
                break;
        }
//        }
        return true;
    }

}
