package com.study.online.data;

import android.content.Context;
import android.content.res.TypedArray;

import com.study.online.R;
import com.study.online.model.Image;
import com.study.online.model.Social;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@SuppressWarnings("ResourceType")
public class DataGenerator {

    private static Random r = new Random();

    public static int randInt(int max) {
        int min = 0;
        return r.nextInt((max - min) + 1) + min;
    }

    public static List<String> getStringsShort(Context ctx) {
        List<String> items = new ArrayList<>();
        String name_arr[] = ctx.getResources().getStringArray(R.array.strings_short);
        for (String s : name_arr) items.add(s);
        Collections.shuffle(items);
        return items;
    }

    public static List<String> getStringsMedium(Context ctx) {
        List<String> items = new ArrayList<>();
        String name_arr[] = ctx.getResources().getStringArray(R.array.strings_medium);
        for (String s : name_arr) items.add(s);
        Collections.shuffle(items);
        return items;
    }

    public static List<String> getFullDate(Context ctx) {
        List<String> items = new ArrayList<>();
        String name_arr[] = ctx.getResources().getStringArray(R.array.full_date);
        for (String s : name_arr) items.add(s);
        Collections.shuffle(items);
        return items;
    }



    public static List<Integer> getNatureImages(Context ctx) {
        List<Integer> items = new ArrayList<>();
        TypedArray drw_arr = ctx.getResources().obtainTypedArray(R.array.sample_images);
        for (int i = 0; i < drw_arr.length(); i++) {
            items.add(drw_arr.getResourceId(i, -1));
        }
        Collections.shuffle(items);
        return items;
    }




    public static List<Image> getImageDate(Context ctx) {
        List<Image> items = new ArrayList<>();
        TypedArray drw_arr = ctx.getResources().obtainTypedArray(R.array.sample_images);
        String name_arr[] = ctx.getResources().getStringArray(R.array.course_name);
//        String date_arr[] = ctx.getResources().getStringArray(R.array.general_date);
        String lessons_arr[] = ctx.getResources().getStringArray(R.array.lessons);
        for (int i = 0; i < drw_arr.length(); i++) {
            Image obj = new Image();
            obj.image = drw_arr.getResourceId(i, -1);
//            obj.name = name_arr[i];
//            obj.brief = date_arr[randInt(date_arr.length - 1)];
            obj.brief = lessons_arr[randInt(lessons_arr.length - 1)];
            obj.counter = r.nextBoolean() ? randInt(500) : null;
            obj.imageDrw = ctx.getResources().getDrawable(obj.image);
            items.add(obj);
        }
        Collections.shuffle(items);
        return items;
    }


    public static List<Social> getSocialData(Context ctx) {
        List<Social> items = new ArrayList<>();
        TypedArray drw_arr = ctx.getResources().obtainTypedArray(R.array.avtar);
        String name_arr[] = ctx.getResources().getStringArray(R.array.string_subject);

        for (int i = 0; i < 2; i++) {
            Social obj = new Social();
            obj.image = drw_arr.getResourceId(0, -1);
            obj.name = name_arr[i];
            obj.imageDrw = ctx.getResources().getDrawable(obj.image);
            items.add(obj);
        }
        Collections.shuffle(items);
        return items;
    }



    private static int getRandomIndex(int max) {
        return r.nextInt(max - 1);
    }
}
