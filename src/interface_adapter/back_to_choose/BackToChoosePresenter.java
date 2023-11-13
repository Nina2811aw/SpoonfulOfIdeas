package interface_adapter.back_to_choose;

import interface_adapter.ViewManagerModel;
import interface_adapter.choose_recipe.ChooseRecipeState;
import interface_adapter.choose_recipe.ChooseRecipeViewModel;
import use_case.back_to_choose.BackToChooseOutputBoundary;
import use_case.back_to_choose.BackToChooseOutputData;
/* The Presenter class for the back to choose use case. This updates the ChooseRecipeViewModel
* and the ViewManagerModel.
* @author Shreya Dubey
* */

public class BackToChoosePresenter implements BackToChooseOutputBoundary {


    private final ChooseRecipeViewModel chooseRecipeViewModel;

    private ViewManagerModel viewManagerModel;

    /*Creates a new BackToChoosePresenter when given a ChooseRecipeViewModel and a ViewManagerModel.
    * @param chooseRecipeViewModel is what will be updated by the presenter.
    * @param viewManagerModel is what will manage the active view. */
    public BackToChoosePresenter(ChooseRecipeViewModel chooseRecipeViewModel, ViewManagerModel viewManagerModel){

        this.viewManagerModel = viewManagerModel;
        this.chooseRecipeViewModel = chooseRecipeViewModel;
    }

    /*This public method implements the method in the BackToChooseOutputBoundary. It updates the ChooseRecipeViewModel,
    * and the ViewManagerModel based on the BackToChooseOutputData.
    * @param outputData is a BackToChooseOutputData object. */
    @Override
    public void prepareSuccessView(BackToChooseOutputData outputData) {

        ChooseRecipeState chooseRecipeState = chooseRecipeViewModel.getState();
        chooseRecipeState.setRecipeIdeasList(outputData.getRecipeInfoList());
        this.chooseRecipeViewModel.setState(chooseRecipeState);
        chooseRecipeViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(chooseRecipeViewModel.getViewName());
        viewManagerModel.firePropertyChanged();


    }
}
