package com.example.projectkelompokv3;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleAdapter extends
        RecyclerView.Adapter<RecycleAdapter.UserViewHolder> {
    Context context;
    OnUserActionListener listener;

    List<Data> listDataInfo;

    public interface OnUserActionListener {

        void onUserAction(Data data);
    }

    public RecycleAdapter(Context context, List<Data> listData, OnUserActionListener listener) {
        this.context = context;
        this.listDataInfo = listData;
        this.listener = listener;
    }


    @NonNull
    @Override
    public RecycleAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.data_item, parent, false);
        UserViewHolder userViewHolder = new UserViewHolder(v);

        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, final int position) {

        final Data currentPerson = listDataInfo.get(position);
        holder.ctxtName.setText(currentPerson.getNama());
        Log.d("sdsd", currentPerson.getNama());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onUserAction(currentPerson);
            }
        });
    }

    @Override
    public int getItemCount() {

        return listDataInfo.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        TextView ctxtName;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            ctxtName = itemView.findViewById(R.id.ctxtName);
        }
    }
}
