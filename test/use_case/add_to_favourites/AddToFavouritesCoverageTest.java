package use_case.add_to_favourites;

import interface_adapter.ViewManagerModel;
import interface_adapter.add_to_favourites.AddToFavouritesController;
import interface_adapter.add_to_favourites.AddToFavouritesPresenter;
import interface_adapter.add_to_favourites.AddToFavouritesState;
import interface_adapter.nutrition_detail.NutritionDetailState;
import interface_adapter.nutrition_detail.NutritionDetailViewModel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import use_case.add_to_favourites.*;

import static org.mockito.Mockito.*;

public class AddToFavouritesCoverageTest {

    private AddToFavouritesDataAccessInterface dataAccessMock;
    private AddToFavouritesOutputBoundary presenterMock;
    private AddToFavouritesInteractor interactor;

    private ViewManagerModel viewManagerModelMock;
    private NutritionDetailViewModel nutritionDetailViewModelMock;
    private AddToFavouritesPresenter addToFavouritesPresenter;

    private AddToFavouritesController addToFavouritesController;
    private AddToFavouritesInputBoundary addToFavouritesInteractorMock;

    @Mock
    private ViewManagerModel viewManagerModel;

    @Mock
    private NutritionDetailViewModel nutritionDetailViewModel;

    @InjectMocks
    private AddToFavouritesPresenter addToFavouritesPresentermock;

    @Before
    public void setUp() {
        dataAccessMock = mock(AddToFavouritesDataAccessInterface.class);
        presenterMock = mock(AddToFavouritesOutputBoundary.class);
        interactor = new AddToFavouritesInteractor(dataAccessMock, presenterMock);

        viewManagerModelMock = mock(ViewManagerModel.class);
        nutritionDetailViewModelMock = mock(NutritionDetailViewModel.class);
        addToFavouritesPresenter = new AddToFavouritesPresenter(viewManagerModelMock, nutritionDetailViewModelMock);
        addToFavouritesInteractorMock = mock(AddToFavouritesInputBoundary.class);
        addToFavouritesController = new AddToFavouritesController(addToFavouritesInteractorMock);
    }

    @Test
    public void testInteractor() {
        // Arrange
        AddToFavouritesInputData input = new AddToFavouritesInputData("Recipe Title", "Recipe ID");

        // Act
        interactor.execute(input);

        // Assert
        // Verify that AddToFavourites method is called on the dataAccessObject
        verify(dataAccessMock).AddToFavourites(input.getID(), input.getTitle());

        // Verify that getFavourites method is called on the dataAccessObject
        verify(dataAccessMock).getFavourites();

        // Verify that prepareSuccessView method is called on the presenter with the correct output data
        verify(presenterMock).prepareSuccessView(any(AddToFavouritesOutputData.class));
    }
    @Test
    public void testController() {
        // Arrange
        String recipeTitle = "Test Recipe";
        String recipeId = "123";

        // Act
        addToFavouritesController.execute(recipeTitle, recipeId);

        // Assert
        // Verify that execute method is called on addToFavouritesInteractorMock with the expected input
        verify(addToFavouritesInteractorMock).execute(any(AddToFavouritesInputData.class));

    }

  /*  @Test
    public void testPresenter() {
        // Arrange
        AddToFavouritesOutputData outputData = new AddToFavouritesOutputData("New Favourites");
        outputData.setFavouriteFilled(true);

        AddToFavouritesState addToFavouritesState = new AddToFavouritesState();
        NutritionDetailState nutritionDetailState = new NutritionDetailState();

        when(nutritionDetailViewModel.getAddToFavouritesState()).thenReturn(addToFavouritesState);

        // Act
        addToFavouritesPresenter.prepareSuccessView(outputData);

        // Assert
        verify(nutritionDetailViewModel).getAddToFavouritesState();
        verify(nutritionDetailViewModel).getState();

        verify(nutritionDetailViewModel.getAddToFavouritesState()).setFavourites("New Favourites");
        verify(nutritionDetailViewModel.getState()).setFavouritesFilled(true);

        verify(nutritionDetailViewModel).setState(nutritionDetailState);
        verify(nutritionDetailViewModel).setAddToFavouritesState(addToFavouritesState);
        verify(nutritionDetailViewModel).firePropertyChanged();

        verify(viewManagerModel).setActiveView(nutritionDetailViewModel.getViewName());
        verify(viewManagerModel).firePropertyChanged();
    }*/
    }



