package interface_adapter.back_to_choose;

import interface_adapter.ViewManagerModel;
import interface_adapter.choose_recipe.ChooseRecipeState;
import interface_adapter.choose_recipe.ChooseRecipeViewModel;
import use_case.back_to_choose.BackToChooseOutputBoundary;
import use_case.back_to_choose.BackToChooseOutputData;


public class BackToChoosePresenter implements BackToChooseOutputBoundary {

    private final BackToChooseViewModel backToChooseViewModel;

    private final ChooseRecipeViewModel chooseRecipeViewModel;

    private ViewManagerModel viewManagerModel;

    public BackToChoosePresenter(ChooseRecipeViewModel chooseRecipeViewModel, ViewManagerModel viewManagerModel, BackToChooseViewModel backToChooseViewModel){
        this.backToChooseViewModel = backToChooseViewModel;
        this.viewManagerModel = viewManagerModel;
        this.chooseRecipeViewModel = chooseRecipeViewModel;
    }

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
