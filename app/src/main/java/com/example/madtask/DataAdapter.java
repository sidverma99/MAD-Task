package com.example.madtask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {
    private Context mContext;
    private List<RestaurantDetails>[] myList;

    public DataAdapter(Context context, List<RestaurantDetails>[] myList) {
        mContext = context;
        this.myList = myList;
    }

    @NonNull
    @Override
    public DataAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.MyViewHolder holder, int position) {
        holder.hotelName.setText(myList[0].get(position).getRestaurant().getName());
        holder.hotelCity.setText(myList[0].get(position).getRestaurant().getLocation().getCity());
        holder.hotelAddress.setText(myList[0].get(position).getRestaurant().getLocation().getAddress());
        holder.hotelLocality.setText(myList[0].get(position).getRestaurant().getLocation().getLocality());
    }

    @Override
    public int getItemCount() {
        return myList[0].size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView hotelName,hotelCity,hotelAddress,hotelLocality;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            hotelName=itemView.findViewById(R.id.hotel_name);
            hotelCity=itemView.findViewById(R.id.city);
            hotelAddress=itemView.findViewById(R.id.address);
            hotelLocality=itemView.findViewById(R.id.locality);
        }
    }
}
