package ru.mirea.MaiorovSevostyanov.Lesson9.presentation;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import ru.mirea.MaiorovSevostyanov.Lesson9.data.repository.MovieRepositoryImpl;
import ru.mirea.MaiorovSevostyanov.Lesson9.domain.repository.MovieRepository;

public class MainViewModelFactory implements ViewModelProvider.Factory {
    private Context context;

    public MainViewModelFactory(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        MovieRepository movieRepository = new MovieRepositoryImpl(context);
        return (T) new MainViewModel(movieRepository);
    }
}