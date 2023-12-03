package use_case.nutrition_detail;

import interface_adapter.ViewManagerModel;
import interface_adapter.choose_recipe.ChooseRecipeViewModel;
import interface_adapter.nutrition_detail.NutritionDetailController;
import interface_adapter.nutrition_detail.NutritionDetailPresenter;
import interface_adapter.nutrition_detail.NutritionDetailViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

public class NutritionDetailCoverageTest {

    @Mock
    private NutritionDetailDataAccessInterface mockDataAccess;

    @Mock
    private NutritionDetailOutputBoundary mockOutputBoundary;

    @Mock
    private NutritionDetailInputBoundary mockInteractor;

    @InjectMocks
    private NutritionDetailInteractor nutritionDetailInteractor;

    private NutritionDetailController mockNutritionDetailController;

    @Mock
    private ViewManagerModel mockViewManagerModel;

    @Mock
    private ChooseRecipeViewModel mockChooseRecipeViewModel;

    @Mock
    private NutritionDetailViewModel mockNutritionDetailViewModel;

    @InjectMocks
    private NutritionDetailPresenter nutritionDetailPresenter;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        nutritionDetailInteractor = new NutritionDetailInteractor(mockDataAccess, mockOutputBoundary);
        mockNutritionDetailController = new NutritionDetailController(mockInteractor);
    }

    @Test
    public void testInteractor() {
        // Given
        String nutritionId = "123";

        // When
        nutritionDetailInteractor.displayNutritionLabelImage(nutritionId);

        // Then
        // Verify that the displayNutritionLabelImage method is called on the dataAccess
        verify(mockDataAccess).displayNutritionLabelImage(nutritionId);
    }

    @Test
    void testController() {
        // Given
        String nutritionId = "456";

        // When
        mockNutritionDetailController.displayNutritionLabelImage(nutritionId);

        // Then
        // Verify that the displayNutritionLabelImage method is called on the mockInteractor
        verify(mockInteractor).displayNutritionLabelImage(nutritionId);
    }

    @Test
    void testPresenter() {
        // Given
        NutritionDetailOutputData outputData = new NutritionDetailOutputData(/* provide necessary data */);

        // When
        nutritionDetailPresenter.prepareShowNutritionDetailView(outputData);

        // Then
        // Verify that setActiveView and firePropertyChanged methods are called on viewManagerModel
        verify(mockViewManagerModel).setActiveView(mockNutritionDetailViewModel.getViewName());
        verify(mockViewManagerModel).firePropertyChanged();

        // Optionally, you can also assert other expectations or state changes based on your specific implementation.
        // For example, check the updated active view after the method is called.
        assertEquals(mockNutritionDetailViewModel.getViewName(), mockViewManagerModel.getActiveView());
    }
}
