package com.example.dason.simweather.api;

import android.util.Log;

/**
 * Created by dason on 2016/10/13 0013.
 */

public class Provider {

    private static Provider provider = new Provider();
    private APIHttpHandle handle = null ;
    private String address = null ;
    private City city = new City() ;

    private Provider(){

    }

    public static Provider getProvider(){
        if(provider == null){
            provider = new Provider();
        }
        return provider;
    }


    public void setAddress(String address){

        this.address = address ;
    }

    public void getWeather(final InformationTransmitter infoReceive){

        this.handle = new APIHttpHandle() ;
        this.handle.getWeatherNow(this.address, new ProviderListener() {
            @Override
            public void onSuccess(String string) {
                infoReceive.receive(string);
            }

            @Override
            public void onError(Exception error) {
                error.printStackTrace();
            }

            @Override
            public void onError(String error) {
                Log.e("ZHENG:",error);
            }
        });
    }

    public void getWeather(String url, final InformationTransmitter receive){

        this.setAddress(url);
        this.getWeather(receive);
    }

}
