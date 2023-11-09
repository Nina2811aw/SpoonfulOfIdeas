package interface_adapter.choose_recipe;

import use_case.choose_recipe.ChooseRecipeInputBoundary;
import use_case.choose_recipe.ChooseRecipeInputData;

import java.util.ArrayList;

public class ChooseRecipeController {

    final ChooseRecipeInputBoundary chooseRecipeInteractor;


    public ChooseRecipeController(ChooseRecipeInputBoundary chooseRecipeInteractor) {
        this.chooseRecipeInteractor = chooseRecipeInteractor;
    }

    // parameters have to be specified
    public void execute(){
        //ChooseRecipeInputData chooseRecipeInputData = new ChooseRecipeInputData();
        //this.chooseRecipeInteractor.execute(chooseRecipeInputData);
    }
}
