package project.tp.whattocook;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by victoria on 5/15/16.
 */

public class SearchRequest extends StringRequest {

    private static final String SEARCH_REQUEST_URL = "http://whattocook.site88.net/Search.php";
    private Map<String, String> params;

    public SearchRequest (String ingredient, Response.Listener<String> listener) {
        super(Request.Method.POST, SEARCH_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("ingredient", ingredient);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }

}
