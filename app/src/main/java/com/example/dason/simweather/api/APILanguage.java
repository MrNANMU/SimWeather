package com.example.dason.simweather.api;

/**
 * Created by dason on 2016/10/13 0013.
 */

public final class APILanguage implements Describe{

    public static final String ZH_HANS= "zh-Hans" ;       //简体中文
    public static final String ZH_HANT = "zh-Hant" ;      //繁体中文
    public static final String EN = "en";                 //英文
    public static final String JA = "ja" ;                //日语
    public static final String DE = "de" ;                //德语
    public static final String FR = "fr" ;                //法语
    public static final String HI = "hi" ;                //印地语（印度官方语言之一）
    public static final String ID = "id" ;                //印度尼西亚语
    public static final String RU = "ru" ;                //俄语
    public static final String TH = "th" ;                //泰语


    public String getDescribe() {

        String describe = "ZH_HANS -> 简体中文\n" +
                "ZH_HANT -> 繁体中文\n" +
                "EN -> 英文\n" +
                "JA -> 日语\n" +
                "DE -> 德语\n" +
                "FR -> 法语\n" +
                "HI -> 印地语（印度官方语言之一）\n" +
                "ID -> 印度尼西亚语\n" +
                "RU -> 俄语\n" +
                "TH -> 泰语" ;

        return describe ;
    }
}
