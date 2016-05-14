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
        PopularRecipes.add(new PopularRecipe(R.mipmap.generic_icon, "Assassin Creed 3"));
        PopularRecipes.add(new PopularRecipe(R.mipmap.generic_icon, "Avatar 3D"));
        PopularRecipes.add(new PopularRecipe(R.mipmap.generic_icon, "Call Of Duty Black Ops 3"));
        PopularRecipes.add(new PopularRecipe(R.mipmap.generic_icon, "DotA 2"));
        PopularRecipes.add(new PopularRecipe(R.mipmap.generic_icon, "Halo 5"));
        PopularRecipes.add(new PopularRecipe(R.mipmap.generic_icon, "Left 4 Dead 2"));
        PopularRecipes.add(new PopularRecipe(R.mipmap.generic_icon, "StarCraft"));
        PopularRecipes.add(new PopularRecipe(R.mipmap.generic_icon, "The Witcher 3"));
        PopularRecipes.add(new PopularRecipe(R.mipmap.generic_icon, "Tom raider 3"));
        PopularRecipes.add(new PopularRecipe(R.mipmap.generic_icon, "Need for Speed Most Wanted"));
    }
}
