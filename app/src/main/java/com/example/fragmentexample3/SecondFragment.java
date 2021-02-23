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

        ISecondFragmentActivity secondFragmentActivity = (ISecondFragmentActivity) getActivity();

        title_textView.setText(secondFragmentActivity.getText());
        desc_textView.setText(secondFragmentActivity.getDescription());

        return view;
    }
}
