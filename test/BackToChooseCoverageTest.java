
import entity.RecipeInformation;
import interface_adapter.ViewManagerModel;
import interface_adapter.back_to_choose.BackToChooseController;
import interface_adapter.back_to_choose.BackToChoosePresenter;
import interface_adapter.choose_recipe.ChooseRecipeViewModel;
import org.junit.Before;
import org.junit.Test;
import use_case.back_to_choose.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BackToChooseCoverageTest {

    private BackToChooseDataAccessInterface mockDataAccess;
    private BackToChooseOutputBoundary mockPresenter;
    private BackToChooseInteractor backToChooseInteractor;

    private ChooseRecipeViewModel chooseRecipeViewModel;
    private ViewManagerModel viewManagerModel;

    @Before
    public void setUp() {
        mockDataAccess = mock(BackToChooseDataAccessInterface.class);
        mockPresenter = mock(BackToChooseOutputBoundary.class);
        backToChooseInteractor = new BackToChooseInteractor(mockDataAccess, mockPresenter);

        // Initialize ChooseRecipeViewModel and ViewManagerModel mocks
        chooseRecipeViewModel = mock(ChooseRecipeViewModel.class);
        viewManagerModel = mock(ViewManagerModel.class);
    }

    @Test
    public void testInteractor() {
        // Arrange
        List<RecipeInformation> mockRecipeInfoList = new ArrayList<>();
        mockRecipeInfoList.add(new RecipeInformation(1234, "Yum"));

        when(mockDataAccess.getRecipeInformationList()).thenReturn(mockRecipeInfoList);

        // Act
        backToChooseInteractor.execute();

        // Assert
        verify(mockPresenter).prepareSuccessView(any(BackToChooseOutputData.class));
    }

    @Test
    public void testPresenter() {
        // Arrange
        BackToChoosePresenter presenter = new BackToChoosePresenter(chooseRecipeViewModel, viewManagerModel);
        List<RecipeInformation> mockList = new ArrayList<>();
        mockList.add(new RecipeInformation(1234, "Yum"));
        BackToChooseOutputData backToChooseOutputData = new BackToChooseOutputData(mockList);

        // Act
        presenter.prepareSuccessView(backToChooseOutputData);

        // Assert
        verify(chooseRecipeViewModel).firePropertyChanged();
        verify(viewManagerModel).setActiveView(chooseRecipeViewModel.getViewName());
        verify(viewManagerModel).firePropertyChanged();
    }
    @Test
    public void testController() {
        // Arrange
        BackToChooseInputBoundary mockInputBoundary = mock(BackToChooseInputBoundary.class);
        BackToChooseController controller = new BackToChooseController(mockInputBoundary);

        // Act
        controller.execute();

        // Assert
        verify(mockInputBoundary).execute();
    }
}

