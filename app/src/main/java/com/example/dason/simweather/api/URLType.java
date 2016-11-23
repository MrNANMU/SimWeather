package com.example.dason.simweather.api;

/**
 * Created by dason on 2016/11/9 0009.
 */

public final class URLType implements Describe{

    /*public final static String WEATHER_NOW = File.separator + "weather" + File.separator + "now.json?" ;
        //等价于"/weather/now.json?"，下同理
    public final static String WEATHER_DAILY = File.separator + "weather" + File.separator + "daily.json?" ;
    public final static String LIFE = File.separator + "life"+ File.separator + "suggestion.json?" ;//*/

    public final static String WEATHER_NOW = "/weather/now.json?" ;
    public final static String WEATHER_DAILY = "/weather/daily.json?" ;
    public final static String LIFE = "/life/suggestion.json?" ;

    @Override
    public String getDescribe() {

        String describe =
                "获取城市名、实时天气、实时温度，使用 WEATHER_NOW\n" +
                "获取风力等级、当日最高气温、当日最低气温、明天气温信息、后天气温信息，使用 WEATHER_DAILY\n" +
                "获取生活指数，使用 LIFE" ;
        return describe;
    }
}
