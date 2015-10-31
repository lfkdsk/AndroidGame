package com.lfk.killit.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

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

    private void initPic() {
//        logo = new AbsoluteBitmap(R.drawable.logo);
//        mAnimation = new EnlargeAnimation(logo);
    }

    public void DrawIt(Canvas canvas) {
//        if (logo == null) return;

        simpleButton = UIDefaultData.constant_button.getSimpleButtons().get(0);
        canvas.drawColor(Color.WHITE);
        simpleButton.setCanvas(canvas);
//        simpleButton.setState(BaseButton.NORMAL);
        simpleButton.drawIt();
//        logo.draw(canvas,
//                (int) (UIDefaultData.f_x_screen - logo.getWidth()) / 2,
//                (int) (UIDefaultData.f_y_screen - logo.getHeight()) / 2,
//                255);
//        mAnimation.start();
//
//        mAnimation.draw(canvas, (int) (UIDefaultData.f_x_screen - logo.getWidth()) / 2,
//                (int) (UIDefaultData.f_y_screen - logo.getHeight()) / 2);
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

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

        private void draw(){
            SurfaceHolder myHolder = WelcomeView.this.getHolder();
            Canvas canvas = myHolder.lockCanvas();
            //获取画布
            try {
                synchronized (myHolder) {
                    WelcomeView.this.DrawIt(canvas);                        //绘制
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (canvas != null)
                    myHolder.unlockCanvasAndPost(canvas);
            }
        }

        @Override
        public void run() {
            super.run();
            while (flag) {
                long begin_time = System.currentTimeMillis();
                draw();
                long end_time = System.currentTimeMillis();
                //控制帧数
                if (end_time - begin_time < 35)
                    try {
                        Thread.sleep(35 - (end_time - begin_time));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
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
        List list = UIDefaultData.constant_button.getSimpleButtons();
//        if (activity.currentView == ) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    for (int i = 0; i < list.size(); i++) {
                        BaseButton button = (SimpleButton)list.get(i);
                        if((button).
                                getRect().
                                contains((int) event.getX(),
                                        (int) event.getY())){
                            Logger.d("button 按下");
                            button.setState(BaseButton.CLICKED);
                            this.button = button;
                        }else {
                            Logger.e(event.getX()+ " " +event.getY());
                        }
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    button.setState(BaseButton.NORMAL);
                    break;
            }
//        }
        return super.onTouchEvent(event);
    }

}
