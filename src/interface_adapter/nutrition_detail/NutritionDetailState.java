package interface_adapter.nutrition_detail;

import use_case.choose_recipe.ChooseRecipeOutputData;

import java.util.List;

public class NutritionDetailState {

    private List<String> recipe = null;

    public NutritionDetailState(){
    }

    public void setRecipe(List<String> recipe) {this.recipe = recipe;}

    public List<String> getRecipe() { return this.recipe;}
}
