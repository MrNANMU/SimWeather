package com.example.dason.simweather.eg;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dason.simweather.R;
import com.example.dason.simweather.api.City;
import com.example.dason.simweather.api.CityManager;
import com.example.dason.simweather.api.CityTransmitter;
import com.example.dason.simweather.api.Value;

/**
 * Created by dason on 2016/11/23 0023.
 */

public class MainActivity extends Activity {

    private static final int UPDATE = 0 ;

    private Button autoBtn = null ;
    private Button selectBtn = null ;
    private TextView info = null ;
    private EditText edit = null ;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case UPDATE :
                    City city = (City)msg.obj ;
                    MainActivity.this.info.setText("城市名："+city.getCityName()+
                            "\n当前温度："+city.getTemperature()+
                            "\n当前天气："+city.getWeather());
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.autoBtn = (Button)findViewById(R.id.autobtn) ;
        this.selectBtn = (Button)findViewById(R.id.selectbtn) ;
        this.info = (TextView)findViewById(R.id.info) ;
        this.edit = (EditText)findViewById(R.id.edit) ;

        this.autoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        new CityManager().getCity(Value.KEY, "ip", new CityTransmitter() {
                            @Override
                            public void get(City city) {
                                Message msg = new Message() ;
                                msg.what = UPDATE ;
                                msg.obj = city ;
                                MainActivity.this.handler.sendMessage(msg) ;
                            }
                        });
                    }
                }).start();
            }
        });

        this.selectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String s = MainActivity.this.edit.getText().toString() ;
                if(s == null){
                    Toast.makeText(MainActivity.this,"您还没输入城市",Toast.LENGTH_SHORT).show();
                }else{
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            new CityManager().getCity(Value.KEY, s, new CityTransmitter() {
                                @Override
                                public void get(City city) {
                                    Message msg = new Message() ;
                                    msg.what = UPDATE ;
                                    msg.obj = city ;
                                    MainActivity.this.handler.sendMessage(msg) ;
                                }
                            });
                        }
                    }).start();
                }
            }
        });
    }
}
