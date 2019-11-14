package ru.mirea.dadasheva.thread1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView text1;
        Thread mainThread = Thread.currentThread();
        text1 = (TextView) findViewById(R.id.textView);
        text1.setText("Текущий поток: " + mainThread.getName());
        mainThread.setName("MireaThread");
       text1.append("\nНовое имя потока: " + mainThread.getName());
    }
    public void onClick(View view) {

        MyThread myThread = new MyThread();
        myThread.start();
        MyRunnable runnable = new MyRunnable("mirea ");
        new Thread(runnable).start();
    }
        public class MyThread extends Thread {
        private  final String TAG = MyThread.class.getSimpleName();
        public void run()
        {
            Log.d(TAG, "Mой поток запущен...");
            int sum =0;
            for(int i=1;i<31;i++) {
            sum+=(int)Math.random()*6;
            }

        }
    }
    public class MyRunnable implements Runnable {
        private  final String TAG = MyRunnable.class.getSimpleName();
        private String goal;
        public MyRunnable(String goal) {
            this.goal=goal;
        }
        @Override
        public void run() {
        Log.d(TAG, " Mой поток запущен:" + goal);
        }
    }
}
