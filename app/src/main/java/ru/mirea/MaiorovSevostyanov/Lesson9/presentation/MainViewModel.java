package ru.mirea.MaiorovSevostyanov.Lesson9.presentation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import ru.mirea.MaiorovSevostyanov.Lesson9.domain.models.Movie;
import ru.mirea.MaiorovSevostyanov.Lesson9.domain.repository.MovieRepository;
import ru.mirea.MaiorovSevostyanov.Lesson9.domain.usecases.GetFavoriteFilmUseCase;
import ru.mirea.MaiorovSevostyanov.Lesson9.domain.usecases.SaveMovieToFavoriteUseCase;

public class MainViewModel extends ViewModel {
    private MovieRepository movieRepository;
    private MutableLiveData<String> movieResult = new MutableLiveData<>();

    public MainViewModel(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public LiveData<String> getMovieResult() {
        return movieResult;
    }

    public void saveMovie(String movieName) {
        Boolean result = new SaveMovieToFavoriteUseCase(movieRepository)
                .execute(new Movie(2, movieName));
        movieResult.setValue(String.format("Результат сохранения: %s", result));
    }

    public void getFavoriteMovie() {
        Movie movie = new GetFavoriteFilmUseCase(movieRepository).execute();
        movieResult.setValue(String.format("Любимый фильм: %s", movie.getName()));
    }
}