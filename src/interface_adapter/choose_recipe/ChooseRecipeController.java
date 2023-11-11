package interface_adapter.choose_recipe;

import entity.RecipeInformation;
import use_case.choose_recipe.ChooseRecipeInputBoundary;
import use_case.choose_recipe.ChooseRecipeInputData;
import java.util.List;
public class ChooseRecipeController {

    final ChooseRecipeInputBoundary chooseRecipeInteractor;

    public ChooseRecipeController(ChooseRecipeInputBoundary chooseRecipeInteractor) {
        this.chooseRecipeInteractor = chooseRecipeInteractor;
    }

    // parameters have to be specified
    public void execute(List<RecipeInformation> recipeInfo){
        ChooseRecipeInputData chooseRecipeInputData = new ChooseRecipeInputData(recipeInfo);// has to be replaced by actual input data
        chooseRecipeInteractor.execute(chooseRecipeInputData);
    }
}
