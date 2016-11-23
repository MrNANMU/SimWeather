package com.example.dason.simweather.api;

/**
 * Created by dason on 2016/10/13 0013.
 */

public interface ProviderListener {
    //void onSuccess(HashMap<String,String> map);
    void onSuccess(String string);
    void onError(Exception error);
    void onError(String error);
}
