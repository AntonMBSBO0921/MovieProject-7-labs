package ru.mirea.maiorovsevostyanov.listviewapp2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class EventAdapter extends BaseAdapter {
    private List<HistoricalEvent> events;
    private LayoutInflater inflater;

    public EventAdapter(List<HistoricalEvent> events, LayoutInflater inflater) {
        this.events = events;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return events.size();
    }

    @Override
    public HistoricalEvent getItem(int position) {
        return events.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.event_item, parent, false);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.eventImage);
            holder.titleView = convertView.findViewById(R.id.eventTitle);
            holder.dateView = convertView.findViewById(R.id.eventDate);
            holder.descriptionView = convertView.findViewById(R.id.eventDescription);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        HistoricalEvent event = getItem(position);

        Picasso.get()
                .load(event.getImageUrl())
                .placeholder(R.drawable.placeholder_image)
                .error(R.drawable.error_image)
                .into(holder.imageView, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {
                        Log.d("ImageLoading", "Success loading image: " + event.getImageUrl());
                    }

                    @Override
                    public void onError(Exception e) {
                        Log.e("ImageLoading", "Error loading image: " + event.getImageUrl(), e);
                    }
                });

        holder.titleView.setText(event.getTitle());
        holder.dateView.setText(event.getDate());
        holder.descriptionView.setText(event.getDescription());

        return convertView;
    }

    private static class ViewHolder {
        ImageView imageView;
        TextView titleView;
        TextView dateView;
        TextView descriptionView;
    }
}