package ru.mirea.dadasheva.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import androidx.fragment.app.DialogFragment;

public class MyProgressDialogFragment extends DialogFragment {
    Handler h;
    ProgressDialog pd;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
         pd = new ProgressDialog(getContext());


        // добавляем кнопку
        /*.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // Закрываем окно
                ((MainActivity)getActivity()).onOkClicked3();
                dialog.cancel();
            }
        })


                .setNeutralButton("На паузе",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int id) {
                                //((MainActivity)getActivity()).onNeutralClicked();
                                dialog.cancel();
                            }
                        })
                .setNegativeButton("Нет",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int id) {
                                //((MainActivity)getActivity()).onCancelClicked();;
                                dialog.cancel();

                            }
                        });*/
        pd.setTitle("Title");
        pd.setMessage("Message");
        // меняем стиль на индикатор
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        // устанавливаем максимум
        pd.setMax(2148);
        // включаем анимацию ожидания
        pd.setIndeterminate(true);
        pd.show();


        h = new Handler() {
            public void handleMessage(Message msg) {
                // выключаем анимацию ожидания
                pd.setIndeterminate(false);
                if (pd.getProgress() < pd.getMax()) {
                    // увеличиваем значения индикаторов
                    pd.incrementProgressBy(50);
                    pd.incrementSecondaryProgressBy(75);
                    h.sendEmptyMessageDelayed(0, 100);
                } else {
                    pd.dismiss();
                }
            }
        };
        h.sendEmptyMessageDelayed(0, 2000);
        return pd;
    }
}
