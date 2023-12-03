package use_case.back_to_search;

import interface_adapter.back_to_search.BackToSearchController;
import interface_adapter.back_to_search.BackToSearchPresenter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import use_case.back_to_search.BackToSearchInputBoundary;
import use_case.back_to_search.BackToSearchInteractor;
import use_case.back_to_search.BackToSearchOutputBoundary;
import interface_adapter.ViewManagerModel;
import interface_adapter.recipe_search.RecipeSearchViewModel;


import org.mockito.Mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BackToSearchCoverageTest {

    @Mock
    private ViewManagerModel viewManagerModel;
    @Mock
    private RecipeSearchViewModel recipeSearchViewModel;
    @Mock
    private BackToSearchInputBoundary inputBoundary;
    @Mock
    private BackToSearchOutputBoundary presenter;


    @Test
    void controllerExecute(){
        BackToSearchController controller = new BackToSearchController(inputBoundary);
        controller.execute();
        verify(inputBoundary).execute();
    }

    @Test
    void interactorExecute() {
        BackToSearchInteractor backToSearchInteractor = new BackToSearchInteractor(presenter);
        backToSearchInteractor.execute();
        verify(presenter).prepareRecipeSearchView();
    }

    @Test
    void presenter(){
        BackToSearchPresenter presenterTester = new BackToSearchPresenter(viewManagerModel, recipeSearchViewModel);
        presenterTester.prepareRecipeSearchView();
        verify(viewManagerModel).firePropertyChanged();
    }
}