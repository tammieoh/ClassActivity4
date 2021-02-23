package com.example.fragmentexample3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.time.chrono.IsoChronology;

public class MainActivity extends AppCompatActivity implements ISecondFragmentActivity{

    private boolean twoPane = false;
    protected String smug = "smug";
    protected String house = "house_info";
    private boolean loadTitle = true, loadDescription = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // if we can find the second fragment in the layout
        // that means we have 2 panes -> landscape
        if (findViewById(R.id.fragContainer_landSecondSmug) != null && findViewById(R.id.fragContainer_landSecondHouse) != null) {
            twoPane = true;
        }
        // loading in whether 1 or 2 frags based on this boolean variable
        if(!twoPane) {
            loadFragment(new FirstFragment(), R.id.fragContainer_first);
            Button button_personality = findViewById(R.id.button_personality);

            button_personality.setOnClickListener(v -> {
                launchActivity(v);
            });
//
            Button button_houseInfo = findViewById(R.id.button_houseInfo);
            button_houseInfo.setOnClickListener(v -> {
                launchThirdActivity(v);
            });

        }
        else {

            loadFragment(new FirstFragment(), R.id.fragContainer_landFirst);

            SecondFragment secondFragment_personality = new SecondFragment();
            loadFragment(secondFragment_personality, R.id.fragContainer_landSecondSmug);

            SecondFragment secondFragment_house = new SecondFragment();
            loadFragment(secondFragment_house, R.id.fragContainer_landSecondHouse);
        }
    }

    public void loadFragment(Fragment fragment, int id){
        FragmentManager fragmentManager = getSupportFragmentManager();
        // create a fragment transaction to begin the transaction and replace the fragment
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //replacing the placeholder - fragmentContainerView with the fragment that is passed as parameter
        fragmentTransaction.replace(id, fragment);
        fragmentTransaction.commit();
    }

    public void launchActivity(View view){
        Intent intent = new Intent(this, SecondActivity.class);
//        intent.putExtra("button_text", button_personality.getText());
        startActivity(intent);

    }
    public void launchThirdActivity(View view){
        Intent intent = new Intent(this, ThirdActivity.class);
//        intent.putExtra("button_text", button_house.getText());
        startActivity(intent);

    }

    @Override
    public String getText() {
        String text = "";
        if(this.loadTitle) {
            text = getResources().getString(R.string.smug_title);
            this.loadTitle = false;
        }
        else {
            text = getResources().getString(R.string.house_info);
        }
        return text;
    }

    @Override
    public String getDescription() {
        String text = "";
        if(this.loadDescription) {
            text = getResources().getString(R.string.smug);
            this.loadDescription = false;
        }
        else {
            text = getResources().getString(R.string.house);
        }
        return text;
    }
}