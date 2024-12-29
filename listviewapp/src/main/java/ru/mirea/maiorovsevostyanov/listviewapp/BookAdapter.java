package ru.mirea.maiorovsevostyanov.listviewapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class BookAdapter extends BaseAdapter {
    private List<Book> books;
    private LayoutInflater inflater;

    public BookAdapter(List<Book> books, LayoutInflater inflater) {
        this.books = books;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Book getItem(int position) {
        return books.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.activity_main, parent, false);
        }

        Book book = getItem(position);
        TextView titleView = convertView.findViewById(R.id.titleView);
        TextView authorView = convertView.findViewById(R.id.authorView);

        titleView.setText(book.getTitle());
        authorView.setText(book.getAuthor());

        return convertView;
    }
}