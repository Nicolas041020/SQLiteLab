package co.edu.unipiloto.starbuzz;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class AdultoActivity extends AppCompatActivity {

    public static final String EXTRA_SNACKID = "snackId";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adulto);

        int snackId =(Integer)getIntent().getExtras().get(EXTRA_SNACKID);
        Adulto adulto = Adulto.ADULTOS[snackId];

        TextView name = (TextView) findViewById(R.id.name);
        name.setText(adulto.getName());

        TextView description = (TextView) findViewById(R.id.description);
        description.setText(adulto.getDescription());

        ImageView photo = (ImageView) findViewById(R.id.photo);
        photo.setImageResource(adulto.getImageResourceId());
        photo.setContentDescription(adulto.getName());
    }

    public void Buy(View view) {
        Toast.makeText(AdultoActivity.this,"Compra realizada con exito",Toast.LENGTH_SHORT).show();

    }
}