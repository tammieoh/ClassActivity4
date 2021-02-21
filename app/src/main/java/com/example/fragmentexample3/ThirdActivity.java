package com.example.fragmentexample3;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class ThirdActivity extends AppCompatActivity{

//    private TextView title_textView;
//    private TextView desc_textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

//        title_textView = findViewById(R.id.textView_title);
//        desc_textView = findViewById(R.id.textView_description);

        Bundle bundle = new Bundle();
        bundle.putString("house_info", "house");
        SecondFragment secondFragment = new SecondFragment();
        secondFragment.setArguments(bundle);

        loadFragment(secondFragment, R.id.fragContainer_second);
    }
    public void loadFragment(Fragment fragment, int id){
        FragmentManager fragmentManager = getSupportFragmentManager();
        // create a fragment transaction to begin the transaction and replace the fragment
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //replacing the placeholder - fragmentContainterView with the fragment that is passed as parameter
        fragmentTransaction.replace(id, fragment);
        fragmentTransaction.commit();
    }

//    @Override
//    public void setTitle(String title) {
////        title_textView.setText(R.string.house_info);
//    }
//    @Override
//    public void setDescription(String description) {
////        desc_textView.setText(R.string.house);
//    }

}
