package interface_adapter.extended_ingredients;

import java.util.List;

public class ExtendedIngredientsState {

    private List<String> recipe = null;

    private Boolean favouritesFilled = false;

    public ExtendedIngredientsState(){
    }

    public void setRecipe(List<String> recipe) {this.recipe = recipe;}

    public List<String> getRecipe() { return this.recipe;}

    public void setFavouritesFilled(Boolean favouritesFilled){
        this.favouritesFilled = favouritesFilled;
    }

    public Boolean getFavouritesFilled(){
        return favouritesFilled;
    }
}
