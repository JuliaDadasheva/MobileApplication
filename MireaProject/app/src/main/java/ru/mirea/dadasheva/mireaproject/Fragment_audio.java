package ru.mirea.dadasheva.mireaproject;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_audio#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_audio extends Fragment  implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public Fragment_audio() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_audio.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_audio newInstance(String param1, String param2) {
        Fragment_audio fragment = new Fragment_audio();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.button22:
                getActivity().startService(new Intent(getActivity(), MyService.class));
                break;
            case R.id.button33:
                getActivity().stopService(new Intent(getActivity().getBaseContext(), MyService.class));
                break;
        }
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment_audio, container, false);


        Button b = (Button) v.findViewById(R.id.button22);
        b.setOnClickListener(this);
        Button c = (Button) v.findViewById(R.id.button33);
        c.setOnClickListener(this);
        return v;
        // Inflate the layout for this fragment

    }


}
