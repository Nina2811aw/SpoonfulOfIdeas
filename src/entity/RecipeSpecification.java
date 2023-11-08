package entity;

import use_case.recipe_search.RecipeSearchInputData;

public class RecipeSpecification implements RecipeSpec {

    // contains the specifications the user chooses.
    private String ingredients;
    private String diets;
    private String cuisines;
    private String intolerances;
    private int minProtein;
    private int maxProtein;
    private int minFat;
    private int maxFat;
    private int minCarbs;
    private int maxCarbs;
    private int minCalories;
    private int maxCalories;

    public RecipeSpecification(){}; // object should not contain meaningful data on instantiation

    @Override
    public String getIngredients() {
        return ingredients;
    }

    @Override
    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String getDiets() {
        return diets;
    }

    @Override
    public void setDiets(String diets) {
        this.diets = diets;
    }

    @Override
    public String getCuisines() {
        return cuisines;
    }

    @Override
    public void setCuisines(String cuisines) {
        this.cuisines = cuisines;
    }

    @Override
    public String getIntolerances() {
        return intolerances;
    }

    @Override
    public void setIntolerances(String intolerances) {
        this.intolerances = intolerances;
    }

    @Override
    public int getMinProtein() {
        return minProtein;
    }

    @Override
    public void setMinProtein(int minProtein) {
        this.minProtein = minProtein;
    }

    @Override
    public int getMaxProtein() {
        return maxProtein;
    }

    @Override
    public void setMaxProtein(int maxProtein) {
        this.maxProtein = maxProtein;
    }

    @Override
    public int getMinFat() {
        return minFat;
    }

    @Override
    public void setMinFat(int minFat) {
        this.minFat = minFat;
    }

    @Override
    public int getMaxFat() {
        return maxFat;
    }

    @Override
    public void setMaxFat(int maxFat) {
        this.maxFat = maxFat;
    }

    @Override
    public int getMinCarbs() {
        return minCarbs;
    }

    @Override
    public void setMinCarbs(int minCarbs) {
        this.minCarbs = minCarbs;
    }

    @Override
    public int getMaxCarbs() {
        return maxCarbs;
    }

    @Override
    public void setMaxCarbs(int maxCarbs) {
        this.maxCarbs = maxCarbs;
    }

    @Override
    public int getMinCalories() {
        return minCalories;
    }

    @Override
    public void setMinCalories(int minCalories) {
        this.minCalories = minCalories;
    }

    @Override
    public int getMaxCalories() {
        return maxCalories;
    }

    @Override
    public void setMaxCalories(int maxCalories) {
        this.maxCalories = maxCalories;
    }
}
