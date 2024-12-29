package ru.mirea.sevostyanovmairov.fragmentmanagerapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class ListFragment extends Fragment {
    private SharedViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        
        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        
        ListView listView = view.findViewById(R.id.listView);
        String[] countries = {"Russia", "USA", "China", "Japan", "Germany", "France"};
        
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, countries);
        listView.setAdapter(adapter);
        
        listView.setOnItemClickListener((parent, v, position, id) -> {
            String selectedCountry = countries[position];
            viewModel.selectCountry(selectedCountry);
        });
        
        return view;
    }
} 