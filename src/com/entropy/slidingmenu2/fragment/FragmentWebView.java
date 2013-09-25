package com.entropy.slidingmenu2.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.entropy.slidingmenu2.R;

public class FragmentWebView extends Fragment {
    WebView webView;
    
    public FragmentWebView() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_webview, null);
    
        webView = (WebView) view.findViewById(R.id.fragment_webview_webview);
        String data = "<html><body><h1>Welcome to WebView</h1></body></html>";
        webView.loadDataWithBaseURL("", data, "text/html", "UTF-8", "");
        
        return view;
    }
}
