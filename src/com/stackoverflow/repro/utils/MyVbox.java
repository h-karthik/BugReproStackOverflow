package com.stackoverflow.repro.utils;

import com.stackoverflow.repro.model.App;
import javafx.scene.layout.VBox;

/**
 * Created by karthik on 19/02/15.
 */
public class MyVbox extends VBox{

    boolean isClicked;
    String style;
    App app;

    public boolean getIsClicked(){
        return isClicked;
    }

    public void setIsClicked(boolean val){
        isClicked = val;
    }

    public void setOrigStyle(String sty){
        style = sty;
    }
    public String getOrigStyle(){
        return style;
    }

    public App getApp(){
        return app;
    }

    public void setApp(App appIn){
        app = appIn;
    }
}
