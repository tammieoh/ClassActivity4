package com.example.fragmentexample3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private boolean twoPane = false;


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
                launchSecondActivity(v);
            });
//
            Button button_houseInfo = findViewById(R.id.button_houseInfo);
            button_houseInfo.setOnClickListener(v -> {
                launchThirdActivity(v);
            });

        }
        else {
            Bundle bundle = new Bundle();
            bundle.putString("personality", String.valueOf(R.string.smug));
            SecondFragment secondFragment_personality = new SecondFragment();
            secondFragment_personality.setArguments(bundle);

            Bundle bundle_house = new Bundle();
            SecondFragment secondFragment_house = new SecondFragment();
            bundle_house.putString("house_info", String.valueOf(R.string.house));
            secondFragment_house.setArguments(bundle_house);


            loadFragment(new FirstFragment(), R.id.fragContainer_landFirst);
            loadFragment(secondFragment_personality, R.id.fragContainer_landSecondSmug);
            loadFragment(secondFragment_house, R.id.fragContainer_landSecondHouse);
        }
    }

    public void loadFragment(Fragment fragment, int id){
        FragmentManager fragmentManager = getSupportFragmentManager();
        // create a fragment transaction to begin the transaction and replace the fragment
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //replacing the placeholder - fragmentContainterView with the fragment that is passed as parameter
        fragmentTransaction.replace(id, fragment);
        fragmentTransaction.commit();
    }

    public void launchSecondActivity(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);

    }
    public void launchThirdActivity(View view){
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);

    }
}