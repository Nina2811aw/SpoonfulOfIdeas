package interface_adapter.choose_recipe;

import entity.RecipeInformation;

import java.util.List;

public class ChooseRecipeState {

    public ChooseRecipeState(List<RecipeInformation> recipeIdeasList) {
        this.recipeIdeasList = recipeIdeasList;
    }

    public ChooseRecipeState(){

    }

    public List<RecipeInformation> getRecipeIdeasList() {
        return recipeIdeasList;
    }

    public void setRecipeIdeasList(List<RecipeInformation> recipeIdeasList) {
        this.recipeIdeasList = recipeIdeasList;
    }

    List<RecipeInformation> recipeIdeasList;



}
