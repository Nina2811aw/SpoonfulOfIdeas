package use_case.recipe_search;


import java.util.List;

public class RecipeSearchInputData {

    // stores the user input which specifies the search

    private String ingredients;
    private List<Diet> diets;
    private List<Cuisine> cuisines;
    private List<Allergy> allergies;
    private int minProtein;
    private int maxFat;
    private int minCarbs;
    private int maxCarbs;
    private int minCalories;
    private int maxCalories;


    public RecipeSearchInputData(String ingredients, List<Diet> diets, List<Cuisine> cuisines, List<Allergy> allergies, int minProtein, int maxFat, int minCarbs, int maxCarbs, int minCalories, int maxCalories) {
        this.ingredients = ingredients;
        this.diets = diets;
        this.cuisines = cuisines;
        this.allergies = allergies;
        this.minProtein = minProtein;
        this.maxFat = maxFat;
        this.minCarbs = minCarbs;
        this.maxCarbs = maxCarbs;
        this.minCalories = minCalories;
        this.maxCalories = maxCalories;
    }

    public String getIngredients() {
        return ingredients;
    }

    public List<Diet> getDiets() {
        return diets;
    }

    public List<Cuisine> getCuisines() {
        return cuisines;
    }

    public List<Allergy> getAllergies() {
        return allergies;
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
}
