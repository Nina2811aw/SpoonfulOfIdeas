package interface_adapter.choose_recipe;

import entity.RecipeInformation;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class ChooseRecipeState {
    private List<RecipeInformation> recipeIdeasList;

    public ChooseRecipeState() {
        recipeIdeasList = new ArrayList<>();
        recipeIdeasList.add(new RecipeInformation(2,"hello"));
    }

    public int get_length(){return recipeIdeasList.size();}

    public List<String> getRecipeNames() {
        List<String> recipeNames = new ArrayList<>();

        for (int i = 0; i < (recipeIdeasList).size(); i++){
            recipeNames.add(recipeIdeasList.get(i).getTitle());
            }

        return recipeNames;
    }

    public void setRecipeIdeasList(List<RecipeInformation> recipeIdeasList) {
        this.recipeIdeasList = recipeIdeasList;
    }




}
