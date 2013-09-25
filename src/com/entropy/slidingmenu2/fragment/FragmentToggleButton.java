package com.entropy.slidingmenu2.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ToggleButton;

import com.entropy.slidingmenu2.R;

public class FragmentToggleButton extends Fragment {
    ToggleButton toggleButton;
    
    public FragmentToggleButton() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_togglebutton, null);
        
        toggleButton = (ToggleButton) view.findViewById(R.id.fragment_togglebutton_togglebutton);
        
        return view;
    }
}
