package use_case.choose_recipe;

import data_access.FavouritesDataAccessObject;
import data_access.SpoonacularDataAccessObject;
import data_access.UnifiedRecipeDataAccessObject;
import entity.RecipeInformation;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ChooseRecipeInteractorTest {

    @Test
    public void executeTest() throws IOException {
        ChooseRecipeDataAccessInterface dataAccessObject = new UnifiedRecipeDataAccessObject(new SpoonacularDataAccessObject(),
                new FavouritesDataAccessObject("./favourites.csv"));

        ChooseRecipeOutputBoundary chooseRecipePresenter = new ChooseRecipeOutputBoundary() {
            @Override
            public void prepareRecipeDetailsSuccessView(ChooseRecipeOutputData chooseRecipeOutputData) {
                assertFalse(chooseRecipeOutputData.getRecipeDetails().isEmpty());
            }
        };

        RecipeInformation information = new RecipeInformation(716429, "Pasta with Garlic, Scallions, Cauliflower & Breadcrumbs");
        ChooseRecipeInputData inputData = new ChooseRecipeInputData(information);

        ChooseRecipeInteractor chooseRecipeInteractor = new ChooseRecipeInteractor(dataAccessObject, chooseRecipePresenter);

        chooseRecipeInteractor.execute(inputData);
    }
}