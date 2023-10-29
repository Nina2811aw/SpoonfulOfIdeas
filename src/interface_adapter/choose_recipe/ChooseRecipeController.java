package interface_adapter.choose_recipe;

import use_case.choose_recipe.ChooseRecipeInputBoundary;
import use_case.choose_recipe.ChooseRecipeInputData;

public class ChooseRecipeController {

    final ChooseRecipeInputBoundary chooseRecipeInteractor;


    public ChooseRecipeController(ChooseRecipeInputBoundary chooseRecipeInteractor) {
        this.chooseRecipeInteractor = chooseRecipeInteractor;
    }

    // parameters have to be specified
    public void execute(){
        ChooseRecipeInputData chooseRecipeInputData = null; // has to be replaced by actual input data
        this.chooseRecipeInteractor.execute(chooseRecipeInputData);
    }
}
