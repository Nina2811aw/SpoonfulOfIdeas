package entity;

/**
 * Data structure containing basic information about a recipe, like ID and title.
 */
public class RecipeInformation {

    private int ID;
    private String title;

    /**
     * Constructs a new RecipeInformation instance with the given ID and title.
     *
     * @param ID    the unique identifier for the recipe
     * @param title the title of the recipe
     */
    public RecipeInformation(int ID, String title) {
        this.ID = ID;
        this.title = title;
    }

    /**
     * Gets the ID of the recipe.
     * @return the recipe's unique identifier
     */
    public int getID() {
        return ID;
    }

    /**
     * Sets the ID of the recipe.
     * @param ID the new unique identifier for the recipe
     */

    /**
     * Gets the title of the recipe.
     * @return the recipe's title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the recipe.
     * @param title the new title for the recipe
     **/
}
