package co.edu.unipiloto.starbuzz;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class CachorroActivity extends AppCompatActivity {

    public static final String EXTRA_BREAKFASTID = "breakfastId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cachorro);

        int breakfastId = (Integer)getIntent().getExtras().get(EXTRA_BREAKFASTID);
        Cachorro cachorro = Cachorro.CACHORROS[breakfastId];

        TextView name = (TextView) findViewById(R.id.name);
        name.setText(cachorro.getName());

        TextView description = (TextView) findViewById(R.id.description);
        description.setText(cachorro.getDescription());

        ImageView photo = (ImageView) findViewById(R.id.photo);
        photo.setImageResource(cachorro.getImageResourceId());
        photo.setContentDescription(cachorro.getName());
    }

    public void Buy(View view) {
        Toast.makeText(CachorroActivity.this,"Compra realizada con exito",Toast.LENGTH_SHORT).show();
    }
}