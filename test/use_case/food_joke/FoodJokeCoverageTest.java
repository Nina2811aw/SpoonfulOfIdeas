package use_case.food_joke;

import data_access.SpoonacularDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.add_to_favourites.AddToFavouritesController;
import interface_adapter.add_to_favourites.AddToFavouritesPresenter;
import interface_adapter.food_joke.FoodJokeController;
import interface_adapter.food_joke.FoodJokePresenter;
import interface_adapter.food_joke.FoodJokeState;
import interface_adapter.food_joke.FoodJokeViewModel;
import interface_adapter.nutrition_detail.NutritionDetailViewModel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import use_case.add_to_favourites.*;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class FoodJokeCoverageTest {
    private FoodJokeController foodJokeController;
    private FoodJokeInputBoundary foodJokeInteractorMock;
    @Mock
    private FoodJokeViewModel foodJokeViewModel;

    @InjectMocks
    private FoodJokePresenter foodJokePresenter;
    @Mock
    private FoodJokeDataAccessInterface foodJokeDataAccessObject;


    @InjectMocks
    private FoodJokeInteractor foodJokeInteractor;
    @Before
    public void setUp() {
        foodJokeInteractorMock = mock(FoodJokeInputBoundary.class);
        foodJokeViewModel = mock(FoodJokeViewModel.class);
        foodJokePresenter = new FoodJokePresenter(foodJokeViewModel);
        foodJokeController = new FoodJokeController(foodJokeInteractorMock);
        foodJokeDataAccessObject = mock(FoodJokeDataAccessInterface.class);

    }
    @Test
    public void testInteractor(){
        FoodJokeDataAccessInterface dataAccessObject = new SpoonacularDataAccessObject();

        FoodJokeOutputBoundary foodJokePresenter = new FoodJokeOutputBoundary() {
            @Override
            public void prepareJokeView(FoodJokeOutputData foodJokeOutputData) {
                assertNotNull(foodJokeOutputData.getJoke());
            }
        };

        FoodJokeInteractor foodJokeInteractor = new FoodJokeInteractor(dataAccessObject, foodJokePresenter);
        foodJokeInteractor.execute();
    }

    @Test
    public void testController() {
        // Act
        foodJokeController.execute();

        // Assert
        // Verify that execute method is called on addToFavouritesInteractorMock with the expected input
        verify(foodJokeInteractorMock).execute();

    }

    @Test
    public void testPresenter() {
        // Arrange
        FoodJokeOutputData outputData = new FoodJokeOutputData("haha very funny");
        FoodJokeState stateMock = mock(FoodJokeState.class);

        when(foodJokeViewModel.getState()).thenReturn(stateMock);

        // Act
        foodJokePresenter.prepareJokeView(outputData);

        // Assert
        verify(foodJokeViewModel).getState();
        verify(stateMock).setFoodJoke(outputData.getJoke());
        verify(foodJokeViewModel).setState(stateMock);
        verify(foodJokeViewModel).firePropertyChanged();
        // Additional assertions based on your specific implementation and requirements.
    }}

