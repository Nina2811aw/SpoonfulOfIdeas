package use_case.show_favourites;

import data_access.FavouritesDataAccessObject;
import org.junit.Before;
import org.junit.Test;
import use_case.recipe_search.RecipeSearchOutputBoundary;
import use_case.recipe_search.RecipeSearchOutputData;

import java.io.IOException;

import static org.junit.Assert.*;

public class ShowFavouritesInteractorTest {


    @Test
    public void executeTest() {
        FavouritesDataAccessObject dataAccessObject;

        try{
            dataAccessObject = new FavouritesDataAccessObject("./favourites.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        RecipeSearchOutputBoundary presenter = new RecipeSearchOutputBoundary() {
            @Override
            public void prepareChooseRecipeView(RecipeSearchOutputData recipeSearchOutputData) {
                if(!dataAccessObject.getFavouritesList().isEmpty()){
                    assertFalse(recipeSearchOutputData.getRecipeIDList().isEmpty());
                }
            }
            @Override
            public void prepareNoRecipeFoundView() {

            }
        };

        ShowFavouritesInteractor showFavouritesInteractor = new ShowFavouritesInteractor(dataAccessObject, presenter);

        showFavouritesInteractor.execute();

    }
}