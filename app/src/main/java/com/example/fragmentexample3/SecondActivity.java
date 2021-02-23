package com.example.fragmentexample3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class SecondActivity extends AppCompatActivity implements ISecondFragmentActivity{

//    private TextView title_textView;
//    private TextView desc_textView;
//    private String title;
//    private String description;
//    protected String title;
//    protected String description = String.valueOf(R.string.smug);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        SecondFragment secondFragment = new SecondFragment();
        loadFragment(secondFragment, R.id.fragContainer_second);
    }

    public void loadFragment(Fragment fragment, int id){
        FragmentManager fragmentManager = getSupportFragmentManager();
        // create a fragment transaction to begin the transaction and replace the fragment
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //replacing the placeholder - fragmentContainerView with the fragment that is passed as parameter
        fragmentTransaction.replace(id, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public String getText() {
        return getResources().getString(R.string.smug_title);
    }

    @Override
    public String getDescription() {
        return getResources().getString(R.string.smug);
    }

}
