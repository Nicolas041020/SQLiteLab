package co.edu.unipiloto.starbuzz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class CachorroCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cachorro_category);

        ArrayAdapter<Cachorro> listAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Cachorro.CACHORROS);

        ListView listDrinks = (ListView) findViewById(R.id.list_breakfast);
        listDrinks.setAdapter(listAdapter);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> listDrinks,
                                    View itemView,
                                    int position,
                                    long id){
                Intent intent = new Intent(CachorroCategoryActivity.this, CachorroActivity.class);
                intent.putExtra(CachorroActivity.EXTRA_BREAKFASTID, (int) id);
                startActivity(intent);

            }
        };
        listDrinks.setOnItemClickListener(itemClickListener);
    }

}