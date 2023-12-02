package data_access;

import use_case.choose_recipe.ChooseRecipeDataAccessInterface;
import use_case.choose_recipe.ChooseRecipeInputData;

import java.util.List;

/**
 * Unified data access object that combines SpoonacularDataAccessObject and FavouritesDataAccessObject.
 * This class serves as an adapter that provides a unified interface for accessing recipe details
 * and favourites functionality.
 */
public class UnifiedRecipeDataAccessObject implements ChooseRecipeDataAccessInterface {

    private final SpoonacularDataAccessObject spoonacularDataAccessObject;
    private final FavouritesDataAccessObject favouritesDataAccessObject;

    /**
     * Constructs a UnifiedRecipeDataAccessObject with specified Spoonacular and Favourites DAOs.
     *
     * @param spoonacularDataAccessObject the data access object for Spoonacular API
     * @param favouritesDataAccessObject the data access object for managing favourites
     */
    public UnifiedRecipeDataAccessObject(SpoonacularDataAccessObject spoonacularDataAccessObject,
                                         FavouritesDataAccessObject favouritesDataAccessObject){
        this.spoonacularDataAccessObject = spoonacularDataAccessObject;
        this.favouritesDataAccessObject = favouritesDataAccessObject;
    }

    /**
     * Retrieves detailed information about a specified recipe.
     *
     * @param chooseRecipeInputData the data containing recipe ID and other parameters
     * @return a list of strings representing recipe details
     */
    @Override
    public List<String> getRecipeDetails(ChooseRecipeInputData chooseRecipeInputData) {
       return spoonacularDataAccessObject.getRecipeDetails(chooseRecipeInputData);
    }

    /**
     * Checks if a recipe is marked as a favourite.
     *
     * @param id the ID of the recipe to check
     * @return true if the recipe is a favourite, false otherwise
     */
    @Override
    public Boolean isFavourites(String id) {
        return favouritesDataAccessObject.isFavourite(id);
    }
}
