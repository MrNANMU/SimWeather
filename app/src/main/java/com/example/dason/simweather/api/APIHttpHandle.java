package com.example.dason.simweather.api;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by dason on 2016/10/13 0013.
 */

public final class APIHttpHandle {
    //public APIHttpHandle(){}
    //工具类
    //不提供反射

    private URL url = null ;
    private HttpURLConnection connection = null ;
    private boolean isConnected = false ;
    private int responseCode = 0;

    public boolean getConnection(String url){

        try {
            this.url = new URL(url) ;
            try {
                this.connection = (HttpURLConnection) this.url.openConnection();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public void getWeatherNow(String url,final ProviderListener listener){

        //this.isConnected = this.getConnection(url) ;
        this.isConnected = true ;
        if(this.isConnected){
            try {
                this.url = new URL(url) ;
                this.connection = (HttpURLConnection) this.url.openConnection();
                this.connection.setRequestMethod("GET");
                this.connection.setConnectTimeout(10000);
                this.connection.setReadTimeout(10000);
                /*this.connection.setDoInput(true);
                this.connection.setDoOutput(true);*/
                //加上这两句会返回404，未知原因，JAVA程序可加，正常返回，未知原因
                this.responseCode = this.connection.getResponseCode();
                Log.v("ZHENG:",this.responseCode+"");
                if(responseCode == 200){//*/
                    InputStream inputStream = this.connection.getInputStream() ;
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    String json = null ;
                    StringBuffer stringBuffer = new StringBuffer();
                    if((json = bufferedReader.readLine()) != null) {
                        stringBuffer.append(json) ;
                    }
                    listener.onSuccess(stringBuffer.toString());

                }else{
                    listener.onError("无法连接到网络！错误代码：" + responseCode);
                }//*/
            } catch (Exception e) {
                listener.onError(e);
            }finally {
                if (this.connection !=null)
                {
                    this.connection.disconnect();
                }
            }

            /*try {

                if(responseCode == 200){/*//*//*
                    InputStream inputStream = this.connection.getInputStream() ;
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    String json = null ;
                    StringBuffer stringBuffer = new StringBuffer();
                    if((json = bufferedReader.readLine()) != null) {
                        stringBuffer.append(json) ;
                    }
                    listener.onSuccess(stringBuffer.toString());

                }else{
                    listener.onError("无法连接到网络！错误代码：" + responseCode);
                }/*//*//*
            } catch (IOException e) {
                listener.onError(e);
            }//*/

        }else{
            listener.onError("无法连接到数据源，请检查网络。");
        }
    }




    /*
    private static APIHttpHandle apiHttpHandle = new APIHttpHandle() ;

    private APIHttpHandle(){

    }

    public static APIHttpHandle getApiHttpHandle(){

        if(apiHttpHandle == null){
            apiHttpHandle = new APIHttpHandle() ;
        }
        return apiHttpHandle ;
    }//*/
/*
    public void getWeather(String address,final ProviderListener providerListener) throws IOException {

        HttpURLConnection connection = null ;
        URL url = null;
        try {
            url = new URL(address);
        } catch (MalformedURLException e) {
            providerListener.onError(e);
        }
        connection = (HttpURLConnection) url.openConnection();
        try {
            connection.setRequestMethod("GET");
        } catch (ProtocolException e) {
            providerListener.onError(e);
        }
        connection.setConnectTimeout(10000);
        connection.setReadTimeout(10000);
        connection.setDoInput(true);
        connection.setDoOutput(true);
        try {
            if(connection.getResponseCode() == 200){
                InputStream in = connection.getInputStream() ;
                BufferedReader reader = new BufferedReader(new InputStreamReader(in)) ;
                StringBuilder jsonBuilder = new StringBuilder() ;
                String json = null ;
                while((json = reader.readLine()) != null){
                    jsonBuilder.append(json) ;
                }
                reader.close();
                try {
                    *//*HashMap<String,String> map = new HashMap<String,String>() ;
                    map = JSONParseUtil.parseWeatherNow(map,jsonBuilder.toString());
                    Log.v("D:","APIHttpHandle.getWeather Running...");
                    Log.e("D:","name -> " + map.get("name")) ;
                    Log.e("D:","weather -> " + map.get("weather")) ;
                    Log.e("D:","temperature -> " + map.get("temperature")) ;/*//*//*
                    providerListener.onSuccess(jsonBuilder.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        } catch (IOException e) {
            providerListener.onError(e);
        }


    }//*/

}
