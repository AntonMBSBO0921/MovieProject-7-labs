package ru.mirea.sevostyanovmairov.fragmentapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskAdapter extends BaseAdapter {
    private final ArrayList<Task> tasks;
    private final LayoutInflater inflater;

    public TaskAdapter(LayoutInflater inflater, ArrayList<Task> tasks) {
        this.tasks = tasks;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return tasks.size();
    }

    @Override
    public Task getItem(int position) {
        return tasks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item_task, parent, false);
        }

        Task task = getItem(position);
        CheckBox checkBox = convertView.findViewById(R.id.taskCheckBox);
        TextView titleView = convertView.findViewById(R.id.taskTitle);

        titleView.setText(task.getTitle());
        checkBox.setChecked(task.isCompleted());

        checkBox.setOnClickListener(v -> {
            task.setCompleted(checkBox.isChecked());
            notifyDataSetChanged();
        });

        return convertView;
    }
}
