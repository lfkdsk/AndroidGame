package com.lfk.killit.Data.Container;

import com.lfk.killit.Drawable.Button.SimpleButton;
import com.lfk.killit.UI.UIDefaultData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liufengkai on 15/10/31.
 */
public class Constant {
    private List<SimpleButton> simpleButtons;

    public Constant() {
        simpleButtons = new ArrayList<>();
    }

    public void initButtons(){
        SimpleButton simpleButton = new SimpleButton("logo",
                (int)UIDefaultData.f_y_screen,
                (int)UIDefaultData.f_x_screen);
        simpleButtons.add(simpleButton);
    }

    public List<SimpleButton> getSimpleButtons() {
        return simpleButtons;
    }
}
