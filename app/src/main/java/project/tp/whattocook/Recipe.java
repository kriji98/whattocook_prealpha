package project.tp.whattocook;

import java.util.List;

/**
 * Created by root on 5/13/16.
 */

public class Recipe {
    private String title;
    private List<String[]> ingredients;
    private int time;
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

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
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
}


