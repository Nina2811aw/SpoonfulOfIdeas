package use_case.show_favourites;

import data_access.FavouritesDataAccessObject;
import interface_adapter.show_favourites.ShowFavouritesController;
import org.junit.Before;
import org.junit.Test;
import use_case.recipe_search.RecipeSearchOutputBoundary;
import use_case.recipe_search.RecipeSearchOutputData;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ShowFavouritesInteractorTest {


    @Test
    public void testInteractor() {
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

    @Test
    public void testController(){
        // Arrange
        ShowFavouritesInputBoundary mockInteractor = mock(ShowFavouritesInputBoundary.class);
        ShowFavouritesController controller = new ShowFavouritesController(mockInteractor);

        // Act
        controller.execute();

        // Assert
        verify(mockInteractor, times(1)).execute();
    }

    }
