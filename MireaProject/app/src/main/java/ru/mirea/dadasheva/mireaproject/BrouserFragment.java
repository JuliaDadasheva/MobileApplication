package ru.mirea.dadasheva.mireaproject;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.URI;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BrouserFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BrouserFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public BrouserFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BrouserFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BrouserFragment newInstance(String param1, String param2) {
        BrouserFragment fragment = new BrouserFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    private WebView webView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }

        // включаем поддержку JavaScript

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_brouser1, container, false);
        final WebView web =  view.findViewById(R.id.webView);
        web.setWebViewClient(new WebViewClient());
        web.loadUrl("http://ya.ru");
        final EditText edit = (EditText) view.findViewById(R.id.editText);
        edit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN) {
                    switch(event.getKeyCode()) {
                        case KeyEvent.KEYCODE_ENTER:

                            web.setWebViewClient(new WebViewClient());
                            web.loadUrl("http://" + edit.getText());

                            break;
                    }
                }
                return false;
            }
        });



        return view;
    }


}
