package com.example.projectkelompokv3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleAdapter extends
        RecyclerView.Adapter<RecycleAdapter.UserViewHolder> { Context context;
    OnUserClickListener listener;

    List<Data> listDataInfo;

    public RecycleAdapter(Context context, List<Data>

            listDataInfo, OnUserClickListener listener) { this.context=context; this.listDataInfo=listDataInfo; this.listener=listener;
    }

    public	interface OnUserClickListener{

        void onUserClick(Data currentPerson, String action);
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view=
                LayoutInflater.from(parent.getContext()).inflate(R.layout.data_item,parent,false); UserViewHolder userViewHolder=new UserViewHolder(view);

        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, final int position) {

        final Data currentPerson=listDataInfo.get(position);
        holder.ctxtName.setText(currentPerson.getNama());
    }

    @Override
    public int getItemCount() {

        return listDataInfo.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        TextView ctxtName;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            ctxtName=itemView.findViewById(R.id.ctxtName);
        }
    }
}
