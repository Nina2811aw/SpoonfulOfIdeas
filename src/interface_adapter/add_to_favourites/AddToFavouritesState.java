package interface_adapter.add_to_favourites;

public class AddToFavouritesState {
    private String recipes;

    public AddToFavouritesState(){
    }
// Returns the current favourited recipes.
    public String getFavourites(){return recipes;}
//sets the current favourited recipes
    public void setFavourites(String recipes){this.recipes = recipes;}



}
