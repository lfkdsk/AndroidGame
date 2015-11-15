package com.lfk.killit.Main;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.SurfaceView;
import android.widget.Toast;

import com.lfk.killit.Data.Container.BipContainer;
import com.lfk.killit.Data.Container.Constant;
import com.lfk.killit.UI.UIDefaultData;
import com.lfk.killit.View.GameView;
import com.lfk.killit.View.WelcomeView;


public class MainActivity extends Activity {
    private WelcomeView welcomeView;
    public SurfaceView currentView = null;
    private GameView gameView;
    private long time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initStaticData();

        welcomeView = new WelcomeView(this);

        gameView = new GameView(this);

        currentView = welcomeView;

        setContentView(welcomeView);
    }

    public void initStaticData() {
        UIDefaultData.res = getResources();
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int temp1 = dm.widthPixels;
        int temp2 = dm.heightPixels;
        UIDefaultData.f_x_screen = temp1 > temp2 ? temp1 : temp2;
        UIDefaultData.f_y_screen = temp1 < temp2 ? temp1 : temp2;
        UIDefaultData.initScales();

        UIDefaultData.container_bmp = new BipContainer();
        UIDefaultData.container_bmp.initLogoPic();

        UIDefaultData.constant_button = new Constant();
        UIDefaultData.constant_button.initWelcomeButtons();

        UIDefaultData.initButton();

        UIDefaultData.container_bmp.initlogoBits(this);
    }

    public void sendMessage(int i) {
        Message message = handler.obtainMessage(i);
        handler.sendMessage(message);
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    if(currentView == welcomeView) {
                        if(System.currentTimeMillis() - time > 800){
                            Toast.makeText(MainActivity.this, "再按一次推出", Toast.LENGTH_SHORT).show();
                            time = System.currentTimeMillis();
                        }else {
                            finish();
                        }
                    }
                    break;
                case 1:
                    if (gameView == null) {
                        gameView = new GameView(MainActivity.this);
                    }
                    currentView = gameView;
                    welcomeView = null;
                    MainActivity.this.setContentView(gameView);
                    break;
            }
        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_BACK:
                sendMessage(0);
                break;
        }
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        welcomeView = null;
        gameView = null;
        currentView = null;
    }
}
