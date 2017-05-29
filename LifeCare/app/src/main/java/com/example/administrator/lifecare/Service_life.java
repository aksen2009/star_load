package com.example.administrator.lifecare;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;


/**
 * Created by Administrator on 2017-05-24.
 */

public class Service_life extends Service{

    private final IBinder mBinder = new LocalBinder();

    public class LocalBinder extends Binder {
        public Service_life getService() {
            return Service_life.this;
        }
    }
    public void setAlarm(boolean flag) {

    }

    @Override
    public IBinder onBind(Intent itent){
        return null;
    }

    @Override
    public void onCreate(){
        super.onCreate();

    }

    public int onStartCommand(Intent intent, int flags, int startld){

        return super.onStartCommand(intent, flags, startld);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();

    }






}
