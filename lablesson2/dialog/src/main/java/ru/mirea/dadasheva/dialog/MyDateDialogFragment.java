package ru.mirea.dadasheva.dialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

public class MyDateDialogFragment extends DialogFragment {
    int DIALOG_DATE = 1;
    int myYear = 2011;
    int myMonth = 02;
    int myDay = 03;
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        DatePickerDialog dpd = new DatePickerDialog(this.getContext(), myCallBack, myYear, myMonth, myDay);
        dpd.show();
        return dpd;
    }
    DatePickerDialog.OnDateSetListener myCallBack = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            myYear = year;
            myMonth = monthOfYear;
            myDay = dayOfMonth;
            Toast.makeText(getContext(), "Date of " + myDay + "/" + myMonth + "/" + myYear,
                    Toast.LENGTH_LONG).show();

        }
    };
}

