package use_case.nutrition_detail;

public class NutritionDetailInputData {
    private final String recipeId;
    public  NutritionDetailInputData(String recipeId){
        this.recipeId = recipeId;
    }
    public String getRecipeId(){
        return recipeId;
    }
}
