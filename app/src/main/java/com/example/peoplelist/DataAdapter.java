package com.example.peoplelist;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder>{

    private Context context;
    private int rowID;
    private Team[] teams;

    public DataAdapter(Context context, int rowID, Team[] teams) {
        this.context = context;
        this.rowID = rowID;
        this.teams = teams;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflate the layout and return the tree view
        View v = LayoutInflater.from(this.context).inflate(this.rowID, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // populate / bind the viewholder fields with data
        holder.name.setText(teams[position].getImage());
        holder.networth.setText(teams[position].getNetworth());
        String team_image = teams[position].getImage();
        Integer id = context.getResources().getIdentifier(team_image, "drawable", context.getPackageName());
        holder.icon.setImageResource(id);
        Log.d("Test image", id.toString());

        // still few lines of functionality
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // switch to another activity
                Intent intent = new Intent(context, Activity2.class);
                Team team = teams[holder.getAdapterPosition()];
                intent.putExtra("team_name", team);
                context.startActivity(intent);
            }
        });
    }



    @Override
    public int getItemCount() {
        return teams.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView name;
        public TextView networth;
        public ImageView icon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.textView);
            this.networth = itemView.findViewById(R.id.textViewSubtitle);
            this.icon = itemView.findViewById(R.id.imageView);
        }

    }
}
