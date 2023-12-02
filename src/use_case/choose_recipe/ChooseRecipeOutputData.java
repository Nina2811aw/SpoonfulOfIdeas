package use_case.choose_recipe;

import entity.RecipeInformation;

import java.util.List;

public class ChooseRecipeOutputData {

    List<String> recipeDetails;
    private Boolean favouriteFilled = false;

    /**
     * Constructs a new ChooseRecipeOutputData object with the specified recipe details.
     * @param recipeDetails the details of the recipe
     */
    public ChooseRecipeOutputData(List<String> recipeDetails) {
        this.recipeDetails = recipeDetails;
    }

    /**
     * Gets the details of the recipe.
     * @return a list of strings representing the details of the recipe
     */
    public List<String> getRecipeDetails() {return this.recipeDetails;}



    /**
     * Sets the favorite status of the recipe.
     * @param favouriteFilled the favorite status to set
     */
    public void setFavouriteFilled(Boolean favouriteFilled){
        this.favouriteFilled = favouriteFilled;
    }

    /**
     * Gets the status of whether recipe is favourited by user.
     * @return the favorite status
     */
    public Boolean getFavouriteFilled(){
        return favouriteFilled;
    }
}
