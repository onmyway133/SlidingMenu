package com.entropy.slidingmenu2.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.entropy.slidingmenu2.R;

public class FragmentRadioButton extends Fragment {
    RadioButton radioButton1;
    RadioButton radioButton2;
    
    public FragmentRadioButton() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_radiobutton, null);
    
        radioButton1 = (RadioButton) view.findViewById(R.id.fragment_radiobutton_radiobutton1);
        radioButton2 = (RadioButton) view.findViewById(R.id.fragment_radiobutton_radiobutton2);
        
        return view;
    }
}
