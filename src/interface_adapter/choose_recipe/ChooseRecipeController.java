package interface_adapter.choose_recipe;

import entity.RecipeInformation;
import use_case.choose_recipe.ChooseRecipeInputBoundary;
import use_case.choose_recipe.ChooseRecipeInputData;
import java.util.List;
public class ChooseRecipeController {

    final ChooseRecipeInputBoundary chooseRecipeInteractor;

    /**
     * Constructor sets up controller to have access to the use case interactor to call upon it.
     * @param chooseRecipeInteractor the interactor that handles the choose recipe logic
     */
    public ChooseRecipeController(ChooseRecipeInputBoundary chooseRecipeInteractor) {
        this.chooseRecipeInteractor = chooseRecipeInteractor;
    }

    // parameters have to be specified
    /**
     * Executes the core operation for when a user chooses a specific recipe to view.
     * @param recipeInfo the information about the chosen recipe
     */
    public void execute(RecipeInformation recipeInfo){
        ChooseRecipeInputData chooseRecipeInputData = new ChooseRecipeInputData(recipeInfo);
        chooseRecipeInteractor.execute(chooseRecipeInputData);
    }
}
