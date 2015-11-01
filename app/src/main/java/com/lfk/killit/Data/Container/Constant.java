package com.lfk.killit.Data.Container;

import com.lfk.killit.Drawable.Button.SimpleButton;
import com.lfk.killit.UI.UIDefaultData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liufengkai on 15/10/31.
 */
public class Constant {
    private List<SimpleButton> welcomeButtons;


    public Constant() {
        welcomeButtons = new ArrayList<>();
    }

    public void initWelcomeButtons(){
        SimpleButton simpleButton = new SimpleButton("logo",
                (int)UIDefaultData.f_y_screen /2,
                (int)UIDefaultData.f_x_screen /2);
        welcomeButtons.add(simpleButton);
    }

    public List<SimpleButton> getSimpleButtons() {
        return welcomeButtons;
    }
}
