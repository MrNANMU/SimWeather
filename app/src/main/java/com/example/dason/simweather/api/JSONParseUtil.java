package com.example.dason.simweather.api;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by dason on 2016/10/14 0014.
 */

public final class JSONParseUtil {

    public static City getNow(String dataAsJson,City city){

        try {
            JSONArray array1 = new JSONObject(dataAsJson).getJSONArray("results") ;
            JSONObject object1 = array1.getJSONObject(0) ;
            JSONObject object2 = object1.getJSONObject("location") ;
            city.setCityName(object2.getString("name"));
            JSONObject object3 = object1.getJSONObject("now") ;
            city.setTemperature(object3.getString("temperature")) ;
            city.setWeather(object3.getString("text"));
            //Log.v("ZHENG:",city.getCityName()+","+city.getTemperature()+","+city.getWeather());


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return city ;
    }

    public static City getDaily(String dataAsJson,City city){

        try {
            JSONArray array1 = new JSONObject(dataAsJson).getJSONArray("results") ;
            JSONObject object1 = array1.getJSONObject(0) ;
            JSONArray array2 = object1.getJSONArray("daily") ;
            for(int i=0 ;i < array2.length() ;i ++){
                JSONObject object = array2.getJSONObject(i) ;
                if(i == 0){
                    city.setWindScale(object.getString("wind_scale")) ;
                    city.setHighTemp(object.getString("high")) ;
                    city.setLowTemp(object.getString("low")) ;
                    //Log.v("ZHENG:",city.getWindScale()+","+city.getHighTemp()+","+city.getLowTemp()) ;
                }else if(i == 1){
                    city.getTomorrow().highTemp = object.getString("high") ;
                    city.getTomorrow().lowTemp =  object.getString("low") ;
                    city.getTomorrow().weather = object.getString("text_day") ;
                    city.getTomorrow().windScale = object.getString("wind_scale") ;
                    //Log.v("ZHENG:",city.getTomorrow().highTemp +","+city.getTomorrow().lowTemp+","+city.getTomorrow().weather+","+city.getTomorrow().windScale);
                }else{
                    city.getThirdDay().highTemp = object.getString("high") ;
                    city.getThirdDay().lowTemp =  object.getString("low") ;
                    city.getThirdDay().weather = object.getString("text_day") ;
                    city.getThirdDay().windScale = object.getString("wind_scale") ;
                    //Log.v("ZHENG:",city.getThirdDay().highTemp +","+city.getThirdDay().lowTemp+","+city.getThirdDay().weather+","+city.getThirdDay().windScale);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return city ;
    }

    public static City getLife(String dataAsJson,City city){

        try {
            JSONArray array1 = new JSONObject(dataAsJson).getJSONArray("results") ;
            JSONObject object1 = array1.getJSONObject(0);
            JSONObject object2 = object1.getJSONObject("suggestion") ;

            JSONObject object3 = object2.getJSONObject("car_washing") ;
            city.setCarWashing(object3.getString("brief"));
            JSONObject object4 = object2.getJSONObject("dressing") ;
            city.setDressing(object4.getString("brief"));
            JSONObject object5 = object2.getJSONObject("flu") ;
            city.setFlu(object5.getString("brief"));
            JSONObject object6 = object2.getJSONObject("sport") ;
            city.setSport(object6.getString("brief"));
            JSONObject object7 = object2.getJSONObject("travel") ;
            city.setTravel(object7.getString("brief"));
            JSONObject object8 = object2.getJSONObject("uv") ;
            city.setUv(object8.getString("brief"));
            //Log.v("ZHENG:",city.getCarWashing()+","+city.getDressing()+","+city.getFlu()+","+city.getSport()+","+city.getTravel()+","+city.getUv()) ;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return city ;
    }

}
