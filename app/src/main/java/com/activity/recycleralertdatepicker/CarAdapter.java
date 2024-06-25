package com.activity.recycleralertdatepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {

    interface OnCarClickListener {
        void onCarClick(Car car, int position);
    }

    private final OnCarClickListener onClickListener;

    private final LayoutInflater inflater;
    private final List<Car> cars;

    public CarAdapter(Context context, List<Car> cars, OnCarClickListener onClickListener) {
        this.inflater = LayoutInflater.from(context);
        this.cars = cars;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Car car = cars.get(position);
        holder.photo.setImageResource(car.getPhoto());
        holder.brand.setText(car.getBrand());
        holder.model.setText(car.getModel());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickListener.onCarClick(car, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        final ImageView photo;
        final TextView brand, model;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            photo = itemView.findViewById(R.id.photo);
            brand = itemView.findViewById(R.id.brand);
            model = itemView.findViewById(R.id.model);
        }
    }
}
