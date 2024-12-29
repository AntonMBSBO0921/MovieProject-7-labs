package ru.mirea.maiorovsevostyanov.retrofitapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TodoAdapter extends RecyclerView.Adapter<TodoViewHolder> {
    private static final String TAG = "TodoAdapter";
    private static final String[] IMAGE_URLS = {
            "https://images.unsplash.com/photo-1484480974693-6ca0a78fb36b?w=200&h=200&fit=crop",  // Рабочий стол
            "https://images.unsplash.com/photo-1507925921958-8a62f3d1a50d?w=200&h=200&fit=crop",  // Ноутбук
            "https://images.unsplash.com/photo-1512314889357-e157c22f938d?w=200&h=200&fit=crop"   // Заметки
    };
    
    private LayoutInflater layoutInflater;
    private List<Todo> todos;
    private ApiService apiService;
    private Context context;

    // Параметры для настройки изображений
    private boolean isRoundedCorners = true;
    private int imageSize = 20;
    private boolean isCenterCrop = true;
    private float rotationDegrees = 0f;

    public TodoAdapter(Context context, List<Todo> todoList, ApiService apiService) {
        this.layoutInflater = LayoutInflater.from(context);
        this.todos = todoList;
        this.apiService = apiService;
        this.context = context;
    }

    // Методы для настройки параметров
    public void setRoundedCorners(boolean enabled) {
        this.isRoundedCorners = enabled;
        notifyDataSetChanged();
    }

    public void setImageSize(int size) {
        this.imageSize = size;
        notifyDataSetChanged();
    }

    public void setCenterCrop(boolean enabled) {
        this.isCenterCrop = enabled;
        notifyDataSetChanged();
    }

    public void setRotation(float degrees) {
        this.rotationDegrees = degrees;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item, parent, false);
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        Todo todo = todos.get(position);
        holder.textViewTitle.setText(todo.getTitle());
        holder.textViewId.setText("ID: " + todo.getId());
        holder.checkBoxCompleted.setChecked(todo.getCompleted());
        
        String imageUrl = IMAGE_URLS[position % IMAGE_URLS.length];
        
        // Настраиваем загрузку изображения с учетом параметров
        Picasso.get()
                .load(imageUrl)
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_background)
                .resize(imageSize, imageSize) // Настраиваемый размер
//                .rotate(rotationDegrees) // Поворот изображения
                .transform(isRoundedCorners ? new RoundedCornersTransformation(100, 0) : null) // Скругленные углы
                .centerCrop() // Если нужно центрирование
                .into(holder.imageViewTodo);
        
        holder.checkBoxCompleted.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                todo.setCompleted(isChecked);
                updateTodo(todo);
            }
        });
    }

    private void updateTodo(Todo todo) {
        Call<Todo> call = apiService.updateTodo(todo.getId(), todo);
        call.enqueue(new Callback<Todo>() {
            @Override
            public void onResponse(Call<Todo> call, Response<Todo> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "Todo updated successfully");
                } else {
                    Log.e(TAG, "Failed to update todo: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Todo> call, Throwable t) {
                Log.e(TAG, "Error updating todo: " + t.getMessage());
            }
        });
    }

    @Override
    public int getItemCount() {
        return todos.size();
    }
} 