package project.tp.whattocook;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private String title;
    private List<String[]> ingredients;
    private String time;
    private String[] preparation;
    private String image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String[]> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String[]> ingredients) {
        this.ingredients = ingredients;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String[] getPreparation() {
        return preparation;
    }

    public void setPreparation(String[] preparation) {
        this.preparation = preparation;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ArrayList<Recipe> parse(String filename, Context context) throws JSONException {
        String json;

        try {

            InputStream inputStream = context.openFileInput(filename);

            int size = inputStream.available();

            byte[] buffer = new byte[size];

            inputStream.read(buffer);

            inputStream.close();

            json = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        JSONObject object = new JSONObject(json);

        return null;
    }

}


