package use_case.choose_recipe;

import data_access.FavouritesDataAccessObject;
import data_access.SpoonacularDataAccessObject;
import data_access.UnifiedRecipeDataAccessObject;
import entity.RecipeInformation;
import interface_adapter.ViewManagerModel;
import interface_adapter.add_to_favourites.AddToFavouritesController;
import interface_adapter.add_to_favourites.AddToFavouritesPresenter;
import interface_adapter.back_to_choose.BackToChooseController;
import interface_adapter.back_to_choose.BackToChoosePresenter;
import interface_adapter.choose_recipe.ChooseRecipeController;
import interface_adapter.choose_recipe.ChooseRecipePresenter;
import interface_adapter.choose_recipe.ChooseRecipeViewModel;
import interface_adapter.nutrition_detail.NutritionDetailState;
import interface_adapter.nutrition_detail.NutritionDetailViewModel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import use_case.add_to_favourites.*;
import use_case.back_to_choose.BackToChooseInputBoundary;
import use_case.back_to_choose.BackToChooseOutputData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class ChooseRecipeCoverageTest {
    @Mock
    private ViewManagerModel viewManagerModelMock;

    @Mock
    private ChooseRecipeViewModel chooseRecipeViewModelMock;

    @Mock
    private NutritionDetailViewModel nutritionDetailViewModelMock;
    private ChooseRecipePresenter chooseRecipePresenter;
    private ChooseRecipeInputBoundary chooseRecipeInteractorMock;

    private ChooseRecipeInteractor interactor;
    ChooseRecipeController chooseRecipeController;
    private ChooseRecipeOutputBoundary presenterMock;
    private ChooseRecipeDataAccessInterface dataAccessMock;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        dataAccessMock = mock(ChooseRecipeDataAccessInterface.class);
        presenterMock = mock(ChooseRecipeOutputBoundary.class);
        interactor = new ChooseRecipeInteractor(dataAccessMock, presenterMock);

        viewManagerModelMock = mock(ViewManagerModel.class);
        nutritionDetailViewModelMock = mock(NutritionDetailViewModel.class);
        chooseRecipePresenter = new ChooseRecipePresenter(viewManagerModelMock, chooseRecipeViewModelMock,nutritionDetailViewModelMock);
        chooseRecipeInteractorMock = mock(ChooseRecipeInputBoundary.class);
        chooseRecipeController = new ChooseRecipeController(chooseRecipeInteractorMock);
    }

    @Test
    public void testInteractor() throws IOException {
        // Arrange
        RecipeInformation recipe = new RecipeInformation(1, "Recipe1");
        ChooseRecipeInputData input = new ChooseRecipeInputData(recipe);
        List<String> recipeDetailsList = Arrays.asList("Detail1", "Detail2");
        when(dataAccessMock.getRecipeDetails(input)).thenReturn(recipeDetailsList);
        when(dataAccessMock.isFavourites(String.valueOf(recipe.getID()))).thenReturn(true);

        // Act
        interactor.execute(input);

        // Assert
        verify(dataAccessMock).getRecipeDetails(input);
        verify(dataAccessMock).isFavourites(String.valueOf(recipe.getID()));

        ChooseRecipeOutputData expectedOutput = new ChooseRecipeOutputData(recipeDetailsList);
        expectedOutput.setFavouriteFilled(true);
        verify(presenterMock).prepareRecipeDetailsSuccessView(any(ChooseRecipeOutputData.class));
    }


    @Test
    public void testPresenter() {
        // Arrange
        ChooseRecipePresenter presenter = new ChooseRecipePresenter(viewManagerModelMock, chooseRecipeViewModelMock, nutritionDetailViewModelMock);
        List<RecipeInformation> mockList = new ArrayList<>();
        mockList.add(new RecipeInformation(1234, "Yum"));
        ChooseRecipeOutputData chooseRecipeOutputData = new ChooseRecipeOutputData(Arrays.asList("Recipe1", "Ingredient1", "Ingredient2"));

        // Act
        presenter.prepareRecipeDetailsSuccessView(chooseRecipeOutputData);

        // Assert
        verify(nutritionDetailViewModelMock).firePropertyChanged();
        verify(viewManagerModelMock).setActiveView(nutritionDetailViewModelMock.getViewName());
        verify(viewManagerModelMock).firePropertyChanged();
    }

    @Test
    public void testController(){
        // Arrange
        RecipeInformation recipe = new RecipeInformation(1, "Recipe1");
        ChooseRecipeInputBoundary mockInputBoundary = mock(ChooseRecipeInputBoundary.class);
        ChooseRecipeController controller = new ChooseRecipeController(mockInputBoundary);

        // Act
        controller.execute(recipe);

        // Assert
        // Verify that execute method is called on addToFavouritesInteractorMock with the expected input
        verify(mockInputBoundary).execute(any(ChooseRecipeInputData.class));

    }
}
