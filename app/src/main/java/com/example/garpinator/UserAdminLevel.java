package com.example.garpinator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
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

public class UserAdminLevel extends RecyclerView.Adapter<UserAdminLevel.ViewHolder> {
    private List<User> users;
    private GarpinatorRepo db;

    private SharedPreferences prefs;

    public UserAdminLevel(List<User> users,GarpinatorRepo db, SharedPreferences prefs) {
        this.users = users;
        this.db = db;
        this.prefs = prefs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_admin_level,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        User user = users.get(position);
        holder.username.setText(user.getUsername());
        holder.adminButton.setChecked(user.isAdmin());
        holder.adminButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            user.setAdmin(isChecked);
            db.changeAdmin(user.getUsername(),isChecked);
        });

        holder.delete_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user.getUsername().equals(prefs.getString("curUser",""))){
                    Toast.makeText(v.getContext(),
                            "You can't delete yourself",Toast.LENGTH_SHORT).show();
                }
                else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(
                            v.getContext());
                    builder.setMessage("Are you sure you want to delete " +
                                    user.getUsername() + " ?")
                                    .setTitle("Delete ?")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    db.deleteUser(user.getUsername());
                                    Toast.makeText(v.getContext(),
                                            "User deleted successfully", Toast.LENGTH_SHORT).show();
                                    users = db.getAllUsers();
                                    notifyDataSetChanged();
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog popup = builder.create();
                    popup.show();
                }
            }
        });
    }
    @Override
    public int getItemCount(){
        return users.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView username;
        Switch adminButton;

        Button delete_user;

        public ViewHolder(@NonNull View itemview){
            super(itemview);
            username = itemview.findViewById(R.id.username);
            adminButton = itemview.findViewById(R.id.admin_toggle);
            delete_user = itemview.findViewById(R.id.delete);
        }
    }
}
