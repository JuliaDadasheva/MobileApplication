package ru.mirea.dadasheva.looper;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewDebug;

public class MainActivity extends AppCompatActivity {
    MyLooper myLooper;
    int age = 22;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myLooper = new MyLooper();
        myLooper.start();
    }
    public void onClick(View view) {
            Message msg = new Message();
            Bundle bundle = new Bundle();
            bundle.putString("KEY", Integer.toString(age+40));
            msg.setData(bundle);
            if (myLooper != null) {
                myLooper.handler.sendMessage(msg);
                 }

        }


    public class MyLooper extends Thread
    {
        private int number = 0;
        private Handler handler;
        @SuppressLint("HandlerLeak")
        @Override
        public void run(){
            Log.d("MyLooper", "run");
            Looper.prepare();
            handler = new Handler(){
                @Override
                public void handleMessage(Message msg){
                    Log.d("MyLooper", number + ":"+ msg.getData().getString("KEY"));
                    number++;
                }
            };
            Looper.loop();
        }
    }

}
