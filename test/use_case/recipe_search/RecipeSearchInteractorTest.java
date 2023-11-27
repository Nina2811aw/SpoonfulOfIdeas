package use_case.recipe_search;

import data_access.SpoonacularDataAccessObject;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecipeSearchInteractorTest {

    @Test
    public void successTest() {
        RecipeSearchDataAccessInterface dataAccessObject = new SpoonacularDataAccessObject();

        RecipeSearchOutputBoundary recipeSearchPresenter = new RecipeSearchOutputBoundary() {
            @Override
            public void prepareChooseRecipeView(RecipeSearchOutputData recipeSearchOutputData) {
                assertTrue(recipeSearchOutputData.getRecipeIDList().size() > 0);
            }

            @Override
            public void prepareNoRecipeFoundView() {
                assertTrue(true);
            }
        };

        RecipeSearchInputData inputData = new RecipeSearchInputData("tomato", "", "", "", 0, 1000, 0, 1000, 0, 5000, 0, 5000);

        RecipeSearchInteractor recipeSearchInteractor = new RecipeSearchInteractor(dataAccessObject, recipeSearchPresenter);

        recipeSearchInteractor.execute(inputData);

        RecipeSearchInputData inputDataFail = new RecipeSearchInputData("tomato", "", "", "", 0, 1000, 0, 1000, 0, 5000, 0, 5000);

        recipeSearchInteractor.execute(inputDataFail);
    }

    @Test
    public void noRecipesFoundTest(){



    }
}