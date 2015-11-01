package com.lfk.killit.Main;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.SurfaceView;

import com.lfk.killit.Data.Container.BipContainer;
import com.lfk.killit.Data.Container.Constant;
import com.lfk.killit.UI.UIDefaultData;
import com.lfk.killit.View.WelcomeView;


public class MainActivity extends Activity {
    private WelcomeView welcomeView;
    public SurfaceView currentView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initStaticData();

        welcomeView = new WelcomeView(this);

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
        UIDefaultData.container_bmp.initPic();

        UIDefaultData.constant_button = new Constant();
        UIDefaultData.constant_button.initWelcomeButtons();
    }

    public void sendMessage(int i){
        Message message = handler.obtainMessage(i);
        handler.sendMessage(message);
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:

                    break;
            }
        }
    };

}
