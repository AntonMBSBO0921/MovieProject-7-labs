package ru.mirea.MaiorovSevostyanov.Lesson9.data.repository;

import ru.mirea.MaiorovSevostyanov.Lesson9.domain.models.Movie;
import ru.mirea.MaiorovSevostyanov.Lesson9.domain.repository.MovieRepository;

import android.content.Context;
import android.content.SharedPreferences;

public class MovieRepositoryImpl implements MovieRepository {
    private static final String PREFS_NAME = "favorite_movie_prefs";
    private static final String KEY_MOVIE_ID = "movie_id";
    private static final String KEY_MOVIE_NAME = "movie_name";
    private SharedPreferences sharedPreferences;

    public MovieRepositoryImpl(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public boolean saveMovie(Movie movie) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_MOVIE_ID, movie.getId());
        editor.putString(KEY_MOVIE_NAME, movie.getName());
        return editor.commit();
    }

    @Override
    public Movie getMovie() {
        int id = sharedPreferences.getInt(KEY_MOVIE_ID, -1);
        String name = sharedPreferences.getString(KEY_MOVIE_NAME, "Нет данных");
        return new Movie(id, name);
    }
}

