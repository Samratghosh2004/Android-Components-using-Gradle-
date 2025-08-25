package com.example.recylerview;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder> {
            Context context;
            ArrayList<contactMedel> cm;

    RecyclerContactAdapter(Context context, ArrayList<contactMedel> cm) {

        this.context = context;
        this.cm = cm;
    }
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.contact_row,parent, false);
        // Creating object of defined bellow class ViewHolder
        ViewHolder viewHolder = new ViewHolder(v);
                return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.img.setImageResource(cm.get(position).img);
        holder.t_name.setText(cm.get(position).name);
        holder.t_number.setText(cm.get(position).number);


        //============== OPERATIONS WILL BE PERFORM HERE =================
    }

    @Override
    public int getItemCount() {
        return cm.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView t_name, t_number;
        ImageView img;
        public ViewHolder(View a) {
            super(a);

            t_name = a.findViewById(R.id.txt);
            t_number = a.findViewById(R.id.txtTwo);
            img = a.findViewById(R.id.img);
        }
    }
}
