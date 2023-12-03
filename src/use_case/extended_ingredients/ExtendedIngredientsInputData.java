package use_case.extended_ingredients;

public class ExtendedIngredientsInputData {
    private final String recipeId;
    public ExtendedIngredientsInputData(String recipeId){
        this.recipeId = recipeId;
    }
    public String getRecipeId(){
        return recipeId;
    }
}
