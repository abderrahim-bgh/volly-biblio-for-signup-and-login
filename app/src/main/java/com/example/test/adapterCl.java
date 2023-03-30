package com.example.test;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class adapterCl extends RecyclerView.Adapter<adapterCl.ViewHolder>{

    private List<info> infoList;
    Context activity;
    public adapterCl(Context activity, List<info> infolist) {
        this.activity = activity;
        this.infoList = infolist;

    }
    @NonNull
    @Override
    public adapterCl.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapterCl.ViewHolder holder, int position) {

        info in = infoList.get(position);
        Toast.makeText(activity,infoList.get(1).getTitel2() , Toast.LENGTH_SHORT).show();

        holder.txt.setText(in.getTitel1());
        holder.t2.setText(in.getTitel2());
        holder.img.setImageResource(R.drawable.hh);
        Toast.makeText(activity,in.getTitel2() , Toast.LENGTH_SHORT).show();

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(activity);
                dialog.setContentView(R.layout.dialog_edit);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                EditText editText = dialog.findViewById(R.id.edit_c);
                AppCompatButton cancel = dialog.findViewById(R.id.cncl_btn);
                AppCompatButton add = dialog.findViewById(R.id.add);
                editText.setText(in.getTitel1());
                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        holder.txt.setText(editText.getText().toString());
                        dialog.dismiss();
                    }
                });
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return infoList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txt ,t2;
        ImageView img,edit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt=itemView.findViewById(R.id.Titel);
            t2=itemView.findViewById(R.id.Titel2);
            edit=itemView.findViewById(R.id.edit);
            img=itemView.findViewById(R.id.img);

        }
    }
    }

