package com.example.alex.graphics.until;

import com.example.alex.graphics.model.Drawable;

import java.util.LinkedList;


public class Const {
    public static final double scale = 0.01;
    public static final double angle = 10. / 360.;
    public static LinkedList<Drawable> list = new LinkedList<>();
    public static int id = 0;
    public static int isTouch=0;

    public static void setActive(int id){
        for (Drawable drawable : list){
            if(drawable.getId() != 0 && drawable.getId() == id){
                drawable.setChoose(true);
            }
        }
    }
    }

