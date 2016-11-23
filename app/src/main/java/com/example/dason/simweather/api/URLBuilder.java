package com.example.dason.simweather.api;

import java.net.URLEncoder;

/**
 * Created by dason on 2016/11/9 0009.
 */

public final class URLBuilder implements Describe{

    private final String urlHead = "https://api.thinkpage.cn/v3" ;
    private static URLBuilder builder = new URLBuilder() ;

    private StringBuffer stringBuffer = null ;

    public static URLBuilder start(){
        builder.stringBuffer = new StringBuffer();
        builder.stringBuffer.append(builder.urlHead);
        return builder ;
    }

    public static URLBuilder link(){
        builder.stringBuffer.append("&");
        return builder ;
    }

    public static URLBuilder setURLType(String URLType){
        builder.stringBuffer.append(URLType);
        return builder ;
    }

    public static URLBuilder setKey(String key){
        builder.stringBuffer.append("key=").append(key);
        return builder ;
    }


    public static URLBuilder setLocation(String location){
        builder.stringBuffer.append("&location=").append(URLEncoder.encode(location));
        return builder ;
    }

    public static URLBuilder setLanguage(String APILanguage){
        builder.stringBuffer.append("&language=").append(APILanguage) ;
        return builder ;
    }

    public static URLBuilder setUnit(String APIUnit){
        builder.stringBuffer.append("&unit=").append(APIUnit) ;
        return builder ;
    }

    public static URLBuilder setStartDay(int start){
        builder.stringBuffer.append("&start=").append(start) ;
        return builder ;
    }

    public static URLBuilder setDays(int days){
        builder.stringBuffer.append("&days=").append(days) ;
        return builder ;
    }


    public static String build(){

        return builder.stringBuffer.toString();
    }

    public static String build(String URLType,String key,String location,String language,String unit){

        return URLBuilder.start().setURLType(URLType).setKey(key).setLocation(location).setLanguage(language).setUnit(unit).build();
    }

    public static String build(String URLType,String key,String location,String language,String unit,int startDay,int days){

        return URLBuilder.start().setURLType(URLType).setKey(key).setLocation(location).setLanguage(language).setUnit(unit).setStartDay(startDay).setDays(days).build();
    }

    public static String build(String URLType,String key,String location,String language){

        return URLBuilder.start().setURLType(URLType).setKey(key).setLocation(location).setLanguage(language).build();
    }


    @Override
    public String getDescribe() {

        String describe =
                "获取城市名、实时天气、实时温度，以\n" +
                        "start().setURLType().setKey().setLocation().setLanguage().setUnit().build()\n" +
                        "的顺序构建，setKey()函数的参数可通过心知天气官网注册获得（API密匙）。\n" +
                        "setLocation()方法的参数可以为城市中文名，城市全拼，IP地址等，全部参数请查阅官网，建议使用中文名。当参数为“ip”时，会自动定位当前城市。\n" +
                        "URLType类提供了所有类型，APILanguage类提供了所有语言，APIUnit类提供了所有温度，可调用相应的getDescribe()方法获取信息\n" +
                "获取风力等级、当日最高气温、当日最低气温、明天气温信息、后天气温信息，以\n" +
                        "start().setURLType().setKey().setLocation().setLanguage().setUnit().setStartDay().setDays().build()\n" +
                        "的顺序构建。其中setStartDay()的参数为0时表示从今天算起，setDays()的参数表示返回的天数。\n" +
                "获取生活指数，以\n" +
                        "start()\n.setURLType().setKey().setLocation().setLanguage().build()\n" +
                        "的方式构建\n" +
                "三类地址也可以通过build()方法直接构建，但必须保证参数顺序的准确性。" ;

        return describe ;
    }
}
