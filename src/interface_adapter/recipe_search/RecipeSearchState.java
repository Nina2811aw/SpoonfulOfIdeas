package interface_adapter.recipe_search;

import use_case.recipe_search.*;

public class RecipeSearchState {
    private String ingredients = "";
    private boolean glutenFree = false;
    private boolean vegetarian = false;
    private boolean vegan = false;
    private boolean keto = false;
    private boolean paleo = false;
    private boolean peanutIntolerance = false;
    private boolean dairyIntolerance = false;
    private boolean soyIntolerance = false;
    private String cuisine;
    private String protein;
    private String fat;
    private String carbs;

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    private String calories;


    public RecipeSearchState(){

    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public boolean isGlutenFree() {
        return glutenFree;
    }

    public void setGlutenFree(boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    public boolean isVegan() {
        return vegan;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }

    public boolean isKeto() {
        return keto;
    }

    public void setKeto(boolean keto) {
        this.keto = keto;
    }

    public boolean isPaleo() {
        return paleo;
    }

    public void setPaleo(boolean paleo) {
        this.paleo = paleo;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public boolean isPeanutIntolerance() {
        return peanutIntolerance;
    }

    public void setPeanutIntolerance(boolean peanutIntolerance) {
        this.peanutIntolerance = peanutIntolerance;
    }

    public boolean isDairyIntolerance() {
        return dairyIntolerance;
    }

    public void setDairyIntolerance(boolean dairyIntolerance) {
        this.dairyIntolerance = dairyIntolerance;
    }

    public boolean isSoyIntolerance() {
        return soyIntolerance;
    }

    public void setSoyIntolerance(boolean soyIntolerance) {
        this.soyIntolerance = soyIntolerance;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public String getFat() {
        return fat;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }

    public String getCarbs() {
        return carbs;
    }

    public void setCarbs(String carbs) {
        this.carbs = carbs;
    }
}
