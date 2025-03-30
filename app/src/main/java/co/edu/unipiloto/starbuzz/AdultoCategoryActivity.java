package co.edu.unipiloto.starbuzz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class AdultoCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adulto_category);

        ArrayAdapter<Adulto> listAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Adulto.ADULTOS);

        ListView listDrinks = (ListView) findViewById(R.id.list_snacks);
        listDrinks.setAdapter(listAdapter);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> listDrinks,
                                    View itemView,
                                    int position,
                                    long id){
                Intent intent = new Intent(AdultoCategoryActivity.this, AdultoActivity.class);
                intent.putExtra(AdultoActivity.EXTRA_SNACKID, (int) id);
                startActivity(intent);

            }
        };
        listDrinks.setOnItemClickListener(itemClickListener);
    }
}