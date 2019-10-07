package ru.mirea.layouttype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView myTextView = (TextView) findViewById(R.id.editText4);
        myTextView.setText("New text in MIREA");
        CheckBox checkBox = findViewById(R.id.checkBox);
        checkBox.setChecked(true);
        Button button = findViewById(R.id.button14);
        button.setText("123");

    }
}