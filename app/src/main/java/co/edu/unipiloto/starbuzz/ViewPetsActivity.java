package co.edu.unipiloto.starbuzz;

import android.database.Cursor;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ViewPetsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PetAdapter adapter;
    private List<Pet> petList;
    private StarbuzzDatabaseHelper dbHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pets);

        recyclerView = findViewById(R.id.recyclerViewPets);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dbHelper = new StarbuzzDatabaseHelper(this);
        loadData();
    }

    private void loadData() {
        petList = new ArrayList<>();
        Cursor cursor = dbHelper.getAllData();

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String description = cursor.getString(2);
                String owner = cursor.getString(3);
                petList.add(new Pet(id, name, description, owner));
            } while (cursor.moveToNext());
        }
        cursor.close();

        adapter = new PetAdapter(petList);
        recyclerView.setAdapter(adapter);
    }
}