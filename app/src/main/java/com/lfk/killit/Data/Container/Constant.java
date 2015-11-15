package com.lfk.killit.Data.Container;

import com.lfk.killit.Drawable.Button.SimpleButton;
import com.lfk.killit.UI.UIDefaultData;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liufengkai on 15/10/31.
 */
public class Constant {
    private Map<String, SimpleButton> welcomeButtons;

    public Constant() {
        welcomeButtons = new HashMap<>();
    }

    public void initWelcomeButtons() {

        welcomeButtons.put("logo", new SimpleButton("logo",
                (int) UIDefaultData.f_y_screen / 2,
                (int) UIDefaultData.f_x_screen / 2));


        welcomeButtons.put("left_button", new SimpleButton("left_button",
                (int) UIDefaultData.f_y_screen / 6 * 5,
                (int) UIDefaultData.f_x_screen / 7));

        welcomeButtons.put("right_button", new SimpleButton("right_button",
                (int) UIDefaultData.f_y_screen / 6 * 5,
                (int) UIDefaultData.f_x_screen / 7 * 2));

        welcomeButtons.put("hit_button", new SimpleButton("hit_button",
                (int) UIDefaultData.f_y_screen / 6 * 5,
                (int) UIDefaultData.f_x_screen / 8 * 6));
    }

    public Map<String, SimpleButton> getSimpleButtons() {
        return welcomeButtons;
    }

}
