package entity;

public class RecipeInformation {

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    int ID;

    String title;

    public RecipeInformation(int ID, String title) {
        this.ID = ID;
        this.title = title;
    }
}
