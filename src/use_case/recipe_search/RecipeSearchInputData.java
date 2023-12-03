package use_case.recipe_search;


import java.util.ArrayList;

public class RecipeSearchInputData {

    // stores the user input which specifies the search

    // diets and intolerances are initialized as Strings to make the API call easier
    private String ingredients;
    private String diets;
    private String cuisine;
    private String intolerances;
    private int minProtein;
    private int maxProtein;
    private int minFat;
    private int maxFat;
    private int minCarbs;
    private int maxCarbs;
    private int minCalories;
    private int maxCalories;


    public RecipeSearchInputData(String ingredients, String diets, String cuisine, String intolerances, int minProtein, int maxProtein, int minFat, int maxFat, int minCarbs, int maxCarbs, int minCalories, int maxCalories) {
        this.ingredients = ingredients;
        this.diets = diets;
        this.cuisine = cuisine;
        this.intolerances = intolerances;
        this.minProtein = minProtein;
        this.maxProtein = maxProtein;
        this.minFat = minFat;
        this.maxFat = maxFat;
        this.minCarbs = minCarbs;
        this.maxCarbs = maxCarbs;
        this.minCalories = minCalories;
        this.maxCalories = maxCalories;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getDiets() {
        return diets;
    }

    public String getCuisines() {
        return cuisine;
    }

    public String getAllergies() {
        return intolerances;
    }

    public int getMinProtein() {
        return minProtein;
    }

    public int getMaxFat() {
        return maxFat;
    }

    public int getMinCarbs() {
        return minCarbs;
    }

    public int getMaxCarbs() {
        return maxCarbs;
    }

    public int getMinCalories() {
        return minCalories;
    }

    public int getMaxCalories() {
        return maxCalories;
    }

    public int getMaxProtein() {
        return maxProtein;
    }


    public int getMinFat() {
        return minFat;
    }

}
