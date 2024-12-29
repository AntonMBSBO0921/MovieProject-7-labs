package ru.mirea.maiorovsevostyanov.ScrollViewApp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigInteger;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scroll_view_progression);

        LinearLayout container = findViewById(R.id.container);
        LayoutInflater inflater = LayoutInflater.from(this);

        BigInteger currentValue = BigInteger.ONE;

        for (int i = 1; i <= 100; i++) {
            View itemView = inflater.inflate(R.layout.activity_main, container, false);

            TextView indexView = itemView.findViewById(R.id.indexView);
            TextView valueView = itemView.findViewById(R.id.valueView);

            indexView.setText(i + ":");
            valueView.setText(currentValue.toString());

            container.addView(itemView);

            currentValue = currentValue.multiply(BigInteger.valueOf(2));
        }
    }
}