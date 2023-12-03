package use_case.nutrition_detail;

public class NutritionDetailInteractor implements NutritionDetailInputBoundary {
    private final NutritionDetailDataAccessInterface dataAccess;

    public NutritionDetailInteractor(NutritionDetailDataAccessInterface dataAccess, NutritionDetailOutputBoundary nutritionDetailOutputBoundary) {
        this.dataAccess = dataAccess;
    }

    @Override
    public void displayNutritionLabelImage(String id) {
        dataAccess.displayNutritionLabelImage(id);
    }
}