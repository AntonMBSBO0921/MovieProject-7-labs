package ru.mirea.sevostyanovmairov.fragmentmanagerapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class DetailFragment extends Fragment {
    private SharedViewModel viewModel;
    private TextView detailsText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        detailsText = view.findViewById(R.id.detailsText);
        
        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        viewModel.getCountryDetails().observe(getViewLifecycleOwner(), details -> {
            detailsText.setText(details);
        });
        
        return view;
    }
} 