package use_case.back_to_choose;

import entity.RecipeInformation;

import java.util.List;

public class BackToChooseOutputData {



    private final List<RecipeInformation> recipeInfoList;

    /*This public method creates a BackToChooseOutputData object, taking in a list of RecipeInformation.
    @param recipeInfoList is a list of RecipeInformation. */

    public BackToChooseOutputData(List<RecipeInformation> recipeInfoList) {
        this.recipeInfoList = recipeInfoList;
    }

    //This public method returns a list of RecipeInformation.

    public List<RecipeInformation> getRecipeInfoList(){return recipeInfoList;}
}
