package com.example.dason.simweather.api;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by dason on 2016/11/17 0017.
 */

public class Value {

    public static String KEY = "hhq80xqxjozayqo6" ;
    public static void resetKey(String key){
        KEY = key ;
    }
    public static ArrayList<String> getCityList(Context context,FileInputStream file) throws Exception{
        ArrayList<String> list = new ArrayList<String>() ;
        file = context.openFileInput("citys") ;
        BufferedReader reader = new BufferedReader(new InputStreamReader(file)) ;
        String city = null ;
        while((city = reader.readLine()) != null){
            list.add(city) ;
        }
        reader.close();
        return list;
    }

}
