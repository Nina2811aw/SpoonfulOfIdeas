package interface_adapter.nutrition_detail;

import use_case.nutrition_detail.NutritionDetailInputBoundary;
import use_case.nutrition_detail.NutritionDetailInputData;

public class NutritionDetailController {
    //final NutritionDetailInputBoundary nutritionDetailInputInteractor;

    final NutritionDetailInputBoundary nutritionDetailInteractor;


    public NutritionDetailController(NutritionDetailInputBoundary nutritionDetailInteractor) {
        this.nutritionDetailInteractor = nutritionDetailInteractor;
    }

    public void execute(){
        // constructor call has to be adapted dependent on the attributes of the input data
        NutritionDetailInputData nutritionDetailInputData = new NutritionDetailInputData();

        this.nutritionDetailInteractor.execute(nutritionDetailInputData);
    }
}
