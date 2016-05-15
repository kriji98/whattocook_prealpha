package project.tp.whattocook;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

public class AddRecipes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipes);
        /*Button addPhoto = (Button) findViewById(R.id.button_add_recipes_photo);
        ImageView ivPhoto = (ImageView) findViewById(R.id.ivAdd_Recipes);

        addPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivity(intent);
            }
        });*/

        final EditText etTitle = (EditText) findViewById(R.id.add_recipes_title_recipe);
        final EditText etTime = (EditText) findViewById(R.id.add_recipes_time);
        final EditText etIngredients = (EditText) findViewById(R.id.add_recipes_ingredients);
        final EditText etPreparation = (EditText) findViewById(R.id.add_recipes_preparation);
        final Button upload = (Button) findViewById(R.id.button_add_recipes_ready);

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String title = etTitle.getText().toString();
                final String time = etTime.getText().toString();
                final String ingredients = etIngredients.getText().toString();
                final String preparation = etPreparation.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Log.i(Home.TAG, response);
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success && ((!time.equals("")) && (!title.equals("")) && (!ingredients.equals("")))) {
                                Intent intent = new Intent(AddRecipes.this, AskRecipeOrIdea.class);
                                AddRecipes.this.startActivity(intent);
                            } else {
                                if (!success) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(AddRecipes.this);
                                    builder.setMessage("Неуспешно качване")
                                            .setNegativeButton("Опитай пак", null)
                                            .create()
                                            .show();
                                }

                                if ((preparation.equals("")) || (time.equals("")) || (title.equals("")) || (ingredients.equals(""))) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(AddRecipes.this);
                                    builder.setMessage("Моля, попълнете празните полета")
                                            .setNegativeButton("Добре", null)
                                            .create()
                                            .show();
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                AddRecipesRequest addRecipesRequest = new AddRecipesRequest(title, time, ingredients, preparation, responseListener);
                RequestQueue queue = Volley.newRequestQueue(AddRecipes.this);
                queue.add(addRecipesRequest);
            }
        });
    }

}