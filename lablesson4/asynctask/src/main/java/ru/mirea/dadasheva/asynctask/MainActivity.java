package ru.mirea.dadasheva.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    TextView resultTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickAsyncTask(View view) {
        resultTextView = findViewById(R.id.resultTextView);
        MyAsyncTask myAsyncTask = new MyAsyncTask(resultTextView);
        myAsyncTask.execute(); }

    public class MyAsyncTask extends AsyncTask<Void, Integer, Void> {

        private final String TAG = MyAsyncTask.class.getSimpleName();
        private WeakReference<TextView> wTextView;

        MyAsyncTask(TextView textView) {         this.wTextView = new WeakReference<>(textView);     }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            updateText("Запуск");     }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            updateText("Выполнено: " + values[0]);     }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                int counter = 0;
                int day=100;
                int hour=4;
                for (int i = 0; i < day*hour; i++) {
                    //getTime();
                    publishProgress(++counter);             }
                TimeUnit.SECONDS.sleep(1);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }         return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            //updateText("Выполнено");
            }

        private void getTime() throws InterruptedException {
            TimeUnit.SECONDS.sleep(1);
        }
        private void updateText(String str){
            final TextView textView = wTextView.get();
            if (textView != null) {
                textView.setText(str);
            } else {
                Log.d(TAG, "Что-то пошло не так!");
            }     } }
}
