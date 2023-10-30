package interface_adapter.nutrition_detail;

import use_case.choose_recipe.NutritionDetailInputBoundary;
import use_case.choose_recipe.NutritionDetailInputData;

public class NutritionDetailController {
    final NutritionDetailInputBoundary nutritionDetailInputInteractor;


    public NutritionDetailController(NutritionDetailInputBoundary nutritionDetailInputInteractor) {
        this.NutritionDetailInputInteractor = nutritionDetailInputInteractor;
    }

    public void execute(){
        NutritionDetailInputData nutritionDetailInputData = null;
        this.NutritionDetailInputInteractor.execute(nutritionDetailInputData);
    }
}
