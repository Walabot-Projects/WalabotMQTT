package com.vayyar.example_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends  WalabotApp {
    /*
        WalabotApp connection params
     */
    private String connectionId = "breathing";
    private String brokerIpAddress = "m14.cloudmqtt.com";
    private int brokerPort = 18832;
    private String brokerUserName = "wfpckqsd";
    private String brokerPassword = "_p9HWcn9q4M8";

    /*
        my app params
     */
    private TextView messageBox;
    private boolean last_clicked = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startBtn = (Button) findViewById(R.id.start);
        Button stopBtn = (Button) findViewById(R.id.stop);
        messageBox = (TextView) findViewById(R.id.output);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startWalabot();
            }
        });
        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopWalabot();
            }
        });
    }

    @Override
    public void startWalabot(){
        super.startWalabot();
        if (this.isConnected){
            last_clicked = true;
            print("starting...");
        }
        else{
            last_clicked = false;
            print("waiting for\nconnection");
        }

    }

    @Override
    public void stopWalabot(){
        super.stopWalabot();
        last_clicked = false;
        print("stopped");
    }

    public void print(final String message){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                messageBox.setText(message);
            }
        });
    }


    @Override
    public void onDataReceived(final String message) {
        if (last_clicked){
            try {
                JSONObject data = new JSONObject(message);
                this.print(data.getString("energy"));
            } catch (JSONException e) {

            }
        }
    }

    @Override
    public void onWalabotError() {
        print("walabot error");
    }


    @Override
    public String getConnectionId(){
        return this.connectionId;
    }

    @Override
    public String getBrokerIpAddress(){
        return this.brokerIpAddress;
    }

    @Override
    public int getBrokerPort(){
        return this.brokerPort;
    }

    @Override
    public String getBrokerUserName(){
        return this.brokerUserName;
    }

    @Override
    public String getBrokerPassword(){
        return this.brokerPassword;
    }

}
