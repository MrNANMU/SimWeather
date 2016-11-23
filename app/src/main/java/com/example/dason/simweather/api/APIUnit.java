package com.example.dason.simweather.api;

/**
 * Created by dason on 2016/10/13 0013.
 */

public final class APIUnit implements Describe{

    public static final String CENTIGRADE = "c" ;
    //摄氏度
    public static final String FAHRENHEIT = "f" ;

    @Override
    public String getDescribe() {
        String describe = "CENTIGRADE -> 摄氏度\nFAHRENHEIT -> 华氏度" ;
        return describe;
    }
    //华氏度

}
