package com.zetta.parkmail.fragment;


import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zetta.parkmail.DataSource;
import com.zetta.parkmail.MyViewHolder;
import com.zetta.parkmail.NewsModel;
import com.zetta.parkmail.R;
import com.zetta.parkmail.FragmentAccess;

import java.util.List;
import java.util.Objects;

public class MyFragment1 extends Fragment {

    public Button buttonAdd;
    public Activity activity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            activity = (Activity) context;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View v, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);

        RecyclerView recyclerView = v.findViewById(R.id.recycler);

        int currentOrientation = getResources().getConfiguration().orientation;
        if (currentOrientation == Configuration.ORIENTATION_LANDSCAPE) {
            //if landscape

            recyclerView.setLayoutManager(new GridLayoutManager(Objects.requireNonNull(getActivity()).getApplicationContext(), 4));
        } else {
            //if portrait

            recyclerView.setLayoutManager(new GridLayoutManager(Objects.requireNonNull(getActivity()).getApplicationContext(), 3));
        }


        final MyAdapter adapter = new MyAdapter(DataSource.getInstance());

        recyclerView.setAdapter(adapter);
        buttonAdd = v.findViewById(R.id.button_z);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(Objects.requireNonNull(getActivity()).getApplicationContext(),
                        "Элемент добавлен!",
                        Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                adapter.addMetod();
            }
        });
    }

    public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
        private final List<NewsModel> mData;
        private final DataSource uData;

        private MyFragment1 fragment1;

        public MyAdapter(DataSource dataSource) {
            uData = dataSource;
            mData = dataSource.getData();
        }


        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            Log.d("MyAdapter", "onCreateViewHolder");
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_layout, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            Log.d("MyAdapter", "onBindViewHolder with position: " + position);
            NewsModel model;
            model = mData.get(position);
            holder.numberList.setText(model.getNumberList());
            holder.numberList.setBackgroundColor(model.getColor());
            holder.numberList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView digit = v.findViewById(v.getId());
                    int number = Integer.parseInt((String) digit.getText());
                    ((FragmentAccess) activity).onItemClick(number);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }


        public void addMetod() {
            uData.elementAdd();
            notifyDataSetChanged();
        }

    }
}