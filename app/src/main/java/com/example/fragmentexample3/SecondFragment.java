package com.example.fragmentexample3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {

    View view;
    private TextView title_textView;
    private TextView desc_textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_second, container, false);

        title_textView = view.findViewById(R.id.textView_title);
        desc_textView = view.findViewById(R.id.textView_description);

//        ISecondFragmentActivity secondFragmentActivity = (ISecondFragmentActivity) getActivity();

        if(getArguments().getString("personality") != null) {
//            secondFragmentActivity.setTitle(String.valueOf(R.string.smug_title));
//            secondFragmentActivity.setDescription(String.valueOf(R.string.smug));
            title_textView.setText(R.string.smug_title);
            desc_textView.setText(R.string.smug);
        }
        else if(getArguments().getString("house_info") != null) {
//            secondFragmentActivity.setTitle(String.valueOf(R.string.house_info));
//            secondFragmentActivity.setDescription(String.valueOf(R.string.house));
            title_textView.setText(R.string.house_info);
            desc_textView.setText(R.string.house);
        }
//


        return view;
    }
}
