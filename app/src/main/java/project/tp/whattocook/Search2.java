package project.tp.whattocook;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Search2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search2);

        final EditText etIngredient = (EditText) findViewById(R.id.search2_ingredient);
        final Button bSearch = (Button) findViewById(R.id.search2_search_button);

        bSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                final String ingredient = etIngredient.getText().toString();
                final String title = new String();
                final String ingredients = new String();
                final String time = new String();
                final String preparation = new String();

                // Response received from the server
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success && (!ingredient.equals(""))) {
                                //    String  = jsonResponse.getString("name");

                                Intent intent = new Intent(Search2.this, AskRecipeOrIdea.class);
                                intent.putExtra("title", title);
                                intent.putExtra("ingredients", ingredients);
                                intent.putExtra("time", time);
                                intent.putExtra("preparation", preparation);
                                Search2.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Search2.this);
                                builder.setMessage("Няма намерени рецепти")
                                        .setNegativeButton("Опитай пак", null)
                                        .create()
                                        .show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                SearchRequest searchRequest = new SearchRequest(ingredient, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Search2.this);
                queue.add(searchRequest);
            }
        });
    }
}
