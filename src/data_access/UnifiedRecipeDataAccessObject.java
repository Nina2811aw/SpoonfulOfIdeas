package data_access;

import use_case.choose_recipe.ChooseRecipeDataAccessInterface;
import use_case.choose_recipe.ChooseRecipeInputData;

import java.util.List;

public class UnifiedRecipeDataAccessObject implements ChooseRecipeDataAccessInterface {

    SpoonacularDataAccessObject spoonacularDataAccessObject;
    FavouritesDataAccessObject favouritesDataAccessObject;

    public UnifiedRecipeDataAccessObject(SpoonacularDataAccessObject spoonacularDataAccessObject,
                                         FavouritesDataAccessObject favouritesDataAccessObject){
        this.spoonacularDataAccessObject = spoonacularDataAccessObject;
        this.favouritesDataAccessObject = favouritesDataAccessObject;
    }

    @Override
    public List<String> getRecipeDetails(ChooseRecipeInputData chooseRecipeInputData) {
       return spoonacularDataAccessObject.getRecipeDetails(chooseRecipeInputData);
    }

    @Override
    public Boolean isFavourites(String id) {
        return favouritesDataAccessObject.isFavourite(id);
    }
}
