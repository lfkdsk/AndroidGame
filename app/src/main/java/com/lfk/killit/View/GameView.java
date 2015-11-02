package com.lfk.killit.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.lfk.killit.Drawable.Button.BaseButton;
import com.lfk.killit.Drawable.Button.SimpleButton;
import com.lfk.killit.Drawable.Character.Player;
import com.lfk.killit.Main.MainActivity;
import com.lfk.killit.Pic.MBitmap;
import com.lfk.killit.UI.UIDefaultData;
import com.orhanobut.logger.Logger;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by liufengkai on 15/10/30.
 */
public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private MainActivity activity;
    private SurfaceHolder holder;
    private DrawBG drawBG;
    private MBitmap mBitmap;
    private SimpleButton left_button;
    private SimpleButton right_button;
    private SimpleButton hit_it_button;
    private Player player;
    private BaseButton button = null;
    private boolean hitbutton = false;
    private Rect rect;
    public GameView(Context context) {
        super(context);
    }

    public GameView(MainActivity activity) {
        super(activity.getApplicationContext());
        this.activity = activity;

        this.holder = this.getHolder();
        holder.addCallback(this);

        this.mBitmap = UIDefaultData.container_bmp.getBitmap("background");

        this.player = new Player("left_player",(int) UIDefaultData.f_x_screen / 2,
                (int)UIDefaultData.f_y_screen / 2);

        left_button = UIDefaultData.constant_button.getSimpleButtons().get("left_button");
        right_button = UIDefaultData.constant_button.getSimpleButtons().get("right_button");
        hit_it_button = UIDefaultData.constant_button.getSimpleButtons().get("hit_it");

        rect = new Rect(0,0,(int)UIDefaultData.f_x_screen,(int)UIDefaultData.f_y_screen);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        drawBG = new DrawBG();
        drawBG.setWork(true);
        drawBG.start();
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
            Canvas canvas = holder.lockCanvas();
            try {
                synchronized (holder) {
                    canvas.drawBitmap(mBitmap.getBitmap(),null,rect, null);
                    left_button.setCanvas(canvas);
                    right_button.setCanvas(canvas);
                    hit_it_button.setCanvas(canvas);
                    player.setCanvas(canvas);
                    left_button.drawIt();
                    right_button.drawIt();
                    hit_it_button.drawIt();
                    player.DrawIt();
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

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Set set = UIDefaultData.list.entrySet();
                Iterator iterator = set.iterator();
                for (int i = 0; i < UIDefaultData.list.size(); i++) {
                    Map.Entry mapEntry = (Map.Entry) iterator.next();
                    if (((SimpleButton) mapEntry.getValue()).
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
        switch (name){
            case "right_button":
                player.setmBitmap(UIDefaultData.container_bmp.getBitmap("right_player"));
                break;
            case "left_button":
                player.setmBitmap(UIDefaultData.container_bmp.getBitmap("left_player"));
                break;
        }
    }
}
