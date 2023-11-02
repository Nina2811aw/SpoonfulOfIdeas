package use_case.recipe_search;

import java.util.List;

public class RecipeSearchOutputData {


    public List<Integer> getRecipeIDList() {
        return recipeIDList;
    }

    public void setRecipeIDList(List<Integer> recipeIDList) {
        this.recipeIDList = recipeIDList;
    }

    public RecipeSearchOutputData(List<Integer> recipeIDList) {
        this.recipeIDList = recipeIDList;
    }

    List<Integer> recipeIDList;




}
