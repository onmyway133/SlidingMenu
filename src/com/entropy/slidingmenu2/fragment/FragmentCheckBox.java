package com.entropy.slidingmenu2.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.entropy.slidingmenu2.R;

public class FragmentCheckBox extends Fragment {
    CheckBox checkBox1;
    CheckBox checkBox2;
    
    public FragmentCheckBox() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_checkbox, null);
    
        checkBox1 = (CheckBox) view.findViewById(R.id.fragment_checkbox_checkbox1);
        checkBox2 = (CheckBox) view.findViewById(R.id.fragment_checkbox_checkbox2);
        
        return view;
    }
}
