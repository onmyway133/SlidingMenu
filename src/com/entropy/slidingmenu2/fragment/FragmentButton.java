package com.entropy.slidingmenu2.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.entropy.slidingmenu2.R;

public class FragmentButton extends Fragment {
    Button button;
    
    public FragmentButton() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_button, null);
    
        button = (Button) view.findViewById(R.id.fragment_button_button);
        button.setText("Button after clicked");
        
        return view;
    }
}
