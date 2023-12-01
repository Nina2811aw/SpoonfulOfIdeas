package use_case.add_to_favourites;

import data_access.FavouritesDataAccessObject;
import entity.RecipeInformation;
import org.junit.After;
import org.junit.Test;
import java.util.*;

import java.io.IOException;

import static org.junit.Assert.*;

public class AddToFavouritesInteractorTest {

    @Test
    public void executeTest() {
        FavouritesDataAccessObject dataAccessObject;

        try{
            dataAccessObject = new FavouritesDataAccessObject("./favourites.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String title = "Red Lentil Soup with Chicken and Turnips";
        AddToFavouritesOutputBoundary presenter = new AddToFavouritesOutputBoundary() {
            @Override
            public void prepareSuccessView(AddToFavouritesOutputData output) {
                String favourites = output.getFavourites();
                assertTrue(favourites.contains(title));
            }
        };
        AddToFavouritesInputData inputData = new AddToFavouritesInputData(title, "715415");

        AddToFavouritesInteractor addToFavouritesInteractor = new AddToFavouritesInteractor(dataAccessObject, presenter);

        addToFavouritesInteractor.execute(inputData);

    }
}