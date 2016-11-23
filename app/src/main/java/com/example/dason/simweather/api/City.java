package com.example.dason.simweather.api;

/**
 * Created by dason on 2016/10/13 0013.
 */

public class City {

    //private String  = null ;
    private final int TOMORROW = 1 ;
    private final int THIRDDAY = 2 ;


    /**  https://api.thinkpage.cn/v3/weather/now.json  **/
    private String cityName = null ;            //城市名
    private String temperature = null ;         //实时温度
    private String weather = null ;             //天气


    /**  /weather/daily.json  **/
    private String windScale = null ;           //风力等级
    private String highTemp = null ;            //最高气温
    private String lowTemp = null ;             //最低气温


    /**  /life/suggestion.json   **/
    private String carWashing = null ;          //洗车
    private String dressing = null ;            //穿衣
    private String flu = null ;                 //感冒
    private String sport = null ;               //运动
    private String travel = null ;              //旅行
    private String uv = null ;                  //紫外线


    /**  /weather/daily.json  **/
    private NextDaysInfo tomorrow = new NextDaysInfo() ;
    private NextDaysInfo thirdDay = new NextDaysInfo() ;


    public class NextDaysInfo{

        public String highTemp = null ;            //最高气温
        public String lowTemp = null ;             //最低气温
        public String weather = null ;             //天气
        public String windScale = null ;           //风力等级
    }

    public City(){

    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public void setHighTemp(String highTemp) {
        this.highTemp = highTemp;
    }

    public void setLowTemp(String lowTemp) {
        this.lowTemp = lowTemp;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public void setWindScale(String windScale) {
        this.windScale = windScale;
    }

    public void setCarWashing(String carWashing) {
        this.carWashing = carWashing;
    }

    public void setDressing(String dressing) {
        this.dressing = dressing;
    }

    public void setFlu(String flu) {
        this.flu = flu;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public void setTravel(String travel) {
        this.travel = travel;
    }

    public void setUv(String uv) {
        this.uv = uv;
    }

    /*public void setTomorrow(NextDaysInfo tomorrow) {
        this.tomorrow = tomorrow;
    }

    public void setThirdDay(NextDaysInfo thirdDay) {
        this.thirdDay = thirdDay;
    }//*/

    public String getCityName() {
        return cityName;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getHighTemp() {
        return highTemp;
    }

    public String getLowTemp() {
        return lowTemp;
    }

    public String getWeather() {
        return weather;
    }

    public String getWindScale() {
        return windScale;
    }

    public String getCarWashing() {
        return carWashing;
    }

    public String getDressing() {
        return dressing;
    }

    public String getFlu() {
        return flu;
    }

    public String getSport() {
        return sport;
    }

    public String getTravel() {
        return travel;
    }

    public String getUv() {
        return uv;
    }

    public NextDaysInfo getTomorrow() {
        return tomorrow;
    }

    public NextDaysInfo getThirdDay() {
        return thirdDay;
    }
}
