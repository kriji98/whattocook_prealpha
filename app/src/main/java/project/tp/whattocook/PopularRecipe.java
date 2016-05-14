package project.tp.whattocook;

public class PopularRecipe {

    private String name;
    private int imageSource;

    public PopularRecipe(int imageSource, String name) {
        this.name = name;
        this.imageSource = imageSource;
    }

    public String getName() {
        return name;
    }

    public int getImageSource() {
        return imageSource;
    }
}
