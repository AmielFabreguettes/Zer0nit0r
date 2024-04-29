package com.example.garpinator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PirateListObject extends RecyclerView.Adapter<PirateListObject.ViewHolder> {

    private List<Pirate> pirates;
    private GarpinatorRepo db;

    public PirateListObject(List<Pirate> pirates, GarpinatorRepo db) {
        this.pirates = pirates;
        this.db = db;
    }
    @NonNull
    @Override
    public PirateListObject.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pirate_list_object,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PirateListObject.ViewHolder holder, int position){
        Pirate pirate = pirates.get(position);
        holder.name.setText(pirate.getName());
        holder.crew.setText("from crew");
    }
    @Override
    public int getItemCount(){
        return pirates.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView crew;

        public ViewHolder(@NonNull View itemview){
            super(itemview);
            name = itemview.findViewById(R.id.name);
            crew = itemview.findViewById(R.id.crew);
        }
    }
}
