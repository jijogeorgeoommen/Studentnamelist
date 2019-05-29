package com.example.studentnamelist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private ArrayList<String>studentname;
    public DataAdapter(ArrayList<String>studentname){
        this.studentname=studentname;
    }
    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.studentlist,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.ViewHolder viewHolder, int i) {

        viewHolder.std_name.setText(studentname.get(i));

    }

    @Override
    public int getItemCount() {
        return studentname.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

         TextView std_id;
         TextView std_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            std_name=itemView.findViewById(R.id.textView2);

        }
    }
}
