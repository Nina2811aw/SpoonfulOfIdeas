package interface_adapter.nutrition_detail;
import use_case.nutrition_detail.NutritionDetailInputBoundary;

public class NutritionDetailController {

    private final NutritionDetailInputBoundary nutritionDetailInteractor;


    public NutritionDetailController(NutritionDetailInputBoundary nutritionDetailInteractor) {
        this.nutritionDetailInteractor = nutritionDetailInteractor;
    }

    public void displayNutritionLabelImage(String id){
        nutritionDetailInteractor.displayNutritionLabelImage(id);
    }
}
