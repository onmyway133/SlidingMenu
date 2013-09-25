package com.entropy.slidingmenu2;


import com.entropy.slidingmenu2.fragment.FragmentButton;
import com.entropy.slidingmenu2.fragment.FragmentCheckBox;
import com.entropy.slidingmenu2.fragment.FragmentEditText;
import com.entropy.slidingmenu2.fragment.FragmentImageView;
import com.entropy.slidingmenu2.fragment.FragmentListView;
import com.entropy.slidingmenu2.fragment.FragmentMain;
import com.entropy.slidingmenu2.fragment.FragmentRadioButton;
import com.entropy.slidingmenu2.fragment.FragmentTextView;
import com.entropy.slidingmenu2.fragment.FragmentToggleButton;
import com.entropy.slidingmenu2.fragment.FragmentWebView;
import com.entropy.slidingmenu2.layout.MainLayout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

// DK 
// This is my studying about Sliding Menu following Youtube video
public class MainActivity extends FragmentActivity {

    // The MainLayout which will hold both the sliding menu and our main content
    // Main content will holds our Fragment respectively
    MainLayout mainLayout;
    
    // ListView menu
    private ListView lvMenu;
    private String[] lvMenuItems;
    
    // Menu button
    Button btMenu;
    
    // Title according to fragment
    TextView tvTitle;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Inflate the mainLayout
        mainLayout = (MainLayout)this.getLayoutInflater().inflate(R.layout.activity_main, null);
        setContentView(mainLayout);
        
        // Init menu
        
        lvMenuItems = getResources().getStringArray(R.array.menu_items);
        lvMenu = (ListView) findViewById(R.id.activity_main_menu_listview);
        lvMenu.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, lvMenuItems));
        lvMenu.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onMenuItemClick(parent, view, position, id);
            }
            
        });
        
        
        // Get menu button
        btMenu = (Button) findViewById(R.id.activity_main_content_button_menu);
        btMenu.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show/hide the menu
                toggleMenu(v);
            }
        });
        
        // Get title textview
        tvTitle = (TextView) findViewById(R.id.activity_main_content_title);
        
        
        // Add FragmentMain as the initial fragment       
        FragmentManager fm = MainActivity.this.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        
        FragmentMain fragment = new FragmentMain();
        ft.add(R.id.activity_main_content_fragment, fragment);
        ft.commit();   
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void toggleMenu(View v){
        mainLayout.toggleMenu();
    }
    
    // Perform action when a menu item is clicked
    private void onMenuItemClick(AdapterView<?> parent, View view, int position, long id) {
        String selectedItem = lvMenuItems[position];
        String currentItem = tvTitle.getText().toString();
        
        // Do nothing if selectedItem is currentItem
        if(selectedItem.compareTo(currentItem) == 0) {
            mainLayout.toggleMenu();
            return;
        }
            
        FragmentManager fm = MainActivity.this.getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment fragment = null;

        
        if(selectedItem.compareTo("Main") == 0) {
            fragment = new FragmentMain();
        } else if(selectedItem.compareTo("Button") == 0) {
            fragment = new FragmentButton();
        } else if(selectedItem.compareTo("CheckBox") == 0) {
            fragment = new FragmentCheckBox();
        } else if(selectedItem.compareTo("EditText") == 0) {
            fragment = new FragmentEditText();
        } else if(selectedItem.compareTo("ImageView") == 0) {
            fragment = new FragmentImageView();
        } else if(selectedItem.compareTo("ListView") == 0) {
            fragment = new FragmentListView();
        } else if(selectedItem.compareTo("RadioButton") == 0) {
            fragment = new FragmentRadioButton();
        } else if(selectedItem.compareTo("TextView") == 0) {
            fragment = new FragmentTextView();
            Bundle b = new Bundle();
            b.putString("KEY_STRING", "Please display this text");
            fragment.setArguments(b);
        } else if(selectedItem.compareTo("ToggleButton") == 0) {
            fragment = new FragmentToggleButton();
        } else if(selectedItem.compareTo("WebView") == 0) {
            fragment = new FragmentWebView();
        }
        
        if(fragment != null) {
            // Replace current fragment by this new one
            ft.replace(R.id.activity_main_content_fragment, fragment);
            ft.commit();
            
            // Set title accordingly
            tvTitle.setText(selectedItem);
        }
        
        // Hide menu anyway
        mainLayout.toggleMenu();
    }
    
    @Override
    public void onBackPressed() {
        if (mainLayout.isMenuShown()) {
            mainLayout.toggleMenu();
        }
        else {
            super.onBackPressed();
        }
    }
}
