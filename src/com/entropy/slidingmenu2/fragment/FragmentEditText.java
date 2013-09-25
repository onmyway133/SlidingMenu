package com.entropy.slidingmenu2.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.entropy.slidingmenu2.R;

public class FragmentEditText extends Fragment {
    EditText editText;
    
    public FragmentEditText() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edittext, null);
    
        editText = (EditText) view.findViewById(R.id.fragment_edittext_edittext);
        
        return view;
    }
}
