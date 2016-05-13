package project.tp.whattocook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class RecipesList extends AppCompatActivity {

    private ListView listView = (ListView) findViewById(R.id.recipes_listView);

    // will be using JSON file

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes_list);
    }
}
