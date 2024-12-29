package ru.mirea.sevostyanovmairov.fragmentapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;

public class TaskListFragment extends Fragment {
    private static final String ARG_STUDENT_NUMBER = "student_number";
    private ArrayList<Task> tasks;
    private TaskAdapter adapter;

    public static TaskListFragment newInstance(int studentNumber) {
        TaskListFragment fragment = new TaskListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_STUDENT_NUMBER, studentNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task_list, container, false);
        
        Bundle args = getArguments();
        int studentNumber = 0;
        if (args != null) {
            studentNumber = args.getInt(ARG_STUDENT_NUMBER, 0);
        }
        
        TextView textView = view.findViewById(R.id.student_number_text);
        textView.setText("Номер студента: " + studentNumber);
        
        // Инициализируем список задач
        tasks = new ArrayList<>();
        tasks.add(new Task("Изучить фрагменты", false));
        tasks.add(new Task("Создать список", false));
        tasks.add(new Task("Реализовать адаптер", false));
        tasks.add(new Task("Протестировать приложение", false));
        
        // Находим ListView и устанавливаем адаптер
        ListView listView = view.findViewById(R.id.task_list);
        adapter = new TaskAdapter(getLayoutInflater(), tasks);
        listView.setAdapter(adapter);
        
        return view;
    }
} 