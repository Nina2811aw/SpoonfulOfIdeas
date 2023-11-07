package entity;

import use_case.recipe_search.RecipeSearchInputData;

interface RecipeSpec {

    // Ingredients
    String getIngredients();
    void setIngredients(String ingredients);

    // Diets
    String getDiets();
    void setDiets(String diets);

    // Cuisines
    String getCuisines();
    void setCuisines(String cuisines);

    // Allergies
    String getAllergies();
    void setAllergies(String allergies);

    // Protein
    int getMinProtein();
    void setMinProtein(int minProtein);

    int getMaxProtein();
    void setMaxProtein(int maxProtein);

    // Fat
    int getMinFat();
    void setMinFat(int minFat);

    int getMaxFat();
    void setMaxFat(int maxFat);

    // Carbs
    int getMinCarbs();
    void setMinCarbs(int minCarbs);

    int getMaxCarbs();
    void setMaxCarbs(int maxCarbs);

    // Calories
    int getMinCalories();
    void setMinCalories(int minCalories);

    int getMaxCalories();
    void setMaxCalories(int maxCalories);
}
