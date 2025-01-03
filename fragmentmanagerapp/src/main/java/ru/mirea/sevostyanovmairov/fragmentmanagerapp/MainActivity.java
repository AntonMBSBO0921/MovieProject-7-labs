package ru.mirea.sevostyanovmairov.fragmentmanagerapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.listContainer, new ListFragment(), "list")
                    .add(R.id.detailContainer, new DetailFragment(), "detail")
                    .commit();
        }
    }
}