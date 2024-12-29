package ru.mirea.sevostyanovmairov.resultapifragmentapp;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, new DataFragment())
                .commit();
        }

        getSupportFragmentManager().setFragmentResultListener(
            "requestKey",
            this,
            (requestKey, bundle) -> {
                String result = bundle.getString("key");
                Log.d(MainActivity.class.getSimpleName(), "MainActivity received: " + result);
            }
        );
    }
}