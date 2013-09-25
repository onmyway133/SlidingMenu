package com.entropy.slidingmenu2.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.entropy.slidingmenu2.R;

public class FragmentListView extends Fragment {
    ListView listView;
    
    public FragmentListView() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listview, null);
    
        String[] listViewItems = new String[] {"Android", "iOS", "Windows Phone", "Blackberry", "Meego", "Symbian"};
        listView = (ListView) view.findViewById(R.id.fragment_listview_listview);
        listView.setAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, listViewItems));
        
        return view;
    }
}
