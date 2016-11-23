package com.example.dason.simweather.api;

/**
 * Created by dason on 2016/11/14 0014.
 */

public class CityManager implements Describe{

    private City city = new City() ;
    private String cityName = null ;

    public CityManager(){

    }

    public void getCity(String key,String cityName,final CityTransmitter cityTransmitter){
        this.setCityName(cityName);
        String urlNow = URLBuilder.build(URLType.WEATHER_NOW,key,cityName,APILanguage.ZH_HANS,APIUnit.CENTIGRADE);
        String urlDaily = URLBuilder.build(URLType.WEATHER_DAILY,key,cityName,APILanguage.ZH_HANS,APIUnit.CENTIGRADE,0,3);
        String urlLife = URLBuilder.build(URLType.LIFE,key,cityName,APILanguage.ZH_HANS);
        Provider p = Provider.getProvider();
        p.getWeather(urlNow, new InformationTransmitter() {
            @Override
            public void receive(String dataAsJson) {
                JSONParseUtil.getNow(dataAsJson,CityManager.this.city) ;
            }
        });
        p.getWeather(urlDaily, new InformationTransmitter() {
            @Override
            public void receive(String dataAsJson) {
                JSONParseUtil.getDaily(dataAsJson,CityManager.this.city) ;
            }
        });
        p.getWeather(urlLife, new InformationTransmitter() {
            @Override
            public void receive(String dataAsJson) {
                JSONParseUtil.getLife(dataAsJson,CityManager.this.city) ;
            }
        });

        //Log.v("ZHENG:",this.city.getCarWashing()) ;

        cityTransmitter.get(this.city);
    }

    public void getCity(String key,String cityName,String language,String unit,int startDay,int days,final CityTransmitter cityTransmitter){
        this.setCityName(cityName);
        String urlNow = URLBuilder.build(URLType.WEATHER_NOW,key,cityName,language,unit);
        String urlDaily = URLBuilder.build(URLType.WEATHER_DAILY,key,cityName,language,unit,startDay,days);
        String urlLife = URLBuilder.build(URLType.LIFE,key,cityName,language);
        Provider p = Provider.getProvider();
        p.getWeather(urlNow, new InformationTransmitter() {
            @Override
            public void receive(String dataAsJson) {
                JSONParseUtil.getNow(dataAsJson,CityManager.this.city) ;
            }
        });
        p.getWeather(urlDaily, new InformationTransmitter() {
            @Override
            public void receive(String dataAsJson) {
                JSONParseUtil.getDaily(dataAsJson,CityManager.this.city) ;
            }
        });
        p.getWeather(urlLife, new InformationTransmitter() {
            @Override
            public void receive(String dataAsJson) {
                JSONParseUtil.getLife(dataAsJson,CityManager.this.city) ;
            }
        });

        //Log.v("ZHENG:",this.city.getCarWashing()) ;
        cityTransmitter.get(this.city);
    }

    private void setCityName(String cityName){
        this.cityName = cityName ;
    }


    public String getDescribe() {

        String describe = "getCity()方法中两个参数的方法默认为中文、摄氏度，如需改变可以使用getCity()的重载函数。\n" +
                "如需精确操作，请参考Provider类、URLBuilder类、JSONParseUtil类。" ;
        return describe;
    }
}
