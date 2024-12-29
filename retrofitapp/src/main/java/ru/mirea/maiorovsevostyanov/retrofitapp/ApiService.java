package ru.mirea.maiorovsevostyanov.retrofitapp;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Body;

public interface ApiService {
    @GET("todos")
    Call<List<Todo>> getTodos();
    
    @PUT("todos/{id}")
    Call<Todo> updateTodo(@Path("id") int id, @Body Todo todo);
} 