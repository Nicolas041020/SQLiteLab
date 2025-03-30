package co.edu.unipiloto.starbuzz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StoreCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_store_category);

        ArrayAdapter<Store> listAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                Store.stores);

        ListView listStores = (ListView) findViewById(R.id.list_store);
        listStores.setAdapter(listAdapter);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> listStores,
                                    View itemView,
                                    int position,
                                    long id){
                Intent intent = new Intent(StoreCategoryActivity.this,StoreActivity.class);
                intent.putExtra(StoreActivity.EXTRA_STOREID, (int) id);
                startActivity(intent);

            }
        };
        listStores.setOnItemClickListener(itemClickListener);
    }
}