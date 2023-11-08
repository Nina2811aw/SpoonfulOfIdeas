package data_access;

import entity.RecipeSpec;
import use_case.back_to_search.BackToSearchDataAccessInterface;
import use_case.recipe_search.RecipeSearchInputData;

public class RecipeSpecificationDataAccessObject implements BackToSearchDataAccessInterface {
    private final RecipeSpec recipeSpecification;

    public RecipeSpecificationDataAccessObject(RecipeSpec recipeSpecification) {
        this.recipeSpecification = recipeSpecification;
    }

    @Override
    public RecipeSpec getSpecification() {
        return recipeSpecification;
    }

    @Override
    public void setSpecification(RecipeSearchInputData recipeSearchInputData) {
        recipeSpecification.setIngredients(recipeSearchInputData.getIngredients());
        recipeSpecification.setDiets(recipeSearchInputData.getDiets());
        recipeSpecification.setCuisines(recipeSearchInputData.getCuisines());
        recipeSpecification.setIntolerances(recipeSearchInputData.getAllergies()); // naming scheme differs here!
        recipeSpecification.setMinProtein(recipeSearchInputData.getMinProtein());
        recipeSpecification.setMaxProtein(recipeSearchInputData.getMaxProtein());
        recipeSpecification.setMinFat(recipeSearchInputData.getMinFat());
        recipeSpecification.setMaxFat(recipeSearchInputData.getMaxFat());
        recipeSpecification.setMinCarbs(recipeSearchInputData.getMinCarbs());
        recipeSpecification.setMaxCarbs(recipeSearchInputData.getMaxCarbs());
        recipeSpecification.setMinCalories(recipeSearchInputData.getMinCalories());
        recipeSpecification.setMaxCalories(recipeSearchInputData.getMaxCalories());
    }
}
