package com.zetta.parkmail.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import android.graphics.Color;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zetta.parkmail.R;


public class MyFragment2 extends Fragment {
    private static final String DIGIT_KEY = "digit";

    TextView digit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Добавляем layout к фрагменту
        return inflater.inflate(R.layout.fragment_my1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String text = "No";
        Bundle arguments = getArguments();
        if (arguments != null) {
            text = arguments.getString(DIGIT_KEY);
        }
        TextView digit = ((TextView) view.findViewById(R.id.digit));
        digit.setText(text);

        assert text != null;
        int num = Integer.parseInt(text);
        if (num % 2 == 0) digit.setTextColor(Color.RED);
        else digit.setTextColor(Color.BLUE);


    }

    public static MyFragment2 newInstance(int param) {
        MyFragment2 fragment = new MyFragment2();
        Bundle bundle = new Bundle();
        bundle.putString(DIGIT_KEY, String.valueOf(param));
        fragment.setArguments(bundle);
        return fragment;
    }
}
