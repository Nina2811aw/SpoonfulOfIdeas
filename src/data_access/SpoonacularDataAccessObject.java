package data_access;

import use_case.choose_recipe.ChooseRecipeDataAccessInterface;
import use_case.choose_recipe.ChooseRecipeInputData;
import use_case.recipe_search.RecipeSearchDataAccessInterface;
import use_case.recipe_search.RecipeSearchInputData;

public class SpoonacularDataAccessObject implements RecipeSearchDataAccessInterface, ChooseRecipeDataAccessInterface {

    // we have to think about what exactly this method will return after having made the API call
    // the return type void has to be adapted adequately
    @Override
    public void getRecipeIdeas(RecipeSearchInputData recipeSearchInputData) {


    }

    @Override
    public void getRecipeDetails(ChooseRecipeInputData chooseRecipeInputData) {

    }
}
