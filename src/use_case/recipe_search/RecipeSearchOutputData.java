package use_case.recipe_search;

import entity.RecipeInformation;

import java.util.List;

public class RecipeSearchOutputData {


    public RecipeSearchOutputData(List<RecipeInformation> recipeIDList) {
        this.recipeIDList = recipeIDList;
    }

    public List<RecipeInformation> getRecipeIDList() {
        return recipeIDList;
    }


    List<RecipeInformation> recipeIDList;




}
