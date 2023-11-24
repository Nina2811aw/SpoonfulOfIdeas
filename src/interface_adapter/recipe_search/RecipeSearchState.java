package interface_adapter.recipe_search;

import use_case.recipe_search.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RecipeSearchState {
    private ArrayList<String> ingredients = new ArrayList<>();

    private boolean dietChosen = false;
    private boolean intoleranceChosen = false;

    public RecipeSearchState() {
        diets = new HashMap<>();
        intolerances = new HashMap<>();

        diets.put("glutenfree", false);
        diets.put("vegetarian", false);
        diets.put("vegan", false);
        diets.put("keto", false);
        diets.put("paleo", false);

        intolerances.put("peanut", false);
        intolerances.put("soy", false);
        intolerances.put("dairy", false);
    }

    public Map<String, Boolean> getDiets() {
        return diets;
    }

    public void setDiets(Map<String, Boolean> diets) {
        this.diets = diets;
    }

    public Map<String, Boolean> getIntolerances() {
        return intolerances;
    }

    public void setIntolerances(Map<String, Boolean> intolerances) {
        this.intolerances = intolerances;
    }

    private Map<String, Boolean> diets;
    private Map<String, Boolean> intolerances;

    /*private boolean glutenFree = false;
    private boolean vegetarian = false;
    private boolean vegan = false;
    private boolean keto = false;
    private boolean paleo = false;
    private boolean peanutIntolerance = false;
    private boolean dairyIntolerance = false;
    private boolean soyIntolerance = false;*/
    private String cuisine = "";
    private String protein = "no protein restriction";
    private String fat = "no fat restriction";
    private String carbs = "no carbs restriction";


    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    private String calories = "no calorie restriction";



    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public void addIngredients(String ingredients) {
        this.ingredients.add(ingredients);
    }

    public boolean isGlutenFree() {
        return diets.get("glutenfree");
    }

    public void setGlutenFree(boolean glutenFree) {
        diets.put("glutenfree", glutenFree);
    }

    public boolean isVegan() {
        return diets.get("vegan");
    }

    public void setVegan(boolean vegan) {
        diets.put("vegan", vegan);
    }

    public boolean isKeto() {
        return diets.get("keto");
    }

    public void setKeto(boolean keto) {
        diets.put("keto", keto);
    }

    public boolean isPaleo() {
        return diets.get("paleo");
    }

    public void setPaleo(boolean paleo) {
        diets.put("paleo", paleo);
    }

    public boolean isVegetarian() {
        return diets.get("vegetarian");
    }

    public void setVegetarian(boolean vegetarian) {
        diets.put("vegetarian", vegetarian);
    }

    public boolean isPeanutIntolerance() {
        return intolerances.get("peanut");
    }

    public void setPeanutIntolerance(boolean peanutIntolerance) {
        intolerances.put("peanut", peanutIntolerance);
    }

    public boolean isDairyIntolerance() {
        return intolerances.get("dairy");
    }

    public void setDairyIntolerance(boolean dairyIntolerance) {
        intolerances.put("dairy", dairyIntolerance);
    }

    public boolean isSoyIntolerance() {
        return intolerances.get("soy");
    }

    public void setSoyIntolerance(boolean soyIntolerance) {
        intolerances.put("soy", soyIntolerance);
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

    public boolean isDietChosen() {
        return dietChosen;
    }

    public void setDietChosen(boolean dietChosen) {
        this.dietChosen = dietChosen;
    }

    public boolean isIntoleranceChosen() {
        return intoleranceChosen;
    }

    public void setIntoleranceChosen(boolean intoleranceChosen) {
        this.intoleranceChosen = intoleranceChosen;
    }
}
