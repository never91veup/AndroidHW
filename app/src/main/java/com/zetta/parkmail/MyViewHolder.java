
package com.zetta.parkmail;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {


    public final TextView numberList;


    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        numberList = itemView.findViewById(R.id.titleNumber);
    }
}