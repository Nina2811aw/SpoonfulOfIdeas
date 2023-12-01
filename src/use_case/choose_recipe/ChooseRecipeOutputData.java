package use_case.choose_recipe;

import entity.RecipeInformation;

import java.util.List;

public class ChooseRecipeOutputData {
    public ChooseRecipeOutputData(List<String> recipeDetails) {
        this.recipeDetails = recipeDetails;
    }

    List<String> recipeDetails;
    private Boolean favouriteFilled = false;

    public List<String> getRecipeDetails() {return this.recipeDetails;}

    public void setFavouriteFilled(Boolean favouriteFilled){
        this.favouriteFilled = favouriteFilled;
    }

    public Boolean getFavouriteFilled(){
        return favouriteFilled;
    }
}
