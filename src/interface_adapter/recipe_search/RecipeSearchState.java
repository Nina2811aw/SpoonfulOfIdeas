package interface_adapter.recipe_search;

public class RecipeSearchState {

    private String ingredients = "";

    public RecipeSearchState(){

    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
}
