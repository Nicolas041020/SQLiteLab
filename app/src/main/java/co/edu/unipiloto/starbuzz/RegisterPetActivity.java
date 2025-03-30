package co.edu.unipiloto.starbuzz;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterPetActivity extends AppCompatActivity {

    private EditText name,desc,nameuser;
    StarbuzzDatabaseHelper dbHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register_pet);
        name = findViewById(R.id.name);
        desc = findViewById(R.id.desc);
        nameuser = findViewById(R.id.nameuser);
        dbHelper = new StarbuzzDatabaseHelper(this);
        db = dbHelper.getWritableDatabase();

    }

    public void Submitt(View view) {

        String nameStr = name.getText().toString();
        String description = desc.getText().toString();
        String owner = nameuser.getText().toString();

        if (nameStr.isEmpty() || description.isEmpty() || owner.isEmpty()) {
            Toast.makeText(RegisterPetActivity.this, "Por favor, llena todos los campos", Toast.LENGTH_SHORT).show();
        } else {
            StarbuzzDatabaseHelper.insertPet(db, nameStr, description, owner);
            Toast.makeText(RegisterPetActivity.this, "Mascota guardada correctamente", Toast.LENGTH_SHORT).show();
            name.setText("");
            desc.setText("");
            nameuser.setText("");

            Cursor cursor = dbHelper.getAllData();
            if (cursor.getCount() == 0) {
                Log.d("DB", "No hay datos en la base de datos.");
            } else {
                while (cursor.moveToNext()) {
                    Log.d("DB", "ID: " + cursor.getInt(0) +
                            ", Nombre: " + cursor.getString(1) +
                            ", Descripción: " + cursor.getString(2) +
                            ", Dueño: " + cursor.getString(3));
                }
            }
        }
    }
}