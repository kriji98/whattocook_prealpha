package project.tp.whattocook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

public class RecipeOfTheDay extends AppCompatActivity {

    private FeatureCoverFlow coverFlow;
    private CoverFlowAdapter adapter;
    private ArrayList<PopularRecipe> PopularRecipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_of_the_day);
        coverFlow = (FeatureCoverFlow) findViewById(R.id.coverflow);

        settingDummyData();
        adapter = new CoverFlowAdapter(this, PopularRecipes);
        coverFlow.setAdapter(adapter);
        coverFlow.setOnScrollPositionListener(onScrollListener());
    }

    private FeatureCoverFlow.OnScrollPositionListener onScrollListener() {
        return new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                Log.v("MainActiivty", "position: " + position);
            }

            @Override
            public void onScrolling() {
                Log.i("MainActivity", "scrolling");
            }
        };
    }

    private void settingDummyData() {
        PopularRecipes = new ArrayList<>();
        PopularRecipes.add(new PopularRecipe(R.mipmap.generic_icon, "Чийзкейк"));
        PopularRecipes.add(new PopularRecipe(R.drawable.salata_s_carevica_i_kedrovi_qdki, "Салата с ядки, семена и царевица"));
        PopularRecipes.add(new PopularRecipe(R.drawable.palachinki, "Палачинки"));
        PopularRecipes.add(new PopularRecipe(R.drawable.salata_s_kuskus, "Салата с кускус"));
        PopularRecipes.add(new PopularRecipe(R.drawable.kufteta_ot_kaima_s_oriz, "Кюфтета от кайма с ориз"));
        PopularRecipes.add(new PopularRecipe(R.mipmap.generic_icon, "Left 4 Dead 2"));
        PopularRecipes.add(new PopularRecipe(R.mipmap.generic_icon, "StarCraft"));
        PopularRecipes.add(new PopularRecipe(R.mipmap.generic_icon, "The Witcher 3"));
        PopularRecipes.add(new PopularRecipe(R.mipmap.generic_icon, "Tom raider 3"));
        PopularRecipes.add(new PopularRecipe(R.mipmap.generic_icon, "Need for Speed Most Wanted"));
    }
}
