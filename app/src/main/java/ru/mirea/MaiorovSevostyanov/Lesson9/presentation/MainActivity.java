package ru.mirea.MaiorovSevostyanov.Lesson9.presentation;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import ru.mirea.MaiorovSevostyanov.Lesson9.R;

public class MainActivity extends AppCompatActivity {
    private MainViewModel viewModel;
    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextMovie);
        textView = findViewById(R.id.textViewMovie);

        viewModel = new ViewModelProvider(this, new MainViewModelFactory(this))
                .get(MainViewModel.class);

        viewModel.getMovieResult().observe(this, result -> {
            textView.setText(result);
        });

        findViewById(R.id.buttonSaveMovie).setOnClickListener(v -> {
            viewModel.saveMovie(editText.getText().toString());
        });

        findViewById(R.id.buttonGetMovie).setOnClickListener(v -> {
            viewModel.getFavoriteMovie();
        });
    }
}