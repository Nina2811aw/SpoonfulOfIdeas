package DAO;

import data_access.FavouritesDataAccessObject;
import entity.RecipeInformation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class DAOFavouriteCoverage {

    private FavouritesDataAccessObject createDaoWithTempFile() throws IOException {
        File tempFile = File.createTempFile("favouritesTest", ".csv");
        tempFile.deleteOnExit();
        return new FavouritesDataAccessObject(tempFile.getAbsolutePath());
    }

    @Test
    public void addToFavouritesAndIsFavouriteTest() throws IOException {
        FavouritesDataAccessObject dao = createDaoWithTempFile();

        String recipeId = "1";
        String recipeTitle = "Test Recipe";

        // Add a new favourite
        dao.AddToFavourites(recipeId, recipeTitle);
        assertTrue(dao.isFavourite(recipeId));

        // Remove an existing favourite
        dao.AddToFavourites(recipeId, recipeTitle);
        assertFalse(dao.isFavourite(recipeId));
    }

    @Test
    public void getFavouritesTest() throws IOException {
        FavouritesDataAccessObject dao = createDaoWithTempFile();

        dao.AddToFavourites("1", "Test Recipe");
        String favourites = dao.getFavourites();

        assertTrue(favourites.contains("Test Recipe"));
    }

    @Test
    public void getFavouritesListTest() throws IOException {
        FavouritesDataAccessObject dao = createDaoWithTempFile();

        String recipeId = "1";
        String recipeTitle = "Test Recipe";
        dao.AddToFavourites(recipeId, recipeTitle);

        List<RecipeInformation> favouritesList = dao.getFavouritesList();

        assertEquals(1, favouritesList.size());
        assertEquals(recipeTitle, favouritesList.get(0).getTitle());
    }
}