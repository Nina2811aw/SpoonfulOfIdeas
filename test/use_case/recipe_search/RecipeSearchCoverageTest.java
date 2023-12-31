package use_case.recipe_search;

import data_access.SpoonacularDataAccessObject;
import entity.RecipeInformation;
import interface_adapter.ViewManagerModel;
import interface_adapter.choose_recipe.ChooseRecipeState;
import interface_adapter.choose_recipe.ChooseRecipeViewModel;
import interface_adapter.recipe_search.RecipeSearchController;
import interface_adapter.recipe_search.RecipeSearchPresenter;
import interface_adapter.recipe_search.RecipeSearchState;
import interface_adapter.recipe_search.RecipeSearchViewModel;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;
public class RecipeSearchCoverageTest {
    @Mock
    private RecipeSearchInputBoundary recipeSearchInteractor;

    @InjectMocks
    private RecipeSearchController recipeSearchController;
    @Mock
    private ViewManagerModel viewManagerModel;

    @Mock
    private RecipeSearchViewModel recipeSearchViewModel;

    @Mock
    private ChooseRecipeViewModel chooseRecipeViewModel;

    @InjectMocks
    private RecipeSearchPresenter recipeSearchPresenter;

    private RecipeSearchState state;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        state = new RecipeSearchState();
    }
    @Test
    public void successTest() {
        RecipeSearchDataAccessInterface dataAccessObject = new SpoonacularDataAccessObject();

        RecipeSearchOutputBoundary recipeSearchPresenter = new RecipeSearchOutputBoundary() {
            @Override
            public void prepareChooseRecipeView(RecipeSearchOutputData recipeSearchOutputData) {
                assertFalse(recipeSearchOutputData.getRecipeIDList().isEmpty());
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
    public void testController(){
        // Arrange
        String ingredients = "ingredient1,ingredient2";
        Map<String, Boolean> diets = new HashMap<>();
        diets.put("diet1", true);
        diets.put("diet2", false);
        Map<String, Boolean> intolerances = new HashMap<>();
        intolerances.put("intolerance1", true);
        intolerances.put("intolerance2", false);
        String cuisine = "cuisine1";
        String protein = "high protein";
        String fat = "low fat";
        String carbs = "high carbs";
        String calories = "low calorie";

        // Act
        recipeSearchController.execute(ingredients, diets, intolerances, cuisine, protein, fat, carbs, calories);

        // Assert
        verify(recipeSearchInteractor).execute(any(RecipeSearchInputData.class));
    }

    @Test
    public void testPrepareChooseRecipeView() {
        // Arrange
        List<RecipeInformation> mockList = new ArrayList<>();
        mockList.add(new RecipeInformation(1234, "Yum"));
        RecipeSearchOutputData outputData = new RecipeSearchOutputData(mockList);
        ChooseRecipeState chooseRecipeState = new ChooseRecipeState();
        when(chooseRecipeViewModel.getState()).thenReturn(chooseRecipeState);

        // Act
        recipeSearchPresenter.prepareChooseRecipeView(outputData);

        // Assert
        verify(chooseRecipeViewModel).setState(any(ChooseRecipeState.class));
        verify(chooseRecipeViewModel).firePropertyChanged();
        verify(viewManagerModel).setActiveView(chooseRecipeViewModel.getViewName());
        verify(viewManagerModel).firePropertyChanged();
    }

    @Test
    public void testPrepareNoRecipeFoundView() {
        // Act
        recipeSearchPresenter.prepareNoRecipeFoundView();

        // Assert
        verify(recipeSearchViewModel).firePropertyChanged();
    }

    @Test
    public void testDietsIntolerancesGettersSetters() {
        state.setGlutenFree(true);
        assertTrue(state.isGlutenFree());

        state.setVegan(true);
        assertTrue(state.isVegan());

        state.setKeto(true);
        assertTrue(state.isKeto());

        state.setPaleo(true);
        assertTrue(state.isPaleo());

        state.setVegetarian(true);
        assertTrue(state.isVegetarian());

        state.setPeanutIntolerance(true);
        assertTrue(state.isPeanutIntolerance());

        state.setDairyIntolerance(true);
        assertTrue(state.isDairyIntolerance());

        state.setSoyIntolerance(true);
        assertTrue(state.isSoyIntolerance());
    }

    @Test
    public void testCuisineProteinFatCarbsCaloriesGettersSetters() {
        state.setCuisine("Italian");
        assertEquals("Italian", state.getCuisine());

        state.setProtein("high protein");
        assertEquals("high protein", state.getProtein());

        state.setFat("low fat");
        assertEquals("low fat", state.getFat());

        state.setCarbs("high carbs");
        assertEquals("high carbs", state.getCarbs());

        state.setCalories("low calorie");
        assertEquals("low calorie", state.getCalories());
    }

    @Test
    public void testIngredientsHandling() {
        state.addIngredients("chicken");
        state.addIngredients("tomato");

        String ingredients = state.getIngredients();
        assertTrue(ingredients.contains("chicken"));
        assertTrue(ingredients.contains("tomato"));
    }

    @Test
    public void testDietIntoleranceChosen() {
        state.setDietChosen(true);
        assertTrue(state.isDietChosen());

        state.setIntoleranceChosen(true);
        assertTrue(state.isIntoleranceChosen());
    }

    @Test
    public void testCaloriesEnum() {
        testEnum(Calories.values(), "NORESTRICTION", "LOWCALORIE", "HIGHCALORIE");
    }

    @Test
    public void testCarbsEnum() {
        testEnum(Carbs.values(), "NORESTRICTION", "LOWCARB", "HIGHCARB");
    }

    @Test
    public void testCuisineEnum() {
        testEnum(Cuisine.values(), "NORESTRICTION", "AFRICAN", "CHINESE", "GERMAN", "MEXICAN", "INDIAN", "ITALIEN");
    }

    @Test
    public void testDietEnum() {
        testEnum(Diet.values(), "KETO", "VEGETERIAN", "GLUTENFREE", "VEGAN", "PALEO");
    }

    @Test
    public void testFatEnum() {
        testEnum(Fat.values(), "NORESTRICTION", "LOWFAT", "HIGHFAT");
    }

    @Test
    public void testProteinEnum() {
        testEnum(Protein.values(), "NORESTRICTION", "LOWPROTEIN", "HIGHPROTEIN");
    }
    @Test
    public void testAllergyEnum() {
        testEnum(Allergy.values(), "PEANUTS", "DAIRY", "SOY");
    }


    private <E extends Enum<E>> void testEnum(E[] enumValues, String... expectedNames) {
        assertEquals(expectedNames.length, enumValues.length);
        for (int i = 0; i < enumValues.length; i++) {
            assertEquals(expectedNames[i], enumValues[i].name());
        }
    }

}


