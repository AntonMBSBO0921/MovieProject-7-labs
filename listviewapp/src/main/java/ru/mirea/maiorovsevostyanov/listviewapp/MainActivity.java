package ru.mirea.maiorovsevostyanov.listviewapp;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        ListView bookListView = findViewById(R.id.bookListView);
        List<Book> books = getBooks();
        BookAdapter adapter = new BookAdapter(books, getLayoutInflater());
        bookListView.setAdapter(adapter);
    }

    private List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("1984", "George Orwell"));
        books.add(new Book("Дюна", "Фрэнк Герберт"));
        books.add(new Book("Мастер и Маргарита", "Михаил Булгаков"));
        books.add(new Book("Преступление и наказание", "Фёдор Достоевский"));
        books.add(new Book("Война и мир", "Лев Толстой"));
        books.add(new Book("Гарри Поттер и философский камень", "Джоан Роулинг"));
        books.add(new Book("Властелин колец", "Джон Р.Р. Толкин"));
        books.add(new Book("Евгений Онегин", "Александр Пушкин"));
        books.add(new Book("Три товарища", "Эрих Мария Ремарк"));
        books.add(new Book("Сто лет одиночества", "Габриэль Гарсиа Маркес"));
        books.add(new Book("Анна Каренина", "Лев Толстой"));
        books.add(new Book("Герой нашего времени", "Михаил Лермонтов"));
        books.add(new Book("Маленький принц", "Антуан де Сент-Экзюпери"));
        books.add(new Book("Мёртвые души", "Николай Гоголь"));
        books.add(new Book("Гордость и предубеждение", "Джейн Остин"));
        books.add(new Book("Идиот", "Фёдор Достоевский"));
        books.add(new Book("Портрет Дориана Грея", "Оскар Уайльд"));
        books.add(new Book("Отцы и дети", "Иван Тургенев"));
        books.add(new Book("Над пропастью во ржи", "Джером Сэлинджер"));
        books.add(new Book("Вишнёвый сад", "Антон Чехов"));
        books.add(new Book("Великий Гэтсби", "Фрэнсис Скотт Фицджеральд"));
        books.add(new Book("Собачье сердце", "Михаил Булгаков"));
        books.add(new Book("Fahrenheit 451", "Ray Bradbury"));
        books.add(new Book("Тихий Дон", "Михаил Шолохов"));
        books.add(new Book("Brave New World", "Aldous Huxley"));
        books.add(new Book("Двенадцать стульев", "Илья Ильф и Евгений Петров"));
        books.add(new Book("Граф Монте-Кристо", "Александр Дюма"));
        books.add(new Book("Братья Карамазовы", "Фёдор Достоевский"));
        books.add(new Book("Улисс", "Джеймс Джойс"));
        books.add(new Book("Лолита", "Владимир Набоков"));
        return books;
    }
}