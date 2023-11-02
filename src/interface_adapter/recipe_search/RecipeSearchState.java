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
    private Cuisine cuisine;
    private Protein protein;
    private Fat fat;
    private Carbs carbs;
    private Calories calories;


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

    public Cuisine getCuisine() {
        return cuisine;
    }

    public void setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
    }

    public Protein getProtein() {
        return protein;
    }

    public void setProtein(Protein protein) {
        this.protein = protein;
    }

    public Fat getFat() {
        return fat;
    }

    public void setFat(Fat fat) {
        this.fat = fat;
    }

    public Carbs getCarbs() {
        return carbs;
    }

    public void setCarbs(Carbs carbs) {
        this.carbs = carbs;
    }

    public Calories getCalories() {
        return calories;
    }

    public void setCalories(Calories calories) {
        this.calories = calories;
    }
}
