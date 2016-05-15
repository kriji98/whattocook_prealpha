package project.tp.whattocook;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by victoria on 5/15/16.
 */

public class AddRecipesRequest extends StringRequest {

        private static final String RECIPES_REQUEST_URL = "http://whattocook.site88.net/Recipes.php";
        private Map<String, String> params;

        public AddRecipesRequest (String title, String time, String ingredients, String preparation, Response.Listener<String> listener) {
            super(Method.POST, RECIPES_REQUEST_URL, listener, null);
            params = new HashMap<>();
            params.put("title", title);
            params.put("time", time);
            params.put("ingredients", ingredients);
            params.put("preparation", preparation);
        }

        @Override
        public Map<String, String> getParams() {
            return params;
        }
    
}
