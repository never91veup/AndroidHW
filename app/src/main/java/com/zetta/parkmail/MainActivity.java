package com.zetta.parkmail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.zetta.parkmail.fragment.MyFragment2;
import com.zetta.parkmail.fragment.MyFragment1;


public class MainActivity extends AppCompatActivity implements FragmentAccess {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.top_container, new MyFragment1())
                    .commit();
        }

    }

    @Override
    public void onItemClick(int digit) {
        // Заменяем фрагмент айтема списка
        Fragment fragment = MyFragment2.newInstance(digit);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.top_container, fragment)
                .addToBackStack("Fragment close")
                .commit();

    }

}





