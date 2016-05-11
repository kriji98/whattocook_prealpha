package project.tp.whattocook;

/**
 * Created by kristiana on 09.05.16.
 */
public class ChildRow {
    private int icon;
    private String text;

    public ChildRow(String text, int icon) {
        this.text = text;
        this.icon = icon;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
