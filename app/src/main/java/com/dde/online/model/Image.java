package com.dde.online.model;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class Image implements Serializable {

    public int image;
    public Drawable imageDrw;
    public String title;
    public String brief;
    public String id;
    public Integer counter = null;

    public String given_price;
    public String highest_price;
    public String name;
}
