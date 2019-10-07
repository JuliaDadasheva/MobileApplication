package ru.mirea.dadasheva.dialog;


import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

public class MyTimeDialogFragment extends DialogFragment {

    int myHour = 14;
    int myMinute = 35;

    public Dialog onCreateDialog(Bundle savedInstanceState) {

        TimePickerDialog tpd = new TimePickerDialog(this.getContext(), myCallBack, myHour, myMinute, true);
        tpd.show();
        return tpd;
    }
    TimePickerDialog.OnTimeSetListener myCallBack = new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            myHour = hourOfDay;
            myMinute = minute;

            Toast.makeText(getContext(), "Time is " + myHour + " hours " + myMinute + " minutes",
                    Toast.LENGTH_LONG).show();
        }
    };

}
