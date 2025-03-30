package co.edu.unipiloto.starbuzz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TopLevelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.top_level_activity);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> listView,
                                    View view,
                                    int position,
                                    long id){
                if (position==0){
                    Intent intent = new Intent(TopLevelActivity.this,DrinkCategoryActivity.class);
                    startActivity(intent);
                }else if(position==1){
                    Intent intent = new Intent(TopLevelActivity.this,MealsCategoryActivity.class);
                    startActivity(intent);
                }else if(position==2){
                    Intent intent = new Intent(TopLevelActivity.this,StoreCategoryActivity.class);
                    startActivity(intent);
                } else if (position ==3) {
                    Intent intent = new Intent(TopLevelActivity.this,RegisterPetActivity.class);
                    startActivity(intent);
                } else if (position == 4){
                    Intent intent = new Intent(TopLevelActivity.this,ViewPetsActivity.class);
                    startActivity(intent);
                }
            }
        };

        ListView listView = (ListView) findViewById(R.id.list_options);
        listView.setOnItemClickListener(itemClickListener);
    }
}