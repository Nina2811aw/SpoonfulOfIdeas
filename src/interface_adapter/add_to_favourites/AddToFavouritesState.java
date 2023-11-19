package interface_adapter.add_to_favourites;

public class AddToFavouritesState {
    private String recipes;

    public AddToFavouritesState(){
    }

    public String getFavourites(){return recipes;}

    public void setFavourites(String recipes){this.recipes = recipes;}



}
