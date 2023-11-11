package interface_adapter.choose_recipe;

import entity.RecipeInformation;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class ChooseRecipeState {
    private List<RecipeInformation> recipeInformation;

    public ChooseRecipeState() {
        recipeInformation = new ArrayList<RecipeInformation>();

        recipeInformation.add(new RecipeInformation(2,"hello"));

    }

    public List<String> getRecipeNames() {
        List<String> recipeNames = new ArrayList<>();

        for (int i = 0; i < (recipeInformation).size(); i++){
            recipeNames.add(recipeInformation.get(i).getTitle());
            }

        return recipeNames;
    }

    public void setRecipeIdeasList(List<RecipeInformation> recipeIdeasList) {
        this.recipeInformation = recipeIdeasList;
    }




}
