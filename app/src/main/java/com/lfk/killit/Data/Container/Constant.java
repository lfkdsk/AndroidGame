package com.lfk.killit.Data.Container;

import com.lfk.killit.Drawable.Button.SimpleButton;
import com.lfk.killit.UI.UIDefaultData;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by liufengkai on 15/10/31.
 */
public class Constant {
    private Map<String,SimpleButton> welcomeButtons;


    public Constant() {
        welcomeButtons = new Hashtable<>();
    }

    public void initWelcomeButtons(){

        welcomeButtons.put("logo", new SimpleButton("logo",
                (int)UIDefaultData.f_y_screen /2,
                (int)UIDefaultData.f_x_screen /2));


        welcomeButtons.put("left_button", new SimpleButton("left_button",
                (int)UIDefaultData.f_y_screen / 6 * 5,
                (int) UIDefaultData.f_x_screen / 6));

        welcomeButtons.put("right_button", new SimpleButton("right_button",
                (int)UIDefaultData.f_y_screen / 6 * 5,
                (int) UIDefaultData.f_x_screen / 6 * 2));

        welcomeButtons.put("hit_it",new SimpleButton("hit_it",
                (int)UIDefaultData.f_y_screen / 6 * 5 ,
                (int)UIDefaultData.f_x_screen / 6 * 5));
    }

    public Map<String,SimpleButton> getSimpleButtons() {
        return welcomeButtons;
    }
}
