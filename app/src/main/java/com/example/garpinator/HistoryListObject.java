package com.example.garpinator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HistoryListObject extends RecyclerView.Adapter<HistoryListObject.ViewHolder>{
    private List<History> history;
    private GarpinatorRepo db;

    public HistoryListObject(List<History> history, GarpinatorRepo db) {
        this.history = history;
        this.db = db;
    }
    @NonNull
    @Override
    public HistoryListObject.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_list_object,parent,false);
        return new HistoryListObject.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryListObject.ViewHolder holder, int position){
        History histo = history.get(position);
        holder.user.setText(db.getUserById(histo.getUser()).getUsername());
        holder.pirate.setText(db.getPirateById(histo.getPirate()).getName());
    }
    @Override
    public int getItemCount(){
        return history.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView user;
        TextView pirate;

        public ViewHolder(@NonNull View itemview){
            super(itemview);
            user = itemview.findViewById(R.id.user);
            pirate = itemview.findViewById(R.id.pirate);
        }
    }
}
