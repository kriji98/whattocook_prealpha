package project.tp.whattocook;

public class PopularRecipe {

    private String name;
    private int imageSource;
    private String time;
    private String ingredients;
    private String preparation;

    public PopularRecipe(int imageSource, String name) {
        this.name = name;
        this.imageSource = imageSource;
    }

    public PopularRecipe(int imageSource, String name, String time, String ingredients, String preparation) {
        this.name = name;
        this.imageSource = imageSource;
        this.time = time;
        this.ingredients = ingredients;
        this.preparation = preparation;
    }

    public String getName() {
        return name;
    }

    public int getImageSource() {
        return imageSource;
    }

    public String getTime() {
        return time;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getPreparation() {
        return preparation;
    }
}